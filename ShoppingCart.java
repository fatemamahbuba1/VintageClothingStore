import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayItems() {
        if (items.size() == 0) {
            System.out.println("Shopping Cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (Product item : items) {
                System.out.println("- " + item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total: $" + calculateTotal());
        }
    }

    public List<Product> getItems() {
        return items;
    }
    public boolean purchase() {
        Scanner scanner = new Scanner(System.in);
        double amount;
        double total = 0.0;

        // Calculate the total amount due
        for (Product item : items) {
            total += item.getPrice();
        }
        System.out.print(total + "$ Is Due (Enter $): ");
        amount = scanner.nextDouble();

        // Check if the entered payment matches the total due
        if (amount >= total) {
            // Payment successful
            double change = amount - total;
            System.out.println("Payment successful! Your change is: $" + change);

            // Perform actions like updating inventory and sending confirmation email

            // For demonstration purposes, let's print a simple confirmation message
            System.out.println("Thank you for your purchase!");
            emptyCart(); // Empty the cart after purchase
            return true; // Return true to indicate successful purchase
        } else {
            // Insufficient payment
            System.out.println("Insufficient payment. Please enter the correct amount.");
            return false; // Return false to indicate unsuccessful purchase
        }
    }

    private void emptyCart() {
        items.clear();
    }
}