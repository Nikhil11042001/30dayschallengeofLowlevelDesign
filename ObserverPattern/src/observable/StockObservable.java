package observable;

import observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver notAlertObserver);
    public void delete(NotificationAlertObserver notAlertObserver);
    public void notifySubscribers();
    public void setCount(int newCount);
    public int getStockCount();
}
