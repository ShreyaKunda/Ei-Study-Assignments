// StockInvestor.java

// Concrete Observer class
public class StockInvestor implements Investor {
    private String name;

    public StockInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Investor " + name + " notified. " + stockName + " price: $" + stockPrice);
    }
}
