package e1;

public interface EstadosHabitacion {
    void reserveRoom(Habitacion room, Cliente cliente);
    void finishReservation(Habitacion room);
    void cleanRoom(Habitacion room);
    void approveCleaning(Habitacion room, Supervisor supervisor);
    void releaseRoom(Habitacion room, Trabajador limpiador);
    void cancelCleaning(Habitacion room, Supervisor supervisor);
    String getStateDescription();

}
