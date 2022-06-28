package src.tpe.assets.grafo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Nodo {

    private String genero;
    private Set<Arco> adyacentes;


    public Nodo(String genero) {
        this.genero = genero;
        adyacentes = new HashSet<>();
    }

    public void agregarAdyacente(Nodo n){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return genero.equals(nodo.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero);
    }
}
