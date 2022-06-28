package src.tpe.assets.grafo;

import java.util.*;

public class Adyacentes {

    private String origen;
    private Map<String,Integer> adyacentes;

    public Adyacentes(String genero) {
        this. origen = genero;
        this.adyacentes = new HashMap<>();
    }

    public void setRelacion(String destino) {
        if(adyacentes.containsKey(destino)){
            adyacentes.replace(destino, adyacentes.get(destino)+ 1);
        } else {
            adyacentes.put(destino, 1);
        }
    }

    public Set<String> getAdyacentes(){
        return adyacentes.keySet();
    }

    public Set<Arco> getArcos() {
        Set<Arco> arcos = new HashSet<>();
        for(Map.Entry<String, Integer> fila : adyacentes.entrySet()){
            arcos.add(new Arco(this.origen, fila.getKey(), fila.getValue()));
        }
        return arcos;
    }

    //Si clonamos el mapa podemos recorrerlo buscando el mayor, agregarlo a la lista y borrarlo del mapa clonado
    //"n veces" (Complejidad O(n*N)).
    //Sino podemos agarrar los primeros "n elementos", ordenarlos e ir recorriendo el resto solo buscando los que
    //entren en la estructura. Es más complejo de programar. complejidad O(N)
    public List<Map.Entry<String,Integer>> getNAdyacentes(int n){
        //mapa:
        //Te da las claves
        adyacentes.keySet();
        //te da los valores
        adyacentes.values();
        //te da ambos.-
        adyacentes.entrySet();
        adyacentes.entrySet().iterator().next();
        return null;
    }
}
