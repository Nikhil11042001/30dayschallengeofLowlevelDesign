package payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public void pay() {
        System.out.println("Payment using credit card is made successfully");
    }
}
