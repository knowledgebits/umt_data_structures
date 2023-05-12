import java.util.*;

public class TowersOfHanoi {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numDisks = input.nextInt();
        
        Stack<Integer> start = new Stack<Integer>();
        Stack<Integer> spare = new Stack<Integer>();
        Stack<Integer> target = new Stack<Integer>();
        
        // Push disks onto start stack in descending order
        for (int i = numDisks; i >= 1; i--) {
            start.push(i);
        }
        
        // Print starting configuration
        printStacks(start, spare, target);
        
        // Call recursive method to solve Towers of Hanoi problem
        moveDisks(numDisks, start, target, spare);
    }
    
    // Recursive method to move disks from start to target using spare
    public static void moveDisks(int numDisks, Stack<Integer> start, Stack<Integer> target, Stack<Integer> spare) {
        if (numDisks == 1) {
            // Move top disk from start to target
            int disk = start.pop();
            target.push(disk);
            System.out.println("Move disk " + disk + " from " + start + " to " + target);
            printStacks(start, spare, target);
        } else {
            // Move n-1 disks from start to spare using target
            moveDisks(numDisks-1, start, spare, target);
            
            // Move bottom disk from start to target
            int disk = start.pop();
            target.push(disk);
            System.out.println("Move disk " + disk + " from " + start + " to " + target);
            printStacks(start, spare, target);
            
            // Move n-1 disks from spare to target using start
            moveDisks(numDisks-1, spare, target, start);
        }
    }
    
    // Helper method to print the current configuration of the stacks
    public static void printStacks(Stack<Integer> start, Stack<Integer> spare, Stack<Integer> target) {
        System.out.println("Start: " + start);
        System.out.println("Spare: " + spare);
        System.out.println("Target: " + target);
        System.out.println();
    }
    
}
