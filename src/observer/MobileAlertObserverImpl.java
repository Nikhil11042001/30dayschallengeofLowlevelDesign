package observer;

import observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String userName;
    StockObservable stockObservable;
    public MobileAlertObserverImpl(String userName,StockObservable stockObservable){
        this.userName = userName;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendMessageOnMobile(userName,"Message sent successfully");
    }

    public void sendMessageOnMobile(String userName,String message){
        System.out.println("msg sent to:"+userName);
    }
}
