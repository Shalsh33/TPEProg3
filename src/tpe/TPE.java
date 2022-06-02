package src.tpe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import src.tpe.Libro;
import src.tpe.assets.*;

public class TPE {

    public static void main(String[] args) {

        Timer temporizador = new Timer();
        List<Libro> libros = new LinkedList<>();
        Indice indice = new Indice();

        temporizador.start();
        CSVReader.read(libros,indice);
        System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;

        System.out.println();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Por favor ingrese genero de búsqueda: ");//Se pide un dato al usuario
            String genero = br.readLine();
            if (!(genero == null) && (!(genero.equals(" ")))){
                temporizador.start();
                indice.getIndiceGenero(genero) ;
                System.out.println(temporizador.stop() + " milisegundos de búsqueda y escritura") ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
