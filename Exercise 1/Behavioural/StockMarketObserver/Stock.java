// Stock.java

import java.util.ArrayList;
import java.util.List;

// Subject class
public class Stock {
    private String name;
    private double price;
    private List<Investor> investors;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public void attach(Investor investor) {
        investors.add(investor);
    }

    public void detach(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(name, price);
        }
    }
}
