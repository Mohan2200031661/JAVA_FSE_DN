package strategyPattern;

public class PaytmPayment implements PaymentStrategy {
    private String mobileNumber;

    public PaytmPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Paytm account linked to " + mobileNumber);
    }
}

