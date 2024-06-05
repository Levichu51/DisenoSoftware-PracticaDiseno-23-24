package e2;

import static e2.Simulador.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SimuladorTest {
    @Test
    void test1(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 15, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 12, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 8, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 30, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);

        int smallestNodeCount = getSmallestNodeCount(nodoA);
        String newickRepresentation = getNewickRepresentation(nodoA);
        System.out.println("Newick Representation: " + newickRepresentation);

        assertEquals(11, flota.getHp());
        assertEquals(3, smallestNodeCount);

    }

    @Test
    void test2(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 17, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 8, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 30, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);

        assertEquals(11, flota.getHp());

    }

    @Test
    void test3(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 15, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 8, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 30, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);

        assertEquals(11, flota.getHp());
        assertEquals(48, nodoB.getEnemyHP());

    }

    @Test
    void test4(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 17, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 8, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 80, 47, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);

        assertEquals(80, nodoF.getEnemyHP());

        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);

        assertEquals(11, flota.getHp());
        assertEquals(80, nodoF.getEnemyHP());
    }

    @Test
    void test5(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 17, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 8, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 17, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 80, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(9, 40, 47, 11, 16);
        simular(flota, nodoRoot);

        assertEquals(-1, flota.getHp());

    }

    @Test
    void test6(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 15, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 35, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 300, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 30, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);
        assertEquals(-227, flota.getHp());
    }
    @Test
    void test7(){
        NodoFinal nodoH = new NodoFinal("H");
        NodoFinal nodoK = new NodoFinal("K");
        NodoFinal nodoD = new NodoFinal("D");
        NodoFinal nodoI = new NodoFinal("I");

        NodoAvistamiento nodoA = new NodoAvistamiento(null, null, 15, "A");
        NodoBatalla nodoB = new NodoBatalla(null, null, 80, 15, 200, "B");
        NodoAtaqueAereo nodoE = new NodoAtaqueAereo(null, 300, "E");
        NodoTormentaMarina nodoC = new NodoTormentaMarina(null, 12, "C");
        NodoBatalla nodoF = new NodoBatalla(null, null, 30, 15, 8, "F");
        NodoTormentaMarina nodoG = new NodoTormentaMarina(null, 12, "G");
        NodoRutaFija nodoRoot = new NodoRutaFija(nodoA, "Root");


        nodoA.setLeft(nodoB);
        nodoA.setRight(nodoC);

        nodoB.setLeft(nodoD);
        nodoB.setRight(nodoE);

        nodoC.setNext(nodoF);

        nodoE.setNext(nodoK);

        nodoF.setRight(nodoG);
        nodoF.setLeft(nodoH);

        nodoG.setNext(nodoI);


        // Simular incursión desde el nodo raíz
        Flota flota = new Flota(11, 40, 47, 11, 16);
        simular(flota, nodoRoot);
        assertEquals(-149, flota.getHp());
    }







}