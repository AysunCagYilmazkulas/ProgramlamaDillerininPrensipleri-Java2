/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Belirlenen text dosyasindan isimleri rasgele alan ve
 * 1 ile 100 arasindaki sayilari da rasgele alan,
 * bunlari belirlenen listelere atayan sinif.
 *
 */
package Pdp_RastgeleKisiUret;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RastgeleKisi {

    public static List<String> rastgeleKisiler = new ArrayList<>();
    public static ArrayList<Integer> rastgeleYasListesi = new ArrayList<>();
    public static Rastgele randomKisiler;
    public static Rastgele randomYas;
    public static List<String> kisiler = new ArrayList<>();
    public static ArrayList<Integer> yasListesi = new ArrayList<>();

    //---Dosya oku metodu ile istenilen dosya okunacak ve toplamKisiSayisi parametresi ile-- 
    //--kullanicinin girdigi kisi sayisi kadar isim soyisim alinacaktir.--//
    public static void DosyaOku(String URL, int toplamKisiSayisi) throws FileNotFoundException {

        //---Random isimler dosyasi acildi.---//
        FileReader dosya = new FileReader("RandomIsimler.txt");

        try {
            //---Istenilen Text dosyasinin okunmasi saglandi.---//
            BufferedReader reader = new BufferedReader(dosya);

            //---Random isimler dosyasindaki herbir satir kisiler listesine aktarildi.---//
            String satir = null;
            while ((satir = reader.readLine()) != null) {
                kisiler.add(satir);
            }
            reader.close();

            //---Ranstgele sinifi kullanilarak 100e kadar olan yas degerleri yasListesine aktarildi.---//
            Rastgele randomSayilar = new Rastgele(100);
            for (int i = 1; i < toplamKisiSayisi; i++) {
                yasListesi.add(randomSayilar.nextInt());
            }

            //---Ranstgele sinifi kullanilarak kisiler ve yaslar rastgele olarak listelere aktarildi.---//
            randomKisiler = new Rastgele(kisiler.size());
            randomYas = new Rastgele(yasListesi.size());

            //---Listelerden kullanicinin girdigi kisi sayisi degeri kadar deger rastgele listelere aktarildi.---//
            for (int i = 0; i < toplamKisiSayisi; i++) {
                rastgeleKisiler.add(kisiler.get(randomKisiler.nextInt()));
                rastgeleYasListesi.add(yasListesi.get(randomYas.nextInt()));
            }

        } catch (final IOException e) {
        }
    }
}
