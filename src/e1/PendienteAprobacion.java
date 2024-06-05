package e1;

public class PendienteAprobacion implements EstadosHabitacion{
    @Override
    public void reserveRoom(Habitacion room, Cliente cliente) {

    }

    @Override
    public void finishReservation(Habitacion room) {

    }

    @Override
    public void cleanRoom(Habitacion room) {

    }

    @Override
    public void approveCleaning(Habitacion room, Supervisor supervisor) {
        room.setState(new EstadoDisponible());
    }

    @Override
    public void releaseRoom(Habitacion room, Trabajador limpiador) {

    }

    @Override
    public void cancelCleaning(Habitacion room, Supervisor supervisor) {
        room.setState(new EstadoLimpieza());
    }

    @Override
    public String getStateDescription() {
        return "Pending";
    }
}
