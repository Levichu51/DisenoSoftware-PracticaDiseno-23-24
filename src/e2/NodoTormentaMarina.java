package e2;

public class NodoTormentaMarina extends NodoRutaFija{
    private int fuerzaTormenta;
    private String name;

    public NodoTormentaMarina(Nodos next, int fuerzaTormenta, String name) {
        super(next, name);
        this.fuerzaTormenta = fuerzaTormenta;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFuerzaTormenta(int fuerzaTormenta) {
        this.fuerzaTormenta = fuerzaTormenta;
    }

    @Override
    public int continuar(Flota flota){
        int aux = 0;
        if (flota.getLineaDeVision() < fuerzaTormenta) {
            flota.takeDamage(10);
            // Verificar si los HP de la flota llegan a cero
            if (flota.getHp() <= 0) {
                aux = -1;
                // Indica fracaso de la incursión
            }else{
                //this.getNext().continuar(flota);
            }
        }
        else{
            aux = flota.getHp();
            //this.getNext().continuar(flota);
        }
        return aux;
    }


    public int getFuerzaTormenta(){
        return this.fuerzaTormenta;
    }




}
