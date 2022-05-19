package B201210007;

public interface IEyleyici {
    IObserver kritikSogutma = new KritikSogutma();
    int sogutucuAc(int sicaklik) throws InterruptedException;
    void sogutucuKapat() throws InterruptedException;
}
