package e2;

public class NodoBatalla extends NodoBifurcacion{
    private int enemyHP;
    private int enemyArmour;
    private int enemyPower;
    private String name;

    public NodoBatalla(Nodos right, Nodos left, int enemyHP, int enemyArmour, int enemyPower, String name) {
        super(right, left, name);
        this.enemyHP = enemyHP;
        this.enemyArmour = enemyArmour;
        this.enemyPower = enemyPower;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int continuar(Flota flota) {
        int aux = 0;
        int damage;
        
        if(flota.getBlindaje() > this.enemyPower){
            damage = 0;
        }else {
            damage = this.enemyPower - flota.getBlindaje();
        }
        if(flota.getPoderFuego() >= this.enemyArmour) {
            this.enemyHP = this.enemyHP - (flota.getPoderFuego() - this.enemyArmour);
        }

        flota.setHp(flota.getHp() - damage);

        // Verificar si los HP de la flota llegan a cero
        if (flota.getHp() <= 0) {
            aux = -1;  // Indica fracaso de la incursión
        }
        else {
            if (enemyHP <= 0) {
                //return flota.getHp();// Devuelve los HP finales de la flota
                aux = 1;
                //this.getLeft().continuar(flota);
            } else {
                aux = 2;
                //this.getRight().continuar(flota);
                //return -1; // Indica que la flota debe seguir la ruta derecha
            }
        }
        return aux;
    }


    public int getEnemyPower() {
        return enemyPower;
    }

    public int getEnemyArmour() {
        return enemyArmour;
    }

    public int getEnemyHP() {
        return enemyHP;
    }

    public void setEnemyHP(int hp) {
        this.enemyHP = hp;
    }



}
