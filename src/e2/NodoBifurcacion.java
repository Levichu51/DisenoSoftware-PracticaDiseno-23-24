package e2;

public class NodoBifurcacion implements Nodos{
    private Nodos right;
    private Nodos left;
    private String name;

    public NodoBifurcacion(Nodos right, Nodos left, String name){
        this.right = right;
        this.left = left;
        this.name = name;
    }

    public Nodos getLeft() {
        return left;
    }

    public void setLeft(Nodos left) {
        this.left = left;
    }

    public Nodos getRight() {
        return right;
    }

    public void setRight(Nodos right) {
        this.right = right;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int continuar(Flota flota) {
        return 0;
    }
}
