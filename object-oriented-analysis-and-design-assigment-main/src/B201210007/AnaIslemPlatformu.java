package B201210007;

import java.util.List;
import java.io.Serializable;

public class AnaIslemPlatformu implements IAnaIslemPlatformu{
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IEyleyici eyleyici;
    private final IPublisher publisher;

    private int sonSicaklik;
    private int kritikSicaklik;

    public AnaIslemPlatformu(){
        this.sicaklikAlgilayici =new SicaklikAlgilayici();
        this.eyleyici = new Eyleyici();
        this.publisher = new Publisher();

        this.publisher.attach(this.eyleyici.kritikSogutma);

    }
    private void kritikSicaklikKontrol() throws InterruptedException {
        if (this.sonSicaklik >= this.kritikSicaklik) {
            this.sonSicaklik = this.publisher.kritikSicaklikBildir("***Sıcaklık Kritik Eşiğin Üzerinde!!***", this.sonSicaklik, this.eyleyici);
            this.eyleyici.sogutucuKapat();
            this.kritikSicaklikKontrol();
        }

    }

    @Override
    public void sicaklikOku() throws InterruptedException {
        List<Serializable> algilayiciBilgileri = this.sicaklikAlgilayici.sicaklikOku();
        this.sonSicaklik = (int) algilayiciBilgileri.get(0);
        this.kritikSicaklik = (int)algilayiciBilgileri.get(1);

        this.kritikSicaklikKontrol();
    }

    @Override
    public void sogutucuAc() throws InterruptedException {
        this.sonSicaklik = this.eyleyici.sogutucuAc(this.sonSicaklik);
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        this.eyleyici.sogutucuKapat();
    }
}
