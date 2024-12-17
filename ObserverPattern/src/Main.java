import observable.StockObservable;
import observable.StockObservableImpl;
import observer.EmailObserverImpl;
import observer.MobileAlertObserverImpl;
import observer.NotificationAlertObserver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StockObservable iphoneStockObservable = new StockObservableImpl();

        NotificationAlertObserver observer1 = new EmailObserverImpl("xyz@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailObserverImpl("radhika@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("nikhil.shukla03",iphoneStockObservable);
        NotificationAlertObserver observer4 = new MobileAlertObserverImpl("akash.yadav21",iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.setCount(2);
        int y=iphoneStockObservable.getStockCount();
        System.out.println("Count is :{}"+y);
    }
}