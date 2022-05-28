package tpe.assets;

import tpe.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {

    public static final String PATH = "C://users/blase/desktop/prog3/src/tpe/assets/csv/dataset1.csv";
    public static final String SPLIT = ",";

    public static Indice read(LinkedList<Libro> lista) {

        String line;
        IndexCreator index = new IndexCreator();
                
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(SPLIT);
                Libro l = LibroFormatter.format(items) ;
                lista.add(l);
                index.indexar(l);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index.getIndice();
    }


}
