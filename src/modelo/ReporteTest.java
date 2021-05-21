package modelo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ReporteTest {
	@Test
	public void exportarReporteArchivo() {
		Report reporte = new Report("reporte");
		File archivo = new File("C:\\Users\\Emy_m\\Desktop\\reporteTest.txt");
		assertDoesNotThrow(() -> {
			reporte.export(archivo);
		});
	}

	@Test
	public void exportarReporteArchivoSinSobreescribir() {
		Report reporte = new Report("reporte");
		SinSobreescritura reporteSinSobreescritura = new SinSobreescritura(reporte);
		File archivo = new File("C:\\Users\\Emy_m\\Desktop\\reporteTest.txt");
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assertThrows(IllegalArgumentException.class, () -> {
			reporteSinSobreescritura.export(archivo);
		});
	}

	@Test
	public void exportarReporteArchivoNulo() {
		Report reporte = new Report("reporte");
		assertThrows(IllegalArgumentException.class, () -> {
			reporte.export(null);
		});
	}
}
