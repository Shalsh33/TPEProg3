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


    public List<String> obtenerAdyacentes(String origen) {
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

    public void eliminarGenero(String genero) {
        nodos.remove(genero);
    }
    /*
     * Obtener el grafo �nicamente con los g�neros afines a un g�nero A
     */
    public List<GrafoGeneros> obtenerCiclos(String origen){
        List<GrafoGeneros> lista = new ArrayList<>();
        GrafoGeneros camino = new GrafoGeneros();
        
        for(String adyacente: nodos.get(origen).getAdyacentes()){

        	DFS(adyacente, origen, lista, camino );

        }

        return lista;
    }

    private void DFS(String origen, String destino, List<GrafoGeneros> lista, GrafoGeneros camino) {
        /*if(origen == destino){
            lista.add(camino);
        } else {
        	for(String adyacente: nodos.get(origen).getAdyacentes()){
        		
        		camino.agregarRelacion(origen, adyacente);       		
                
        		DFS(adyacente, destino, lista, camino);
                
                camino.eliminarGenero(origen);
            }
        }*/
    }

    public List<String> secuenciaConMasValor(String origen){
        List<String> secuencia = new ArrayList<>();
        List<String> visitados = new ArrayList<>();

        if(contieneGenero(origen)){
            List<String> candidatos = obtenerAdyacentes(origen);
            visitados.add(origen);
            secuencia.add(origen);
            while(!candidatos.isEmpty()){
                String s = candidatos.remove(0);
                if(!visitados.contains(s)){
                    visitados.add(s);
                    secuencia.add(s);
                    candidatos = obtenerAdyacentes(s);
                }
            }
        }

        return secuencia;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}