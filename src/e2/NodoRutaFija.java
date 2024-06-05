package e2;

public class NodoRutaFija implements Nodos{
    private Nodos next;
    private String name;

    public NodoRutaFija(Nodos next, String name){
        this.next = next;
        this.name = name;
    }

    public void setNext(Nodos next) {
        this.next = next;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int continuar(Flota flota){
        return flota.getHp();
    }

    public Nodos getNext(){
        return this.next;
    }







}
