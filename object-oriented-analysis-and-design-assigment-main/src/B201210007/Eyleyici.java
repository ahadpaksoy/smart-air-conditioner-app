package B201210007;

public class Eyleyici implements IEyleyici{

    @Override
    public int sogutucuAc(int sicaklik) throws InterruptedException {
        System.out.println("Sogutucu Açılıyor...");
        Thread.sleep(1000);
        sicaklik -=10;
        System.out.println("Yeni sicaklik : " + sicaklik);
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        System.out.println("Sogutucu Kaptılıyor...");
        Thread.sleep(1000);
        System.out.println("Sogutucu Kapatıldı.");
    }
}
