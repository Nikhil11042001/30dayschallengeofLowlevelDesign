package observable;

import observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class StockObservableImpl implements StockObservable {

    List<NotificationAlertObserver> observers = new ArrayList<>();

    int count=0;
    @Override
    public void add(NotificationAlertObserver notAlertObserver) {
        observers.add(notAlertObserver);
    }

    @Override
    public void delete(NotificationAlertObserver notAlertObserver) {
           observers.remove(notAlertObserver);
    }

    @Override
    public void notifySubscribers() {
         for(NotificationAlertObserver noAlertOb :observers){
                noAlertOb.update();
         }
    }

    @Override
    public void setCount(int newCount) {
          if(count==0){
              notifySubscribers();
          }
          count=count+newCount;
    }

    @Override
    public int getStockCount() {
        return count;
    }
}
