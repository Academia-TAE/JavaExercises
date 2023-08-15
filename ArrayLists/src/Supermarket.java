import java.util.ArrayList;
import java.util.List;

public class Supermarket {
    private List<Product> inventory;

    public Supermarket() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void listProducts() {
        System.out.println("Available Products:");
        for (Product product : inventory) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public void sellProduct(String productName) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                inventory.remove(product);
                System.out.println("Sold: " + product.getName());
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }
}
