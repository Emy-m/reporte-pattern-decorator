package modelo;

import java.io.File;

public class SinSobreescritura implements Exportador {

	private Report reporte;

	public SinSobreescritura(Report reporte) {
		this.reporte = reporte;
	}

	@Override
	public void export(File file) {
		if (file.exists()) {
			throw new IllegalArgumentException("El archivo ya existe...");
		}
		reporte.export(file);
	}

}
