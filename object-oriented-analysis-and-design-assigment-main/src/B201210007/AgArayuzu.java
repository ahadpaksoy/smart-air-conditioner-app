package B201210007;


import java.util.Scanner;
public class AgArayuzu {
    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        IAnaIslemPlatformuGiris giris = new AnaIslemPlatformuGiris();
        IAnaIslemPlatformu processor = new AnaIslemPlatformu();

        String username;
        String password;

        int durum = 1;

        boolean sogutucuDurumu = false;

        do {
            System.out.println("Kullanici Adinizi Giriniz : ");
            username = scn.nextLine();
            System.out.println("Sifrenizi Giriniz : ");
            password = scn.nextLine();
        }while(!giris.giris(username, password));


        if (giris.giris(username, password)) {
            if (durum == 1) {
                int secim = 0;
                do {
                    System.out.println("**Cihazı açmak için 1'e basınız**");
                    secim = scn.nextInt();
                } while (secim != 1);
                durum = 3;
            }

            if (durum == 3) {
                int secim = 0;
                do {
                    System.out.println("**Sıcaklığı okumak için 1'e basınız**");
                    secim = scn.nextInt();
                } while (secim != 1);
                processor.sicaklikOku(); // Sıcaklık okunur
                durum = 2;
            }
            if (durum == 2) {

                int secim;
                do {
                    if (!sogutucuDurumu) // Soğutucu kapalıysa açma seçeneğinin arayüzde görüntülenmesi sağlanır
                        System.out.println("1-Soğutucuyu Aç");
                    else // Soğutucu açıksa kapatma seçeneğinin arayüzde görüntülenmesi sağlanır
                        System.out.println("2-Soğutucuyu Kapat");

                    System.out.println("3-Çıkış Yap");
                    secim = scn.nextInt();

                    if (secim == 1 && !sogutucuDurumu) { // Soğutucu kapalıysa ve açma seçeneği seçildiyse soğutucu açılır
                        processor.sogutucuAc();
                        sogutucuDurumu = true;
                    } else if (secim == 2 && sogutucuDurumu) { // Soğutucu açıksa ve kapatma seçeneği seçildiyse soğutucu kapatılır
                        processor.sogutucuKapat();
                        sogutucuDurumu = false;
                    } else if (secim == 3) {
                        System.out.println("Cıkıs Yapılıyor...");
                        Thread.sleep(1000);
                        System.out.println("Cihaz Kapatılıyor");
                    } else {
                        System.out.println("**Lütfen Geçerli Bir Seçenek Giriniz**");
                    }

                } while(secim != 3);

            }
        }
    }
}