package strategyPattern;
public class PaymentTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234567890123456", "Rahul Kumar", "123", "12/26"));
        context.executePayment(1500.00);

        context.setPaymentStrategy(new PhonePePayment("9876543210"));
        context.executePayment(2000.00);

        context.setPaymentStrategy(new PaytmPayment("9123456780"));
        context.executePayment(2500.00);
    }
}
