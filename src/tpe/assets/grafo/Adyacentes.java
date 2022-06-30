package src.tpe.assets.grafo;

import java.util.*;
import java.util.Map.Entry;

public class Adyacentes {

    private String origen;
    private Map<String,Integer> adyacentes;

    public Adyacentes(String genero) {
        this. origen = genero;
        this.adyacentes = new HashMap<>();
    }

    public int getCantAdyacentes(){
        return adyacentes.size();
    }

    public void setRelacion(String destino) {
        if(adyacentes.containsKey(destino)){
            adyacentes.replace(destino, adyacentes.get(destino)+ 1);
        } else {
            adyacentes.put(destino, 1);
        }
    }
    
    public void delRelacion(String destino) {
        if(adyacentes.containsKey(destino)){
            adyacentes.remove(destino);
        }
    }

    public List<Map.Entry<String,Integer>> getAdyacentes(){
        List<Map.Entry<String,Integer>> ady = getNAdyacentes(adyacentes.size());
        return ady;
    }


    public Set<Arco> getArcos() {
        Set<Arco> arcos = new HashSet<>();
        for(Map.Entry<String, Integer> fila : adyacentes.entrySet()){
            arcos.add(new Arco(this.origen, fila.getKey(), fila.getValue()));
        }
        return arcos;
    }

    /*
     * Obtener los N géneros más buscados luego de buscar por el género A
     */

    public List<Map.Entry<String,Integer>> getNAdyacentes(int n){
    	
    	List<Map.Entry<String,Integer>> aux = new ArrayList<>() ;
    	
    	Iterator ady = adyacentes.entrySet().iterator();
    	
    	while (ady.hasNext()) {
    		Map.Entry<String, Integer> elem = (Entry<String, Integer>) ady.next();
    		int mayor = elem.getValue() ;
    		int i = 0 ;
    		while (i < aux.size() && aux.get(i).getValue() > mayor) {
    			i++;
            }
    		aux.add( i, elem) ;
    	}
    	
        if (aux.size() > n) {
        	return aux.subList(0, n) ;
        } else {
        	return aux ;
        }
     }
    @Override
 	public String toString() {
 		return "[adyacentes=" + adyacentes.entrySet() + "]\n";
 	}

}
