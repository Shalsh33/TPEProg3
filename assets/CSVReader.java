package tpe.assets;

import tpe.Indice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static final String PATH = "C://users/blase/desktop/prog3/src/tpe/assets/csv/dataset1.csv";
    public static final String SPLIT = ",";

    public static Indice read() {

        String line;
        IndexCreator index = new IndexCreator();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(SPLIT);

                index.indexar(items);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index.getIndice();
    }


}
