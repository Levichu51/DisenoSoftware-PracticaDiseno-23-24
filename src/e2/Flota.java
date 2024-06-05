package e2;

public class Flota {
    private int hp;
    private int blindaje;
    private int poderFuego;
    private int antiaereo;
    private int lineaDeVision;
    private String lastVisitedNode;

    public String getLastVisitedNode() {
        return lastVisitedNode;
    }

    public void setLastVisitedNode(String lastVisitedNode) {
        this.lastVisitedNode = lastVisitedNode;
    }

    public Flota(int hp, int blindaje, int poderFuego, int antiaereo, int lineaDeVision) {
        this.hp = hp;
        this.blindaje = blindaje;
        this.poderFuego = poderFuego;
        this.antiaereo = antiaereo;
        this.lineaDeVision = lineaDeVision;
    }

    public void takeDamage(int damage){
        this.hp = hp - damage;
    }

    public int getLineaDeVision() {
        return lineaDeVision;
    }

    public void setLineaDeVision(int lineaDeVision) {
        this.lineaDeVision = lineaDeVision;
    }
    public void visitarNodo(String nombreNodo) {
        this.lastVisitedNode = nombreNodo;
    }

    public int getAntiaereo() {
        return antiaereo;
    }

    public void setAntiaereo(int antiaereo) {
        this.antiaereo = antiaereo;
    }

    public int getPoderFuego() {
        return this.poderFuego;
    }

    public void setPoderFuego(int poderFuego) {
        this.poderFuego = poderFuego;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public void setBlindaje(int blindaje) {
        this.blindaje = blindaje;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }




}
