package strategyPattern;

public class PhonePePayment implements PaymentStrategy {
    private String phoneNumber;

    public PhonePePayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PhonePe account linked to " + phoneNumber);
    }
}
