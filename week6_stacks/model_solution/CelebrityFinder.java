import java.util.*;

public class CelebrityFinder {
	
	public static int findCelebrity(int[][] acquaintances) {
	    Stack<Integer> stack = new Stack<>();
	    int n = acquaintances.length;

	    // Push all people onto the stack
	    for (int i = 0; i < n; i++) {
	        stack.push(i);
	    }

	    // Eliminate non-celebrities
	    while (stack.size() > 1) {
	        int person1 = stack.pop();
	        int person2 = stack.pop();

	        if (acquaintances[person1][person2] == 1) {
	            // person1 knows person2, so person1 cannot be the celebrity
	            stack.push(person2);
	        } else {
	            // person1 does not know person2, so person2 cannot be the celebrity
	            stack.push(person1);
	        }
	    }

	    int potentialCelebrity = stack.pop();

	    // Check if potentialCelebrity is actually the celebrity
	    for (int i = 0; i < n; i++) {
	        if (i != potentialCelebrity) {
	            if (acquaintances[potentialCelebrity][i] == 1 || acquaintances[i][potentialCelebrity] == 0) {
	                return -1; // potentialCelebrity is not the celebrity
	            }
	        }
	    }

	    return potentialCelebrity;
	}
	
	public static void main(String[] args) {
	    int[][] acquaintances = {
	            {1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 0, 1, 1},
	            {0, 0, 1, 1}
	    };
	    int celebrity = findCelebrity(acquaintances);
	    if (celebrity == -1) {
	        System.out.println("There is no celebrity in the group.");
	    } else {
	        System.out.println("The celebrity is person " + celebrity + ".");
	    }
	}



}
