package observer;

import observable.StockObservable;

public class EmailObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable stockObservable;

     public EmailObserverImpl(String emailId,StockObservable stockObservable){
         this.emailId=emailId;
         this.stockObservable=stockObservable;
     }

    @Override
    public void update() {
         sendMail(emailId,"Product is in Stock hurry up!");

    }

    private void sendMail(String emailId, String s) {
         System.out.println("email sent to"+emailId);
    }
}
