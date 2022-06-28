package src.tpe.assets.grafo;

import java.util.*;

public class GrafoGeneros {

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


    public Set<String> obtenerAdyacentes(String origen) {
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

    public List<GrafoGeneros> obtenerCiclos(String origen){
        List<GrafoGeneros> lista = new ArrayList<>();
        for(String adyacente: nodos.get(origen).getAdyacentes()){
            DFS(adyacente,origen,lista);
        }

        return lista;
    }

    private void DFS(String origen, String destino, List<GrafoGeneros> lista, GrafoGeneros camino) {
        if(origen == destino){
            lista.add(camino);
        } else {
            for adyacentes {
             DFS;
            }
        }
    }

}