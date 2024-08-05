import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String productId;
    String name;
    double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price + " THB");
    }
}

class Smartphone extends Product {
    String OS;

    public Smartphone(String productId, String name, double price, String OS) {
        super(productId, name, price);
        this.OS = OS;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Operating System: " + OS);
    }
}

class Clothing extends Product {
    String size;

    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size);
    }
}

class Store {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.name);
    }

    Product findProduct(String productId) {
        for (Product product : products) {
            if (product.productId.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    void listProducts() {
        for (Product product : products) {
            product.displayInfo();
        }
    }
}

public class Main {
    static Store store = new Store();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Product Store Menu:");
            System.out.println("1. Add Product to store");
            System.out.println("2. List Products");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProductToStore();
                    break;
                case 2:
                    listProductsInStore();
                    break;
                case 3:
                    findProductInStore();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addProductToStore() {
        System.out.println("Enter product type [1 for Smartphone, 2 for Clothing]: ");
        int prdType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (prdType == 1) {
            System.out.print("Enter OS: ");
            String OS = scanner.nextLine();
            Smartphone smartphone = new Smartphone(productId, name, price, OS);
            store.addProduct(smartphone);
        } else if (prdType == 2) {
            System.out.print("Enter size: ");
            String size = scanner.nextLine();
            Clothing clothing = new Clothing(productId, name, price, size);
            store.addProduct(clothing);
        } else {
            System.out.println("Invalid product type.");
        }
    }

    static void listProductsInStore() {
        store.listProducts();
    }

    static void findProductInStore() {
        System.out.print("Enter Product ID to find: ");
        String productId = scanner.nextLine();
        Product product = store.findProduct(productId);
        if (product != null) {
            product.displayInfo();
        } else {
            System.out.println("Product not found.");
        }
    }
}