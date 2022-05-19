package B201210007;

public class AnaIslemPlatformuGiris implements IAnaIslemPlatformuGiris{
    private final IVeritabaniIslemleri veritabani;

    public AnaIslemPlatformuGiris() {
        this.veritabani = new VeritabaniIslemleri();
    }

    @Override
    public boolean giris(String username, String password) throws InterruptedException {
        Thread.sleep(1500);
        if (this.veritabani.giris(username, password)) {
            return true;
        } else {
            return false;
        }
    }
}
