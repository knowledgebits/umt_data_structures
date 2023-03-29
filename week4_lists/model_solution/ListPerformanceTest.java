import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

public class ListPerformanceTest {
    
    public static void main(String[] args) {
        // Create LinkedList and ArrayList of size 100,000
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        int size = 100000;
        Random random = new Random();
        
        // Populate lists with random strings
        for (int i = 0; i < size; i++) {
            String s = generateRandomString(random, 10);
            linkedList.add(s);
            arrayList.add(s);
        }
        
        // Perform search operation 100 times and calculate average time
        String target = generateRandomString(random, 10);
        long linkedListTime = 0;
        long arrayListTime = 0;
        int iterations = 100;
        for (int i = 0; i < iterations; i++) {
            // Search LinkedList
            long startTime = System.nanoTime();
            int index = linkedList.indexOf(target);
            long endTime = System.nanoTime();
            linkedListTime += (endTime - startTime);
            
            // Search ArrayList
            startTime = System.nanoTime();
            index = arrayList.indexOf(target);
            endTime = System.nanoTime();
            arrayListTime += (endTime - startTime);
        }
        
        // Calculate average time
        double linkedListAvgTime = (double) linkedListTime / iterations;
        double arrayListAvgTime = (double) arrayListTime / iterations;
        
        // Output results
        System.out.println("Average search time for LinkedList: " + linkedListAvgTime + " nanoseconds.");
        System.out.println("Average search time for ArrayList: " + arrayListAvgTime + " nanoseconds.");
        if (linkedListAvgTime < arrayListAvgTime) {
            System.out.println("LinkedList is faster for this operation.");
        } else {
            System.out.println("ArrayList is faster for this operation.");
        }
    }
    
    public static String generateRandomString(Random random, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        return sb.toString();
    }
}
