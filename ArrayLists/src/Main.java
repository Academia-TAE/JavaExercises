import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket supermarket = new Supermarket();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Sell Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    supermarket.addProduct(new Product(name, price));
                    break;
                case 2:
                    supermarket.listProducts();
                    break;
                case 3:
                    System.out.print("Enter product name to sell: ");
                    String productName = scanner.nextLine();
                    supermarket.sellProduct(productName);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
