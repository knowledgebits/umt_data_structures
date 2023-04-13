import java.util.*;

public class StockSpanProblem {

    public static int[] calculateStockSpan(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] spans = new int[prices.length];
        stack.push(0);
        spans[0] = 1;
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                spans[i] = i + 1;
            }
            else {
                spans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spans;
    }
    
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateStockSpan(prices);
        System.out.println(Arrays.toString(spans));
    }
}
