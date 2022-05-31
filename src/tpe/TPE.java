package src.tpe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.tpe.assets.*;

public class TPE {

    public static void main(String[] args) {
        
    	Timer temporizador = new Timer();
    	temporizador.start();
        Indice indice = CSVReader.read();
        //System.out.println(temporizador.stop() + " milisegundos") ;
        //indice.imprimirGeneros();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Por favor ingrese genero de búsqueda: ");//Se pide un dato al usuario
            String genero = br.readLine();
            if (!(genero == null) && (!(genero.equals(" ")))){
            	indice.getIndiceGenero(genero) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }


}
