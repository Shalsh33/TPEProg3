package src.tpe;

import src.tpe.assets.*;
import java.util.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class TPE {

    public static void main(String[] args){
        
    	Timer temporizador = new Timer();
    	temporizador.start();
        Indice indice = CSVReader.read();
        System.out.println(temporizador.stop() + " milisegundos") ;
        indice.imprimirGeneros();
    }


}
