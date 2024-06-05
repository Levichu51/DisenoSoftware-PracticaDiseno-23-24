package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testReservaHabitacion() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Cliente cliente = new Cliente("222", "Fulanito");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);

        // Verificar que se pueda reservar una habitación disponible
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        assertEquals("Booked", habitacion.getEstadoActual().getStateDescription());
        assertEquals(cliente, habitacion.getCliente());
    }

    @Test
    void testTerminarReserva() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Cliente cliente = new Cliente("222", "Fulanito");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);

        // Verificar que se pueda terminar una reserva
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        hotel.terminarReserva(habitacion.getNumero());
        assertEquals("Free", habitacion.getEstadoActual().getStateDescription());
        assertNull(habitacion.getCliente());
    }


    @Test
    void testLiberarHabitacion() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Cliente cliente = new Cliente("222", "Fulanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        // Verificar que se pueda liberar una habitación en estado de reserva
        hotel.liberarHabitacion(habitacion.getNumero(), limpiador);
        assertEquals("Cleaned", habitacion.getEstadoActual().getStateDescription());
    }

    @Test
    void testLimpiarHabitacion() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Cliente cliente = new Cliente("222", "Fulanito");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        hotel.liberarHabitacion(habitacion.getNumero(), limpiador);
        // Verificar que se pueda limpiar una habitación disponible
        assertEquals("Cleaned", habitacion.getEstadoActual().getStateDescription());
    }

    @Test
    void testAprobarLimpieza() {
        Hotel hotel = new Hotel("Mi Hotel");
        Cliente cliente = new Cliente("222", "Fulanito");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        hotel.liberarHabitacion(habitacion.getNumero(), limpiador);
        hotel.limpiarHabitacion(habitacion.getNumero(), limpiador);

        // Verificar que se pueda aprobar la limpieza de una habitación pendiente
        hotel.aprobarLimpieza(habitacion.getNumero());
        assertEquals("Free", habitacion.getEstadoActual().getStateDescription());
    }
    @Test
    void testAprobarLimpieza2() {
        Hotel hotel = new Hotel("Mi Hotel");
        Cliente cliente = new Cliente("222", "Fulanito");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Habitacion habitacion = new Habitacion( "Standard");

        hotel.añadirHabitacion(habitacion, supervisor);
        hotel.reservaHabitacion(cliente, habitacion.getNumero());
        hotel.liberarHabitacion(habitacion.getNumero(), limpiador);
        hotel.limpiarHabitacion(habitacion.getNumero(), limpiador);
        assertEquals("Pending", habitacion.getEstadoActual().getStateDescription());
        // Verificar que se pueda aprobar la limpieza de una habitación pendiente
        hotel.cancelarLimpieza(habitacion.getNumero());
        assertEquals("Cleaned", habitacion.getEstadoActual().getStateDescription());
    }

    @Test
    void testMostrarInformacionHabitaciones() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Habitacion habitacion1 = new Habitacion( "Standard");
        Habitacion habitacion2 = new Habitacion( "Deluxe");

        hotel.añadirHabitacion(habitacion1, supervisor);
        hotel.añadirHabitacion(habitacion2, supervisor);

        hotel.mostrarInformacionHabitaciones();
    }

    @Test
    void testMostrarInformacionHabitacionesPorEstado() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Habitacion habitacion1 = new Habitacion( "Standard");
        Habitacion habitacion2 = new Habitacion( "Deluxe");
        Habitacion habitacion3 = new Habitacion( "Suite");
        EstadoReserva reserva = new EstadoReserva();

        hotel.añadirHabitacion(habitacion1, supervisor);
        hotel.añadirHabitacion(habitacion2, supervisor);
        hotel.añadirHabitacion(habitacion3, supervisor);

        // Reserva algunas habitaciones
        hotel.reservaHabitacion(new Cliente("222", "Fulanito"), habitacion1.getNumero());
        hotel.reservaHabitacion(new Cliente("333", "Menganito"), habitacion3.getNumero());
        hotel.reservaHabitacion(new Cliente("444", "Frank"), habitacion2.getNumero());

        assertEquals("Booked", habitacion1.getEstadoActual().getStateDescription());
        assertEquals("Booked", habitacion2.getEstadoActual().getStateDescription());
        assertEquals("Booked", habitacion3.getEstadoActual().getStateDescription());

        hotel.mostrarInformacionHabitacionesPorEstado("Booked");
    }

    @Test
    void testMostrarInformacionHabitaciones2() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Habitacion habitacion1 = new Habitacion( "Standard");
        Habitacion habitacion2 = new Habitacion( "Deluxe");
        Habitacion habitacion3 = new Habitacion( "Suite");
        Habitacion habitacion4 = new Habitacion("Familiar");

        hotel.añadirHabitacion(habitacion1, supervisor);
        hotel.añadirHabitacion(habitacion2, supervisor);
        hotel.añadirHabitacion(habitacion3, supervisor);
        hotel.añadirHabitacion(habitacion4, supervisor);

        hotel.reservaHabitacion(new Cliente("444", "Frank"), habitacion2.getNumero());
        hotel.reservaHabitacion(new Cliente("333", "Menganito"), habitacion3.getNumero());
        hotel.reservaHabitacion(new Cliente("555", "El Fari"), habitacion4.getNumero());

        hotel.liberarHabitacion(habitacion3.getNumero(), limpiador);
        hotel.liberarHabitacion(habitacion4.getNumero(), limpiador);

        hotel.limpiarHabitacion(habitacion4.getNumero(), limpiador);

        hotel.mostrarInformacionHabitaciones();

    }
    @Test
    void testLimpiarHabitacionConReserva() {
        Hotel hotel = new Hotel("Mi Hotel");
        Supervisor supervisor = new Supervisor("111", "Juanito");
        Trabajador limpiador = new Trabajador("333", "Pepe");
        Cliente cliente = new Cliente("222", "Fulanito");
        Habitacion habitacion = new Habitacion("Standard");

        hotel.añadirHabitacion(habitacion, supervisor);
        hotel.reservaHabitacion(cliente, habitacion.getNumero());

        // Intentar limpiar una habitación reservada (debería lanzar una excepción)
        assertThrows(IllegalStateException.class, () -> {
            hotel.limpiarHabitacion(habitacion.getNumero(), limpiador);
        });
    }

    @Test
    void testLimpiarHabitacionInexistente() {
        Hotel hotel = new Hotel("Mi Hotel");
        Trabajador limpiador = new Trabajador("333", "Pepe");

        // Intentar limpiar una habitación inexistente (debería lanzar una excepción)
        assertThrows(IllegalStateException.class, () -> {
            hotel.limpiarHabitacion(1, limpiador);
        });
    }





}