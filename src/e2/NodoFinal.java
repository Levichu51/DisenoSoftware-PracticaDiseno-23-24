package e2;

public class NodoFinal implements Nodos{
    private String name;
    private Nodos nodofinal;

    public NodoFinal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int continuar(Flota flota){
        return flota.getHp();
    }


}
