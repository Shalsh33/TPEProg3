package src.tpe.assets.grafo;

import java.util.*;

public class GrafoGeneros implements Cloneable {

    private Map<String, Adyacentes> nodos;

    public GrafoGeneros(){
        nodos = new HashMap<>();
    }

    public void agregarGenero(String genero) {
        nodos.put(genero, new Adyacentes(genero));
    }

    public List<String> generos(){
        return new ArrayList<>(nodos.keySet());
    }

    public void agregarRelacion(String generoOrigen, String generoDestino) {
        if(!contieneGenero(generoOrigen)){
            agregarGenero(generoOrigen);
        }
        if(!contieneGenero(generoDestino)){
            agregarGenero(generoDestino);
        }

        nodos.get(generoOrigen).setRelacion(generoDestino);
    }


    public boolean contieneGenero(String genero) {
        return(nodos.containsKey(genero));
    }


    public Arco obtenerArco(String origen, String destino){
        return null;
    }


    public int cantidadVertices() {
        return nodos.size();
    }

    public Set<String> obtenerVertices() {
        return nodos.keySet();
    }


    public List<Map.Entry<String,Integer>> obtenerAdyacentes(String origen) {
        if(contieneGenero(origen))
            return nodos.get(origen).getAdyacentes();
        else
            return null;
    }

    public Set<Arco> obtenerArcos(String origen) {
        if(contieneGenero(origen))
            return nodos.get(origen).getArcos();
        else
            return null;
    }

    public void eliminarRelacion(String generoOrigen, String generoDestino) {
           nodos.get(generoOrigen).delRelacion(generoDestino);
    }
    
    /*
     * Obtener el grafo �nicamente con los g�neros afines a un g�nero A
     */
    public List<List<String>> obtenerCiclos(String origen){
        List<List<String>> lista = new LinkedList<>();
        List<String> camino = new LinkedList<>();
        
        for(Map.Entry<String,Integer> fila: nodos.get(origen).getAdyacentes()){
            String adyacente = fila.getKey();
        	DFS(adyacente, origen, lista, camino );
            //break;
            //Ni solo evaluando 1 de los adyacentes puede hacer el DFS en los datasets después del 1

        }

        return lista;
    }

    private void DFS(String origen, String destino, List<List<String>> lista, List<String> camino) {
        if(origen.equals(destino)){
            lista.add(new LinkedList<>(camino)); //guardar copia
            //System.out.println("camino " + camino);
        } else {
        	for(Map.Entry<String,Integer> fila: nodos.get(origen).getAdyacentes()){
        		String adyacente = fila.getKey();
        		if (!camino.contains(adyacente)) {
        			camino.add(adyacente);
	        		DFS(adyacente, destino, lista, camino);
	                camino.remove(adyacente);
                }
            }
        }
    }

    public List<String> secuenciaConMasValor(String origen){
        List<String> secuencia = new ArrayList<>();
        List<String> visitados = new ArrayList<>();
        int valor = 0;

        if(contieneGenero(origen)){
            List<Map.Entry<String,Integer>> candidatos = obtenerAdyacentes(origen);
            System.out.println("El nodo tiene " + nodos.get(origen).getCantAdyacentes() + " adyacentes");
            visitados.add(origen);
            secuencia.add(origen);
            while(!candidatos.isEmpty()){
                Map.Entry<String,Integer> fila = candidatos.remove(0);
                String s = fila.getKey();
                valor += fila.getValue();
                if(!visitados.contains(s)){
                    visitados.add(s);
                    secuencia.add(s);
                    candidatos = obtenerAdyacentes(s);
                }
            }

        }
        return secuencia;
    }
    
    public List<Map.Entry<String,Integer>> generosMasBuscados(String origen, int cantidad){
    	List<Map.Entry<String,Integer>> aux = new ArrayList<>() ;
    	
    	if(contieneGenero(origen)){
    		aux = nodos.get(origen).getNAdyacentes(cantidad) ;
    	}
    	return aux ;
    }

    
    @Override
	public String toString() {
		return "GrafoGeneros [vertices=" + nodos + "]/";
	}


}