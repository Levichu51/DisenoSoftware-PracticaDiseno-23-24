package e1;

import e1.Cliente;

public class Habitacion {
    private int estadoLimpieza;
    private String clase;
    private int limpiezaRevision;
    private int numero;
    private Cliente cliente;
    private int reserva;
    private Supervisor supervisor;
    private Trabajador limpiador;
    private EstadosHabitacion estadoActual;

    public Habitacion(String clase){
        this.clase = clase;
        this.estadoActual = new EstadoDisponible();
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Trabajador getLimpiador() {
        return limpiador;
    }

    public void setLimpiador(Trabajador limpiador) {
        this.limpiador = limpiador;
    }

    public void setState(EstadosHabitacion newState) {
        this.estadoActual = newState;
    }

    public EstadosHabitacion getEstadoActual(){
        return this.estadoActual;
    }
}
