/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Rasgeleligi random veya baska bir hazir metod
 * kullanmadan saglayan sinif.
 *
 *
 */
package Pdp_RastgeleKisiUret;

public class Rastgele {
    private int maksimumDeger;
    private int sonDeger;
    
//---Yapici metod ile maksimum deger saglandi.---//
    public Rastgele(int maksimum) {
        this.maksimumDeger = maksimum;
        sonDeger = (int) (System.currentTimeMillis() % maksimum);
    }

//---Sonucun 32749 degerinden fazla olmamasi saglandi.---//
    public int nextInt() {
        sonDeger = (sonDeger * 32719 + 3) % 32749;
        return sonDeger % maksimumDeger;
    }
}
