package e2;

public class Simulador{
    public static void main(String[] args) {
        // Crear nodos
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

        System.out.println();
        // Obtener el número mínimo de nodos
        int smallestNodeCount = getSmallestNodeCount(nodoA);
        System.out.println("Smallest Node Count to End: " + smallestNodeCount);

        // Obtener la representación en formato Newick
        String newickRepresentation = getNewickRepresentation(nodoA);
        System.out.println("Newick Representation: " + newickRepresentation);
    }

    static void simular(Flota flota, Nodos nodoActual) {
        if (nodoActual instanceof NodoFinal) {
            System.out.println("Sortie Result: SUCCESS");
            System.out.println("Last Visited Node: " + nodoActual.getName());
            System.out.println("Final HP: " + flota.getHp());
            return;
        }

        int resultado = nodoActual.continuar(flota);

        if (resultado < 0) {
            System.out.println("Sortie Result: FAIL");
            System.out.println("Last Visited Node: " + nodoActual.getName());
            System.out.println("Final HP: " + flota.getHp());
            return;
        }

        if (nodoActual instanceof NodoBifurcacion) {
            NodoBifurcacion bifurcacion = (NodoBifurcacion) nodoActual;
            if (resultado == 1) {
                System.out.println("Taking left path at " + nodoActual.getName());
                simular(flota, bifurcacion.getLeft());
            } else if(resultado == 2){
                System.out.println("Taking right path at " + nodoActual.getName());
                simular(flota, bifurcacion.getRight());
            }
        } else {
            System.out.println("Continuing to " + ((NodoRutaFija) nodoActual).getNext().getName());
            simular(flota, ((NodoRutaFija) nodoActual).getNext());
        }
    }

    public static int getSmallestNodeCount(Nodos nodo) {
        if (nodo instanceof NodoFinal) {
            // Nodo Final alcanzado
            return 1;
        } else if (nodo instanceof NodoBifurcacion) {
            // Nodo de Bifurcación
            NodoBifurcacion bifurcacion = (NodoBifurcacion) nodo;
            int leftCount = getSmallestNodeCount(bifurcacion.getLeft());
            int rightCount = getSmallestNodeCount(bifurcacion.getRight());
            return 1 + Math.min(leftCount, rightCount);
        } else if (nodo instanceof NodoRutaFija) {
            // Nodo de Ruta Fija
            NodoRutaFija rutaFija = (NodoRutaFija) nodo;
            return 1 + getSmallestNodeCount(rutaFija.getNext());
        }
        return 0;
    }

    public static String getNewickRepresentation(Nodos nodo) {
        StringBuilder newickRepresentation = new StringBuilder();
        if (nodo instanceof NodoBifurcacion) {
            NodoBifurcacion bifurcacion = (NodoBifurcacion) nodo;
            newickRepresentation.append("(");
            newickRepresentation.append(getNewickRepresentation(bifurcacion.getLeft()));
            newickRepresentation.append(" ");
            newickRepresentation.append(bifurcacion.getName());
            newickRepresentation.append(", ");
            newickRepresentation.append(getNewickRepresentation(bifurcacion.getRight()));
            newickRepresentation.append(")");
        } else if (nodo instanceof NodoRutaFija) {
            NodoRutaFija rutaFija = (NodoRutaFija) nodo;
            newickRepresentation.append(rutaFija.getName());
            newickRepresentation.append(" ");
            newickRepresentation.append(getNewickRepresentation(rutaFija.getNext()));
        } else if (nodo instanceof NodoFinal) {
            newickRepresentation.append(((NodoFinal) nodo).getName());
            newickRepresentation.append(" End");
        }
        return newickRepresentation.toString();
    }



}
