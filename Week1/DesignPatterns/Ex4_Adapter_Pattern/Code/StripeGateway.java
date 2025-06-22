package adapterPattern;

public class StripeGateway {
    public void pay(double amountInRupees) {
        System.out.println("Payment of ₹" + amountInRupees + " processed via Stripe.");
    }
}

