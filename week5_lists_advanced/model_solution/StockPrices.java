import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class StockPrices {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> stockPrices = readStockData("C:\\Users\\evisp\\eclipse-workspace\\DS-Sem5\\stockdata.csv");
        int maxProfit = getMaxProfit(stockPrices);
        System.out.println("Maximum profit: " + maxProfit);
    }
    
    public static LinkedList<Integer> readStockData(String filename) throws IOException {
        LinkedList<Integer> stockPrices = new LinkedList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            int price = Integer.parseInt(tokens[0]);
            stockPrices.add(price);
        }
        reader.close();
        return stockPrices;
    }
    
    public static int getMaxProfit(LinkedList<Integer> stockPrices) {
        if(stockPrices.size() < 2) {
            throw new IllegalArgumentException("List should contain at least 2 prices");
        }
        
        int minPrice = stockPrices.get(0);
        int maxProfit = stockPrices.get(1) - stockPrices.get(0);
        
        for(int i = 1; i < stockPrices.size(); i++) {
            int currentPrice = stockPrices.get(i);
            int potentialProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, currentPrice);
        }
        
        return maxProfit;
    }
}
