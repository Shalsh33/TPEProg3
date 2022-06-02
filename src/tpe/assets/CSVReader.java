package tpe.assets;

import tpe.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {

    public static final String PATH = "c:/Users/blase/Desktop/Prog3TPE/tpe/assets/csv/dataset4.csv";
	//public static final String PATH = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/dataset1.csv";
    //public static final String PATH = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/dataset2.csv";
    //public static final String PATH = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/dataset3.csv";
    //public static final String PATH = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/dataset4.csv";
    public static final String SPLIT = ",";

    public static void read(List<Libro> libros, Indice indice) {

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(SPLIT);
                Libro l = LibroFormatter.format(items) ;
                libros.add(l);
                indice.indexar(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
