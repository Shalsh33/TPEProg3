package src.tpe.assets.grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
