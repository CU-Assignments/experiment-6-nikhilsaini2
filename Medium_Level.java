import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", ProductName: " + productName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

public class Medium_Level {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Product");
            System.out.println("2. Read Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    readProducts();
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        products.add(new Product(productId, productName, price, quantity));
        System.out.println("Product created successfully.");
    }

    private static void readProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        boolean found = false;

        for (Product product : products) {
            if (product.getProductId() == productId) {
                found = true;
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new Product Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new Quantity: ");
                int newQuantity = scanner.nextInt();

                product.setProductName(newName);
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                System.out.println("Product updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to delete: ");
        int productId = scanner.nextInt();
        boolean found = false;

        for (Product product : products) {
            if (product.getProductId() == productId) {
                products.remove(product);
                found = true;
                System.out.println("Product deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }
}