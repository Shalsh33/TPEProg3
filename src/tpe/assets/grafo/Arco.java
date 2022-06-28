package src.tpe.assets.grafo;

import java.util.Objects;


public class Arco {

    private String verticeOrigen;
    private String verticeDestino;
    private int etiqueta;

   public Arco(String verticeOrigen, String verticeDestino, int etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public String getVerticeOrigen() {
        return verticeOrigen;
    }

    public String getVerticeDestino() {
        return verticeDestino;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arco arco = (Arco) o;
        return verticeOrigen == arco.getVerticeOrigen() && verticeDestino == arco.getVerticeDestino();
    }

    @Override
    public int hashCode() {
        return Objects.hash(verticeOrigen, verticeDestino);
    }
}