package B201210007;

public class KritikSogutma implements IObserver{
    @Override
    public int kritikDurum(int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException {
        System.out.println("Kritik sogutma devreye giriyor...");
        Thread.sleep(500);
        return eyleyici.sogutucuAc(kritikSicaklik);

    }
}
