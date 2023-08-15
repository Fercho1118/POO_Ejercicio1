/**
 * Clase TicketPurchaseSystem
 * Fernando Rueda - 23748
 * Descripción: Clase TicketPurchaseSystem que maneja las operaciones relacionadas con la compra de boletos.
 * Fecha de creación: [11/08/2023]
 * Fecha de última modificación: [14/08/2023]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketPurchaseSystem {
    private List<Locality> localities; // Lista de localidades disponibles.
    private int totalTickets; // Contador de los tickets totales vendidos.

    /**
     * Constructor para inicializar las localidades y el contador de boletos.
     */
    public TicketPurchaseSystem() {
        this.localities = new ArrayList<>();
        this.localities.add(new Locality("Localidad 1", 100));
        this.localities.add(new Locality("Localidad 5", 500));
        this.localities.add(new Locality("Localidad 10", 1000));
        this.totalTickets = 0;
    }

    /**
     * Método para gestionar la compra de un boleto.
     *
     * @param requestedTickets Número de boletos solicitados.
     * @param budget Presupuesto del comprador.
     * @return true si la compra es exitosa, false en caso contrario.
     */
    public boolean requestPurchase(int requestedTickets, int budget) {
        int ticket = generateRandomNumber();
        int a = generateRandomNumber();
        int b = generateRandomNumber();

        if (!validateTicket(ticket, a, b)) {
            return false;
        }

        Locality locality = selectRandomLocation();
        if (!validatePurchase(requestedTickets, budget, locality)) {
            return false;
        }

        int ticketsSold = locality.sellTickets(requestedTickets);
        totalTickets += ticketsSold * locality.getPrice();
        return true;
    }

    /**
     * Método para generar un número aleatorio entre 1 y 15000.
     *
     * @return Número aleatorio generado.
     */
    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(15000) + 1;
    }

    /**
     * Método para validar el boleto según los criterios definidos.
     *
     * @param ticket Número de boleto.
     * @param a Número aleatorio a.
     * @param b Número aleatorio b.
     * @return true si el boleto es válido, false en caso contrario.
     */
    private boolean validateTicket(int ticket, int a, int b) {
        return ticket >= Math.min(a, b) && ticket <= Math.max(a, b);
    }

    /**
     * Método para seleccionar una localidad aleatoria de la lista de localidades.
     *
     * @return Localidad seleccionada aleatoriamente.
     */
    private Locality selectRandomLocation() {
        Random random = new Random();
        return localities.get(random.nextInt(localities.size()));
    }

    /**
     * Método para validar las condiciones de compra.
     *
     * @param tickets Número de boletos solicitados.
     * @param budget Presupuesto del comprador.
     * @param locality Localidad seleccionada.
     * @return true si la compra cumple las condiciones, false en caso contrario.
     */
    private boolean validatePurchase(int tickets, int budget, Locality locality) {
        return locality.checkSpace(tickets) && locality.checkPrice(budget);
    }

    /**
     * Método para mostrar cuántos boletos se han vendido en cada localidad y cuántos boletos están disponibles.
     */
    public void showTotalAvailability() {
        for (Locality locality : localities) {
            System.out.println(locality.getAvailableSpaces() + " tickets available for " + locality.getPrice());
        }
    }

    /**
     * Método para mostrar solo los boletos disponibles para la localidad seleccionada.
     *
     * @param index Índice de la localidad seleccionada.
     */
    public void showIndividualAvailability(int index) {
        if (index < 0 || index >= localities.size()) {
            System.out.println("Invalid locality.");
            return;
        }
        System.out.println(localities.get(index).getAvailableSpaces() + " tickets available for " + localities.get(index).getPrice());
    }

    /**
     * Método para mostrar cuánto se ha generado de dinero dados los boletos vendidos en todas las localidades.
     */
    public void showCashReport() {
        System.out.println("Total earnings: $" + totalTickets);
    }
}

