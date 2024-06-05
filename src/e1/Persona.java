package e1;

public abstract class Persona {
    private String DNI;
    private String name;

    public String getNombre() {
        return name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persona(String DNI, String name){
        this.DNI = DNI;
        this.name = name;
    }


}
