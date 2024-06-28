/* Java Lab Implementation Dt. 5 June

   Write a program in java to implement a cafe ordering system with following requirements;

   1. Menu Management - The cafe staff should be able to edit and remove item from the menu, each menu item has a
   name, description, price and availability season.

   2. The Customers should be able to view the menu, select items and add them to their order, check status and cancel order.

   3. Calculate the total amount of order, verify the order.

   4. Categories dishes.

   5. Throw Exceptions in Exceptional situations.

*/

import java.util.*;

// Creating a Menu for a Cafe!

class MenuItem {
    String item;
    String description;
    double price;
    String availabilitySeason;
    public MenuItem(String item, String description, double price, String availabilitySeason) {
        this.item = item;
        this.description = description;
        this.price = price;
        this.availabilitySeason = availabilitySeason;
    }
    public String getName() {
        return item;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String getAvailabilitySeason() {
        return availabilitySeason;
    }
}

// Creating a list of ordered items.

class OrderItem {
    MenuItem menuItem;
    int quantity;
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQuantity() {
        return quantity;
    }
}
class Order {
    List<OrderItem> orderItems;
    double totalAmount;
    String status;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = "Placed";
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
        totalAmount += item.getQuantity() * item.getMenuItem().getPrice();
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
        totalAmount -= item.getQuantity() * item.getMenuItem().getPrice();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Restaurant {
    List<MenuItem> menu;
    List<Order> orders;
    public Restaurant() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }
    public void removeMenuItem(MenuItem menuItem) {
        menu.remove(menuItem);
    }
    public List<MenuItem> getMenu() {
        return menu;
    }
    public void placeOrder(Order order) {
        orders.add(order);
    }
    public void updateOrderStatus(Order order, String status) {
        order.setStatus(status);
    }

    public void printOrderDetails(Order order) {
        System.out.println("The details of order are as follows;");
        System.out.println("Order Status: " + order.getStatus());
        System.out.println("Total Amount: Rs. " + order.getTotalAmount());
        System.out.println("Items:");
        int cnt = 0;
        for (OrderItem item : order.getOrderItems()) {
            cnt++;
            MenuItem menuItem = item.getMenuItem();
            System.out.println(cnt + ". " + menuItem.getName() + ", Quantity: " + item.getQuantity() + ", Price: Rs." +
                    menuItem.getPrice() + ", Description: " + menuItem.getDescription());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        MenuItem item1 = new MenuItem("Hyderabadi Dum Biryani", "Feel the taste of Hyderabad", 240, "Only Weekdays");
        MenuItem item2 = new MenuItem("Chicken Biryani", "2 boneless pieces with basmati rice", 170, "All Seasons");
        MenuItem item3 = new MenuItem("Mix Salad", "Healthy salad", 40, "Summers");
        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item3);

        Order order = new Order();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            // Here, we will be displaying the menu ...

            System.out.println("Menu:");
            List<MenuItem> menu = restaurant.getMenu();
            for (int i = 0; i < menu.size(); i++) {
                MenuItem menuItem = menu.get(i);
                System.out.println((i + 1) + ". " + menuItem.getName() + " - Rs. " + menuItem.getPrice());
                System.out.println("   " + menuItem.getDescription());
                System.out.println("   Availability: " + menuItem.getAvailabilitySeason());
                System.out.println();
            }

            // Here is the prompt for the user choice
            System.out.println("Enter the number of the item to add (0 to exit): ");
            choice = scanner.nextInt();

            try {
                if (choice > 0 && choice <= menu.size()) {
                    
                    // Here's the Exception Handeling!
                    
                    MenuItem selectedItem = menu.get(choice - 1);
                    System.out.println("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    if (quantity <= 0) {
                        throw new IllegalArgumentException("Quantity must be greater than zero.");
                    }
                    order.addItem(new OrderItem(selectedItem, quantity));
                    System.out.println("Item added to the order.");
                } else if (choice != 0) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
            System.out.println();
        } while (choice != 0);

        if (order.getOrderItems().isEmpty()) {
            System.out.println("No items in the order. Exiting...");
            return;
        }

        restaurant.placeOrder(order);

        restaurant.updateOrderStatus(order, "In Progress");

        // Finally, we are displaying the order details
        restaurant.printOrderDetails(order);

        scanner.close();
    }
}
