package e2;

public class NodoAtaqueAereo extends NodoRutaFija{
    private int poderAereo;
    private String name;

    public NodoAtaqueAereo(Nodos next, int poderAereo, String name) {
        super(next, name);
        this.poderAereo = poderAereo;
        this.name = name;
    }

    public void setPoderAereo(int poderAereo) {
        this.poderAereo = poderAereo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int continuar(Flota flota) {
        int damage = poderAereo - (2 * flota.getAntiaereo() + flota.getBlindaje());

        if(poderAereo < 2 * flota.getAntiaereo() + flota.getBlindaje()){
            flota.takeDamage(0);
        }
        else{
            flota.takeDamage(damage);
        }


        // Verificar si los HP de la flota llegan a cero
        if (flota.getHp() <= 0) {
            return -1;  // Indica fracaso de la incursión
        }

        // Verificar si hay un siguiente nodo antes de continuar
        if (this.getNext() != null) {
            //this.getNext().continuar(flota);
        }

        return flota.getHp();
    }

    public int getPoderAereo(){
        return this.poderAereo;
    }



}
