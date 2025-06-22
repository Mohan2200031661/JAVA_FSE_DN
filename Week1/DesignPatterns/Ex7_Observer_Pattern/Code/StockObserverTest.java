package observerPattern;

public class StockObserverTest {
    public static void main(String[] args) {
        StockMarket bse = new StockMarket();

        Observer mobileUser = new MobileApp("Ravi");
        Observer webUser = new WebApp("NSE Tracker");

        bse.registerObserver(mobileUser);
        bse.registerObserver(webUser);

        bse.setStock("TCS", 3985.50);
        bse.setStock("Infosys", 1468.25);

        bse.removeObserver(webUser);

        bse.setStock("Reliance", 2765.10);
    }
}

