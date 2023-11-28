import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class VintageClothingStore {
    private final Store store;
    private final ShoppingCart cart;

    public VintageClothingStore() {
        store = new Store();
        cart = new ShoppingCart();
    }
    public void signUpCustomer(String name, String email) {
        Customer customer = new Customer(name, email);
        System.out.println("Signed up new customer: " + customer.getName() + " - " + customer.getEmail());
    }

    public void manageProducts() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Select an option:");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Display inventory");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter product Id: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter product quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(productId ,name, price, quantity);
                    store.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;
                case "2":
                    store.displayInventory();
                    System.out.print("Enter the index of the product to remove: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index >= 0 && index < store.getInventory().size()) {
                        Product productToRemove = store.getInventory().get(index);
                        store.removeProduct(productToRemove);
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case "3":
                    store.displayInventory();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

            System.out.println();
        } while (!choice.equals("4"));
    }

    public void manageShoppingCart() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Select an option:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Display cart");
            System.out.println("4. Calculate total");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    store.displayInventory();
                    System.out.print("Enter the index of the product to add to the cart: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index >= 0 && index < store.getInventory().size()) {
                        Product product = store.getInventory().get(index);
                        cart.addItem(product);
                        System.out.println("Product added to the cart successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case "2":
                    cart.displayItems();
                    System.out.print("Enter the index of the product to remove from the cart: ");
                    int removeIndex = Integer.parseInt(scanner.nextLine());
                    if (removeIndex >= 0 && removeIndex < cart.getItems().size()) {
                        Product productToRemove = cart.getItems().get(removeIndex);
                        cart.removeItem(productToRemove);
                        System.out.println("Product removed from the cart successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case "3":
                    cart.displayItems();
                    break;
                case "4":
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;
                case "5":
                    cart.purchase();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

            System.out.println();
        } while (!choice.equals("6"));
    }
}