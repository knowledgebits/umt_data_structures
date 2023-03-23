import java.util.*;

public class ArrayManipulations {
	
	public static int maxDifference(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int min = arr[0];
        int maxDiff = 0;

        for (int i = 1; i < arr.length; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - min);
            min = Math.min(min, arr[i]);
        }

        return maxDiff;
    }

	
	public static int[] findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new LinkedHashSet<>();
        
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                intersection.add(arr2[i]);
            }
        }
        
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int value : intersection) {
            result[i++] = value;
        }
        
        return result;
    }
	
	 public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
	        int n = arr1.length + arr2.length;
	        int[] result = new int[n];
	        int i = 0, j = 0, k = 0;

	        while (i < arr1.length && j < arr2.length) {
	            if (arr1[i] < arr2[j]) {
	                result[k++] = arr1[i++];
	            } else {
	                result[k++] = arr2[j++];
	            }
	        }

	        while (i < arr1.length) {
	            result[k++] = arr1[i++];
	        }

	        while (j < arr2.length) {
	            result[k++] = arr2[j++];
	        }

	        return result;
	    }
	
	public static void main(String[] args) {
        int[] arr1 = {11, 2, 3, 7, 5};
        int[] arr2 = {3, 5, 7, 9};
        
        int maxDiff = maxDifference(arr1);
        System.out.println("Maximum difference: " + maxDiff);
        
        int[] intersection = findIntersection(arr1, arr2);
        
        System.out.print("[ ");
        for (int i = 0; i < intersection.length; i++) {
            System.out.print(intersection[i] + " ");
        }
        System.out.println("]");
        
        int[] sortedArr1 = {1, 3, 5, 7, 9};
        int[] sortedArr2 = {2, 4, 6, 8, 10};
        int[] result = mergeSortedArrays(sortedArr1, sortedArr2);
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

}
