import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
    private ArrayList<Product> inventory;

    public Supermarket() {
        inventory = new ArrayList<>();
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el precio de venta del producto: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, price);
        inventory.add(product);

        System.out.println("Producto agregado con éxito.");
    }

    public void listPrices() {
        System.out.println("Lista de precios:");
        for (Product product : inventory) {
            System.out.println(product.getName() + ": $" + product.getPrice());
        }
    }

    public void sellProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto a vender: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                inventory.remove(product);
                System.out.println("Producto vendido con éxito.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Mostrar precios de productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listPrices();
                    break;
                case 3:
                    sellProduct();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
