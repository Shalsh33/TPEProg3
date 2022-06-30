package src.tpe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import src.tpe.Libro;
import src.tpe.assets.*;
import src.tpe.assets.Timer;
import src.tpe.assets.grafo.GrafoGeneros;

public class TPE {

    public static void main(String[] args) {


    	//Parte 2
    	   Timer temporizador = new Timer();
    	   GrafoGeneros grafo = new GrafoGeneros();
    	   
    	   final String path = "C:\\Users\\blase\\Desktop\\Prog3\\src\\tpe/assets/csv2/dataset1.csv";
    	   temporizador.start();
    	   
    	   CSVReader.readGrafo(grafo, path);
           System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;

           System.out.println();
           System.out.println("Tamaño del grafo: " + grafo.cantidadVertices());
           //System.out.println(grafo);

           /*for(String s:grafo.secuenciaConMasValor("humor")){
               System.out.println(s);
           }                */

        temporizador.start();
        System.out.println(grafo.obtenerCiclos("juegos"));
        System.out.println(temporizador.stop() + " milisegundos de DFS") ;

    	
        /* Parte 1
        Timer temporizador = new Timer();
        List<Libro> libros = new LinkedList<>();
        Indice indice = new Indice();

      //public static final String PATH = "c:/Users/blase/Desktop/Prog3TPE/tpe/assets/csv/dataset4.csv";
    	final String path = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/dataset2.csv";
        final String pathSalida = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv/salida.csv";     	
        temporizador.start();
        CSVReader.read(libros,indice, path);
        System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;

        System.out.println();
      
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Por favor ingrese genero de b�squeda: ");//Se pide un dato al usuario
            String genero = br.readLine();
            if (!(genero == null) && (!(genero.equals(" ")))){
                temporizador.start();
                indice.getIndiceGenero(genero, pathSalida) ;
                System.out.println(temporizador.stop() + " milisegundos de b�squeda y escritura") ;

                indice.imprimirDatosIndice();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        

    }



}
