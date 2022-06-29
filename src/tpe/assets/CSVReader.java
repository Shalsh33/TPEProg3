package src.tpe.assets;

import src.tpe.*;
import src.tpe.assets.grafo.GrafoGeneros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {

    public static final String SPLIT = ",";

    public static void read(List<Libro> libros, Indice indice, String path) {

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

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

    public static void readGrafo(GrafoGeneros grafo,String path){

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                String[] items = line.split(SPLIT);
                for(int i=0;i<items.length-1; i++){
                    grafo.agregarRelacion(items[i],items[i+1]);
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
