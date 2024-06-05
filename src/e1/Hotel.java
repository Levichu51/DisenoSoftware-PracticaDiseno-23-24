package e1;

import java.util.ArrayList;

public class Hotel {
    private final ArrayList<Habitacion> habitaciones;
    private final String hotelName;

    public Hotel(String hotelName){
        this.hotelName = hotelName;
        this.habitaciones = new ArrayList<Habitacion>();
    }

    public void añadirHabitacion(Habitacion habitacion, Supervisor supervisor){
        Habitacion auxHabitacion;

        if(habitaciones.isEmpty()){
            habitacion.setNumero(1);
            habitacion.setSupervisor(supervisor);
            habitaciones.add(habitacion);
        }
        else{
            auxHabitacion = habitaciones.get(habitaciones.size() - 1);
            habitacion.setNumero(auxHabitacion.getNumero() + 1);
            habitacion.setSupervisor(supervisor);
            habitaciones.add(habitacion);
        }

    }

    public void reservaHabitacion(Cliente cliente, int numeroHabitacion) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof EstadoDisponible) {
            auxHabit.getEstadoActual().reserveRoom(auxHabit, cliente);
        } else {
            throw new IllegalStateException("La habitacion no esta disponible para reserva");
        }
    }

    public void terminarReserva(int numeroHabitacion) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof EstadoReserva) {
            auxHabit.getEstadoActual().finishReservation(auxHabit);
        } else {
            throw new IllegalStateException("La habitacion no se puede completar la reserva");
        }
    }

    public void liberarHabitacion(int numeroHabitacion, Trabajador limpiador) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof EstadoReserva) {
            auxHabit.getEstadoActual().releaseRoom(auxHabit, limpiador);
        } else {
            throw new IllegalStateException("La habitacion no se puede liberar");
        }
    }
    public void limpiarHabitacion(int numeroHabitacion, Trabajador limpiador) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof EstadoLimpieza) {
            auxHabit.getEstadoActual().cleanRoom(auxHabit);
            auxHabit.setLimpiador(limpiador);
        } else {
            throw new IllegalStateException("La habitacion no se puede limpiar");
        }
    }

    public void aprobarLimpieza(int numeroHabitacion) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof PendienteAprobacion) {
            auxHabit.getEstadoActual().approveCleaning(auxHabit, null);
        } else {
            throw new IllegalStateException("La habitacion no se puede aprobar la limpieza");
        }
    }

    public void cancelarLimpieza(int numeroHabitacion) {
        if (numeroHabitacion <= 0 || numeroHabitacion > habitaciones.size()) {
            throw new IllegalStateException("La habitacion no existe");
        }

        Habitacion auxHabit = habitaciones.get(numeroHabitacion - 1);

        if (auxHabit.getEstadoActual() != null && auxHabit.getEstadoActual() instanceof PendienteAprobacion) {
            auxHabit.getEstadoActual().cancelCleaning(auxHabit, auxHabit.getSupervisor());
        } else {
            throw new IllegalStateException("La habitacion no se puede cancelar su limpieza");
        }
    }

    public void mostrarInformacionHabitacionesPorEstado(String estadoFiltrado) { //string mejor, mejorar test y limpiar constructor
        System.out.println("***********************");
        System.out.println(hotelName);
        System.out.println("***********************");

        for (Habitacion habitacion : habitaciones) {
            String estadoDescription = habitacion.getEstadoActual().getStateDescription();
            String roomInfo = "Room no. " + habitacion.getNumero() + ": " + getRoomInfo(habitacion, estadoDescription);

            if (estadoDescription.equals(estadoFiltrado)) {
                System.out.println(roomInfo);
            }
        }

        System.out.println("***********************");
    }

    public void mostrarInformacionHabitaciones() {
        System.out.println("***********************");
        System.out.println(hotelName);
        System.out.println("***********************");

        for (Habitacion habitacion : habitaciones) {
            String estadoDescription = habitacion.getEstadoActual().getStateDescription();
            String roomInfo = "Room no. " + habitacion.getNumero() + ": " + getRoomInfo(habitacion, estadoDescription);

            System.out.println(roomInfo);
        }

        System.out.println("***********************");
    }

    private String getRoomInfo(Habitacion habitacion, String estadoDescription) {
        switch (estadoDescription) {
            case "Free":
                return "Free. This room was approved by " + habitacion.getSupervisor().getNombre() + ".";
            case "Booked":
                return "Booked by " + habitacion.getCliente().getNombre() + ". Occupied.";
            case "Pending":
                return "Room cleaned by " + habitacion.getLimpiador().getNombre() + ", pending approval.";
            case "Cleaned":
                return "Room is being cleaned by " + habitacion.getLimpiador().getNombre() + ".";
            default:
                return "";
        }
    }

}




