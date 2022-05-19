package B201210007;

public interface IObserver {
    int kritikDurum(int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException;
}
