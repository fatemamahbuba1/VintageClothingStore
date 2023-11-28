import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        VintageClothingStore VintageClothingStore = new VintageClothingStore();

        do {
            System.out.println("Select an option:");
            System.out.println("1. Sign up new customer");
            System.out.println("2. Manage products");
            System.out.println("3. Manage shopping cart");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    VintageClothingStore.signUpCustomer(name, email);
                    break;
                case "2":
                    VintageClothingStore.manageProducts();
                    break;
                case "3":
                    VintageClothingStore.manageShoppingCart();
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
}