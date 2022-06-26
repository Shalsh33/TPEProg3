package src.tpe.assets;

import src.tpe.Libro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class LibroFormatter {

    public static final String SPLIT = " ";

    public static Libro format(String[] arr){
        Libro l = new Libro();
        Iterator<String> i = Arrays.stream(arr).iterator();
        try{
            l.setTitulo(i.next());
            l.setAutor(i.next());
            l.setPag(Integer.valueOf(i.next()));
            String[] generos = i.next().split(SPLIT);
            for(String genero:generos){
                l.addGenero(genero.toLowerCase());
            }
        } catch (Exception e){
            l = null;
        }

        return l;
    }
}
