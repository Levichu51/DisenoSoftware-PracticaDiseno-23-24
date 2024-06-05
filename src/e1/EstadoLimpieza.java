package e1;

public class EstadoLimpieza implements EstadosHabitacion{


    @Override
    public void reserveRoom(Habitacion room, Cliente cliente) {

    }

    @Override
    public void finishReservation(Habitacion room) {

    }

    @Override
    public void cleanRoom(Habitacion room) {
        room.setState(new PendienteAprobacion());
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
        return "Cleaned";
    }
}
