import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Product> inventory;

    public Store() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    public void displayInventory() {
        if (inventory.size() == 0) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (int i = 0; i < inventory.size(); i++) {
                Product product = inventory.get(i);
                System.out.println(i + ". " + product.getName() + " - $" + product.getPrice() + " - Quantity: " + product.getQuantity());
            }
        }
    }


    public List<Product> getInventory() {
        return inventory;
    }
}

