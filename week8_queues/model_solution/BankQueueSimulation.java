import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BankQueueSimulation {

    public static void main(String[] args) {
        Bank bank = new Bank(10, 5);
        bank.simulate();
        bank.printStatistics();
    }
}

class Bank {

    private Queue<BankCustomer> queue;
    private int totalCustomers;
    private int currentTime;
    private int maxTransactionTime;
    private int maxArrivalInterval;

    public Bank(int totalCustomers, int maxTransactionTime) {
        this.queue = new LinkedList<>();
        this.totalCustomers = totalCustomers;
        this.currentTime = 0;
        this.maxTransactionTime = maxTransactionTime;
        this.maxArrivalInterval = 3;
    }

    public void simulate() {
        Random random = new Random();
        int customerId = 1;
        int nextArrivalTime = random.nextInt(maxArrivalInterval + 1);
        for (int i = 0; i < totalCustomers; i++) {
            if (currentTime == nextArrivalTime) {
                int transactionTime = random.nextInt(maxTransactionTime) + 1;
                BankCustomer customer = new BankCustomer(customerId, currentTime, transactionTime);
                queue.add(customer);
                customerId++;
                nextArrivalTime = currentTime + random.nextInt(maxArrivalInterval + 1);
            }
            if (!queue.isEmpty()) {
            	BankCustomer currentCustomer = queue.peek();
                currentCustomer.process(currentTime);
                if (currentCustomer.isDone()) {
                    queue.remove();
                }
            }
            currentTime++;
        }
    }

    public void printStatistics() {
        int totalWaitTime = 0;
        int maxWaitTime = 0;
        int numCustomersWaiting = 0;
        for (BankCustomer customer : queue) {
            totalWaitTime += customer.getWaitTime();
            maxWaitTime = Math.max(maxWaitTime, customer.getWaitTime());
            numCustomersWaiting++;
        }
        int numCustomersServed = totalCustomers - numCustomersWaiting;
        double avgWaitTime = (double) totalWaitTime / numCustomersServed;
        int numCustomersExceedingThreshold = 0;
        for (BankCustomer customer : queue) {
            if (customer.getWaitTime() > 5) { // threshold of 5 minutes
                numCustomersExceedingThreshold++;
            }
        }
        System.out.println("Total customers served: " + numCustomersServed);
        System.out.println("Average waiting time per customer: " + avgWaitTime);
        System.out.println("Maximum waiting time for any customer: " + maxWaitTime);
        System.out.println("Number of customers waiting more than 5 minutes: " + numCustomersExceedingThreshold);
    }
}

class BankCustomer {

    private int id;
    private int arrivalTime;
    private int transactionTime;
    private int startTime;
    private int endTime;

    public BankCustomer(int id, int arrivalTime, int transactionTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
    }

    public void process(int currentTime) {
        if (startTime == 0) {
            startTime = currentTime;
        }
        if (endTime == 0 && startTime + transactionTime <= currentTime) {
            endTime = startTime + transactionTime;
        }
    }

    public boolean isDone() {
        return endTime != 0;
    }

    public int getWaitTime() {
        return startTime - arrivalTime;
    }
}
