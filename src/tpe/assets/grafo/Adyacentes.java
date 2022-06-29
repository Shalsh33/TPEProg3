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
