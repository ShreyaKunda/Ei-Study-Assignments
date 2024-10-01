// StockMarketObserver.java

public class StockMarketObserver {
    public static void main(String[] args) {
        // Create a stock
        Stock appleStock = new Stock("Apple", 150.0);

        // Create investors
        StockInvestor investor1 = new StockInvestor("Alice");
        StockInvestor investor2 = new StockInvestor("Bob");

        // Attach investors to the stock
        appleStock.attach(investor1);
        appleStock.attach(investor2);

        // Change stock price
        appleStock.setPrice(155.0); // Both investors will be notified
        appleStock.setPrice(160.0); // Both investors will be notified again

        // Detach an investor
        appleStock.detach(investor1);

        // Change stock price
        appleStock.setPrice(165.0); // Only Bob will be notified
    }
}
