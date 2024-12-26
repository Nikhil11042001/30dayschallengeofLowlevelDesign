package payment;

public class PaypalPaymentProcessor implements PaymentProcessor{
    @Override
    public void pay() {
        System.out.println("Payment using Paypal  is made successfully");
    }
}
