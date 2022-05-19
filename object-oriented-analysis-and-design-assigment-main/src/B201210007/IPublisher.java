package B201210007;

public interface IPublisher {
    void attach(IObserver observer);
    void detach(IObserver observer);

    int kritikSicaklikBildir(String message, int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException;

}
