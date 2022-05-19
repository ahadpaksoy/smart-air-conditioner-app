package B201210007;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private int kritikSicaklik = 45;


    @Override
    public List<Serializable> sicaklikOku() throws InterruptedException {
        System.out.println("Sicaklik okunuyor...");
        Random rand = new Random();
        int randomVal = rand.nextInt(80);
        Thread.sleep(500);
        System.out.println("Sicaklik : " + randomVal);
        return Arrays.asList(randomVal,this.kritikSicaklik);
    }
}
