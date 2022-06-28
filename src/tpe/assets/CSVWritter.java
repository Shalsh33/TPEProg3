package src.tpe.assets;

import src.tpe.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CSVWritter {

	public static void writeLibros(List<Libro> libros, String pathOut) {

		BufferedWriter bw = null;
		try {
			File file = new File(pathOut);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			Iterator<Libro> l = libros.iterator();
			while(l.hasNext()){
				String nombreLibro = l.next().getTitulo();
				bw.write(nombreLibro);
				bw.newLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
