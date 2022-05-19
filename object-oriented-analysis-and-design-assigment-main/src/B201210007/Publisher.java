package B201210007;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher{
    private final List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public int kritikSicaklikBildir(String message, int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException {
        System.out.println(message);
        for (IObserver subscriber:subscribers){
            kritikSicaklik = subscriber.kritikDurum(kritikSicaklik,eyleyici);
        }
        return kritikSicaklik;
    }

}
