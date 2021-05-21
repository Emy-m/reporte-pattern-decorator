package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Report implements Exportador {
	private String reporte;

	public Report(String reporte) {
		this.reporte = reporte;
	}

	public void export(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File es NULL; no puedo exportar...");
		}
		try {
			FileWriter escribirEnArchivo = new FileWriter(file);
			escribirEnArchivo.write(reporte);
			escribirEnArchivo.close();
		} catch (IOException e) {
			throw new RuntimeException("PathName incorrecta", e);
		}
	}
}