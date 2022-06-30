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
    	   final String path2 = "C:\\Users\\blase\\Desktop\\Prog3\\src\\tpe/assets/csv2/dataset2.csv";
		final String path3 = "C:\\Users\\blase\\Desktop\\Prog3\\src\\tpe/assets/csv2/dataset3.csv";
		final String path4 = "C:\\Users\\blase\\Desktop\\Prog3\\src\\tpe/assets/csv2/dataset4.csv";
    	   //final String path = "C://Users/Andrea/eclipse-workspace/TPE/TPEProg3/src/tpe/assets/csv2/dataset3.csv";
    	   temporizador.start();
		System.out.println("Grafo 1");
    	   CSVReader.readGrafo(grafo, path);
           System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;



           System.out.println("Tamaño del grafo: " + grafo.cantidadVertices());
           //System.out.println(grafo);
		temporizador.start();
           for(String s:grafo.secuenciaConMasValor("humor")){
               System.out.println(s);
           }
		System.out.println(temporizador.stop() + " milisegundos de busqueda de secuencia más larga") ;
		System.out.println();
		System.out.println("Grafo 2");
		CSVReader.readGrafo(grafo, path2);
		System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;



		System.out.println("Tamaño del grafo: " + grafo.cantidadVertices());
		//System.out.println(grafo);
		temporizador.start();
		for(String s:grafo.secuenciaConMasValor("humor")){
			System.out.println(s);
		}
		System.out.println(temporizador.stop() + " milisegundos de busqueda de secuencia más larga") ;

		System.out.println();
		System.out.println("Grafo 3");
		CSVReader.readGrafo(grafo, path3);
		System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;



		System.out.println("Tamaño del grafo: " + grafo.cantidadVertices());
		//System.out.println(grafo);
		temporizador.start();
		for(String s:grafo.secuenciaConMasValor("humor")){
			System.out.println(s);
		}
		System.out.println(temporizador.stop() + " milisegundos de busqueda de secuencia más larga") ;

		System.out.println();
		System.out.println("Grafo 4");
		CSVReader.readGrafo(grafo, path4);
		System.out.println(temporizador.stop() + " milisegundos de carga de datos") ;


		System.out.println("Tamaño del grafo: " + grafo.cantidadVertices());
		//System.out.println(grafo);
		temporizador.start();
		for(String s:grafo.secuenciaConMasValor("humor")){
			System.out.println(s);
		}
		System.out.println(temporizador.stop() + " milisegundos de busqueda de secuencia más larga") ;
/*
        	temporizador.start();
        	System.out.println(grafo.obtenerCiclos("juegos"));
        	System.out.println(temporizador.stop() + " milisegundos de DFS") ;

*/

         //Servicio 1: Obtener los N g�neros m�s buscados luego de buscar por el g�nero A.
		System.out.println();
		temporizador.start();
          System.out.println(grafo.generosMasBuscados("negocios", 5)) ;
		System.out.println(temporizador.stop() + " milisegundos de Busqueda de N 5") ;
		temporizador.start();
		System.out.println(grafo.generosMasBuscados("negocios", 20)) ;
		System.out.println(temporizador.stop() + " milisegundos de Busqueda de N 20") ;
         //Servicio 2: A partir de un g�nero A encontrar, en tiempo polinomial, la secuencia 
         //de g�neros que m�s alto valor de b�squeda posee
           
           /* for(String s:grafo.secuenciaConMasValor("thriller")){
               System.out.println(s);
           }  */       

         //Servicio 3: Obtener el grafo �nicamente con los g�neros afines a un g�nero A
           
			/*
			 * temporizador.start(); for(List<String> l: grafo.obtenerCiclos("juegos")){
			 * System.out.println(l); } System.out.println(temporizador.stop() +
			 * " milisegundos de DFS") ;
			 */

    	
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
