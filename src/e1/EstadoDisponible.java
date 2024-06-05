package e1;

public class EstadoDisponible implements EstadosHabitacion{


    @Override
    public void reserveRoom(Habitacion room, Cliente cliente) {
        room.setCliente(cliente);
        room.setState(new EstadoReserva());
    }

    @Override
    public void finishReservation(Habitacion room) {

    }

    @Override
    public void cleanRoom(Habitacion room) {

    }

    @Override
    public void approveCleaning(Habitacion room, Supervisor supervisor) {

    }

    @Override
    public void releaseRoom(Habitacion room, Trabajador limpiador) {

    }

    @Override
    public void cancelCleaning(Habitacion room, Supervisor supervisor) {

    }

    @Override
    public String getStateDescription() {
        return "Free";
    }
}
