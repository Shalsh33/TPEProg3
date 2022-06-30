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

    public List<String> getAdyacentes(){
        List<Map.Entry<String,Integer>> ady = new ArrayList<>(adyacentes.entrySet());
        List<String> result = quickSort(ady,0,ady.size()-1);
        return result;
    }

    private List<String> quickSort(List<Map.Entry<String, Integer>> ady, int inicio, int fin) {
        int pos = (inicio+fin)/2;
        Map.Entry<String, Integer> pivot = ady.get(pos), aux;
        int i = inicio;
        int j = fin;

        while(i<j){
            while(ady.get(i).getValue() <= pivot.getValue() && i<j){
                i++;
            }
            while(ady.get(j).getValue() > pivot.getValue()){
                j--;
            }
            if(i<j){
                aux=ady.get(i);
                ady.add(i,ady.get(j));
                ady.add(j,aux);
            }

        }

        ady.add(pos,ady.get(j));
        ady.add(j,pivot);

        if(inicio < j-1){
            quickSort(ady,inicio,j-1);
        }
        if (j+1 < fin){
            quickSort(ady,j+1,fin);
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> fila : ady){
            result.add(fila.getKey());
        }
        return result;

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
    		while (aux.get(i).getValue() > mayor) {
    			i++;
            }
    		aux.add( i, elem) ;
    	}
    	
        if (aux.size() > n) {
        	return aux.subList(0, n-1) ;
        } else {
        	return aux ;
        }
     }
    @Override
 	public String toString() {
 		return "[adyacentes=" + adyacentes + "]\n";
 	}

}
