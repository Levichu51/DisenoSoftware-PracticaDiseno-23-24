package e1;

public class EstadoReserva implements EstadosHabitacion{


    @Override
    public void reserveRoom(Habitacion room, Cliente cliente) {

    }

    @Override
    public void finishReservation(Habitacion room) {
        room.setCliente(null);
        room.setState(new EstadoDisponible());
    }

    @Override
    public void cleanRoom(Habitacion room) {

    }

    @Override
    public void approveCleaning(Habitacion room, Supervisor supervisor) {

    }

    @Override
    public void releaseRoom(Habitacion room, Trabajador limpiador) {
        room.setLimpiador(limpiador);
        room.setState(new EstadoLimpieza());
    }

    @Override
    public void cancelCleaning(Habitacion room, Supervisor supervisor) {

    }

    @Override
    public String getStateDescription() {
        return "Booked";
    }
}
