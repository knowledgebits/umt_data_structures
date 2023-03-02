import java.util.*;

public class BasicAlgorithms {
	
	public static List<String> findUnique(List<String> list) {
	    Set<String> set = new LinkedHashSet<>();
	    for (String s : list) {
	        set.add(s);
	    }
	    return new ArrayList<>(set);
	}
	
	public static List<Integer> findEven(List<Integer> list) {
	    List<Integer> result = new ArrayList<>();
	    for (int i : list) {
	        if (i % 2 == 0) {
	            result.add(i);
	        }
	    }
	    return result;
	}

	
	public static int[] removeDuplicates(int[] arr) {
	    Set<Integer> set = new LinkedHashSet<>();
	    for (int i : arr) {
	        set.add(i);
	    }
	    int[] result = new int[set.size()];
	    int i = 0;
	    for (int n : set) {
	        result[i++] = n;
	    }
	    return result;
	}

	
	public static int findKthSmallest(List<Integer> list, int k) {
	    if (k < 1 || k > list.size()) {
	        throw new IllegalArgumentException("k must be between 1 and the size of the list");
	    }
	    List<Integer> sorted = new ArrayList<>(list);
	    Collections.sort(sorted);
	    return sorted.get(k - 1);
	}
	
	public static List<Integer> longestIncreasingSubsequence(List<Integer> list) {
	    int[] dp = new int[list.size()];
	    List<Integer>[] sequences = new List[list.size()];
	    int maxLength = 0;
	    int maxIndex = 0;
	    for (int i = 0; i < list.size(); i++) {
	        dp[i] = 1;
	        sequences[i] = new ArrayList<>();
	        sequences[i].add(list.get(i));
	        for (int j = 0; j < i; j++) {
	            if (list.get(j) < list.get(i)) {
	                if (dp[j] + 1 > dp[i]) {
	                    dp[i] = dp[j] + 1;
	                    sequences[i] = new ArrayList<>(sequences[j]);
	                    sequences[i].add(list.get(i));
	                }
	            }
	        }
	        if (dp[i] > maxLength) {
	            maxLength = dp[i];
	            maxIndex = i;
	        }
	    }
	    return sequences[maxIndex];
	}
	
	public static List<Integer> findLongestConsecutiveSequence(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        int maxCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (result.contains(nums.get(i))) {
                continue;
            }

            int count = 1;
            int num = nums.get(i);
            while (nums.contains(num + 1)) {
                count++;
                num++;
            }
            if (count > maxCount) {
                maxCount = count;
                result.clear();
                for (int j = num - count + 1; j <= num; j++) {
                    result.add(j);
                }
            }
        }
        return result;
    }


	public static void main(String[] args) {
		/* test here all the developed functions */
		Integer[] data = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		List<Integer> numbers = Arrays.asList(data);
		
		System.out.println(findKthSmallest(numbers, 3));
	}

}
