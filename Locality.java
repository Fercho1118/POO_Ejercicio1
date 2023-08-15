/**
 * Clase Locality
 * Fernando Rueda - 23748
 * Descripción: Clase Locality que representa una localidad en el sistema de compra de boletos.
 * Fecha de creación: [11/08/2023]
 * Fecha de última modificación: [14/08/2023]
 */
public class Locality {
    private String name; // Nombre de la localidad.
    private int price; // Precio de la localidad.
    private int availableSpaces; // Espacios disponibles en la localidad.

    /**
     * Constructor para inicializar la localidad con un nombre y precio, y un número predeterminado de espacios disponibles.
     *
     * @param name Nombre de la localidad.
     * @param price Precio de la localidad.
     */
    public Locality(String name, int price) {
        this.name = name;
        this.price = price;
        this.availableSpaces = 20; // Espacios disponibles predeterminados.
    }

    /**
     * Método para verificar si hay suficientes espacios disponibles en la localidad para el número de boletos solicitados.
     *
     * @param tickets Número de boletos solicitados.
     * @return true si hay suficientes espacios disponibles, false en caso contrario.
     */
    public boolean checkSpace(int tickets) {
        return availableSpaces >= tickets;
    }

    /**
     * Método para verificar si el precio de la localidad está dentro del presupuesto dado.
     *
     * @param budget Presupuesto dado.
     * @return true si el precio está dentro del presupuesto, false en caso contrario.
     */
    public boolean checkPrice(int budget) {
        return price <= budget;
    }

    /**
     * Método para vender boletos y actualizar el número de espacios disponibles en la localidad.
     *
     * @param requestedTickets Número de boletos solicitados para comprar.
     * @return Número de boletos que se pueden vender (menor o igual a los solicitados).
     */
    public int sellTickets(int requestedTickets) {
        int ticketsToSell = Math.min(requestedTickets, availableSpaces);
        availableSpaces -= ticketsToSell;
        return ticketsToSell;
    }

    /**
     * Método para obtener el precio de la localidad.
     *
     * @return Precio de la localidad.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Método para obtener el número de espacios disponibles en la localidad.
     *
     * @return Espacios disponibles en la localidad.
     */
    public int getAvailableSpaces() {
        return availableSpaces;
    }
}
