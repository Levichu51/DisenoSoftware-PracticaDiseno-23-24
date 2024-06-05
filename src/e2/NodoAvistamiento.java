package e2;

public class NodoAvistamiento extends NodoBifurcacion {
    private int distance;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodoAvistamiento(Nodos right, Nodos left, int distance, String name) {
        super(right, left,name);
        this.distance = distance;
        this.name = name;
    }

    @Override
    public int continuar(Flota flota) {
        int aux = 0;
        if (flota.getLineaDeVision() >= distance) {
            aux = 1;
            //this.getLeft().continuar(flota);
        } else {
            aux = 2;
            //this.getRight().continuar(flota);
             // Indica que la flota debe seguir la ruta derecha
        }
        return aux;
    }

    public int getDistance(){
        return this.distance;
    }





}
