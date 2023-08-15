/**
 * Clase Principal
 * Fernando Rueda - 23748
 * Descripción: Clase Principal que contiene el método main y ejecuta la lógica principal del sistema de compra de boletos.
 * Fecha de creación: [11/08/2023]
 * Fecha de última modificación: [14/08/2023]
 */
import java.util.Scanner;

public class Principal {
    /**
     * Método main que es el punto de entrada del programa.
     * Presenta un menú al usuario para interactuar con el sistema de compra de boletos.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner para recibir la entrada del usuario.
        TicketPurchaseSystem system = new TicketPurchaseSystem(); // Instancia del sistema de compra de boletos.

        boolean exit = false; // Bandera para controlar la salida del bucle del menú.
        while (!exit) {
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt(); // Opción seleccionada por el usuario.

            switch (option) {
                case 1:
                    System.out.println("Nuevo comprador registrado.");
                    break;
                case 2:
                    System.out.print("Cantidad de boletos: ");
                    int tickets = scanner.nextInt(); // Cantidad de boletos solicitada.
                    System.out.print("Presupuesto máximo: ");
                    int budget = scanner.nextInt(); // Presupuesto máximo del comprador.
                    if (system.requestPurchase(tickets, budget)) {
                        System.out.println("Compra exitosa!");
                    } else {
                        System.out.println("Compra fallida.");
                    }
                    break;
                case 3:
                    system.showTotalAvailability(); // Muestra la disponibilidad total de boletos.
                    break;
                case 4:
                    System.out.print("Elija una localidad (0, 1, 2): ");
                    int index = scanner.nextInt(); // Índice de la localidad seleccionada.
                    system.showIndividualAvailability(index); // Muestra la disponibilidad de la localidad seleccionada.
                    break;
                case 5:
                    system.showCashReport(); // Muestra el reporte de caja.
                    break;
                case 6:
                    exit = true; // Termina la ejecución del programa.
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo."); // Opción inválida.
            }
        }
        scanner.close(); // Cierra el objeto Scanner.
    }
}
