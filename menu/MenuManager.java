package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n1. Add Fresh Product");
        System.out.println("2. Add Packaged Product");
        System.out.println("3. View Products");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addFreshProduct();
                    case 2 -> addPackagedProduct();
                    case 3 -> viewProducts();
                    case 0 -> running = false;
                    default -> throw new InvalidInputException("Invalid menu choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            } catch (IllegalArgumentException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addFreshProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Days to expire: ");
        int days = Integer.parseInt(scanner.nextLine());

        products.add(new FreshProduct(name, price, days));
        System.out.println("Fresh product added!");
    }

    private void addPackagedProduct() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Weight: ");
        double weight = Double.parseDouble(scanner.nextLine());

        products.add(new PackagedProduct(name, price, weight));
        System.out.println("Packaged product added!");
    }

    private void viewProducts() {
        for (Product p : products) {
            p.displayInfo();
        }
    }
}
