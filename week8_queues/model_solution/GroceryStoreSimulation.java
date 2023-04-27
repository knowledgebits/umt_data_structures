import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Customer {
    private String name;
    private int items;
    private int itemScanTime;

    public Customer(String name, int items, int itemScanTime) {
        this.name = name;
        this.items = items;
        this.itemScanTime = itemScanTime;
    }

    public String getName() {
        return name;
    }

    public int getItems() {
        return items;
    }

    public int getItemScanTime() {
        return itemScanTime;
    }
}

public class GroceryStoreSimulation {
    private Queue<Customer> customerQueue;
    private int totalCustomers;
    private int totalItems;
    private int totalTime;

    public GroceryStoreSimulation() {
        customerQueue = new LinkedList<>();
        Random random = new Random();
        totalCustomers = random.nextInt(20) + 10;

        // Generate random customers with random item counts and scan times
        for (int i = 1; i <= totalCustomers; i++) {
            int items = random.nextInt(15) + 1;
            totalItems += items;
            int itemScanTime = random.nextInt(5) + 1;
            Customer customer = new Customer("Customer " + i, items, itemScanTime);
            customerQueue.add(customer);
        }
    }

    public void processCustomers() {
        // Process each customer in the queue
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.remove();
            int scanTime = customer.getItems() * customer.getItemScanTime();
            totalTime += scanTime;
            System.out.printf("%s is checking out with %d items (total scan time: %d seconds)%n",
                    customer.getName(), customer.getItems(), scanTime);
        }
    }

    public void printStatistics() {
        // Calculate and print statistics
        double avgTime = (double) totalTime / totalCustomers;
        System.out.printf("Total customers processed: %d%n", totalCustomers);
        System.out.printf("Average checkout time per customer: %.2f seconds%n", avgTime);
    }

    public static void main(String[] args) {
        GroceryStoreSimulation simulation = new GroceryStoreSimulation();
        simulation.processCustomers();
        simulation.printStatistics();
    }
}
