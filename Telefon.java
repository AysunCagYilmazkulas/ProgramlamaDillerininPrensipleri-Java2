/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Turkiye'deki numaralara uyumlu telefon numaralarini
 * rastgele olusturup bunlari bir diziye atayan sinif.
 *
 *
 */
package Pdp_RastgeleKisiUret;

import java.util.ArrayList;

public class Telefon {

    public static ArrayList<String> rasgeleTelListesi = new ArrayList<>();
    public static ArrayList<Integer> telNoHaneler = new ArrayList<>();
    public static ArrayList<Integer> ucuncuHane = new ArrayList<>();
    public static ArrayList<Integer> dorduncuHane0 = new ArrayList<>();
    public static ArrayList<Integer> dorduncuHane5 = new ArrayList<>();

    public static void telefonNoHesapla(int toplamKisiSayisi) {
        //---Kullanilcinin istedigi kadar kisi icin telefon numarasi olusturabilmesi icin
        //--metoda toplam kisi sayisi parametresi verildi.--//

        //---Rastgele sinifi kullanilarak rakamlar atandi.---//
        Rastgele randomRakamlar = new Rastgele(10);
        Rastgele ucuncuHane = new Rastgele(7);
        Rastgele dorduncuHane0 = new Rastgele(8);
        Rastgele dorduncuHane5 = new Rastgele(10);

        int kisiSayaci = 0;

        while (kisiSayaci < toplamKisiSayisi) {

            telNoHaneler.clear();
            int temp1 = 0;
            int temp2 = 0;
            int temp3 = 0;

            //---Telefon numarasinin 11 hanesini iceren telNoHaneler listesine random degerler atandi.---//
            for (int i = 0; i < 11; i++) {
                telNoHaneler.add(randomRakamlar.nextInt());
            }

            //---Ulkemizdeki telefon numaralari kurali dikkate alinarak asagidaki islemler yapildi.---//
            //---telNoHaneler listesinin ilk hanesine 0, ikinci hanesine 5 degeri atandi.---//
            telNoHaneler.set(0, 0);
            telNoHaneler.set(1, 5);

            //---telNoHaneler listesinin 3.hanesinin 0,3,4,5,6 olabilmesi rastgele sinifi ile saglandi.---//
            temp1 = ucuncuHane.nextInt();
            while (temp1 == 1 || temp1 == 2) {
                temp1 = ucuncuHane.nextInt();
            }
            telNoHaneler.set(2, temp1);      //---telefon numarasinin 3.hanesinin 1 ve 2 olmasi kisitlandi.---//

            temp2 = dorduncuHane0.nextInt();

            while (temp2 == 0 || temp2 == 2 || temp2 == 3 || temp2 == 4) {
                temp2 = dorduncuHane0.nextInt();
            }

            temp3 = dorduncuHane5.nextInt();

            while (temp3 == 0 || temp3 == 6 || temp3 == 7 || temp3 == 8) {
                temp3 = dorduncuHane5.nextInt();
            }

            if (temp1 == 0) {     //---3.hane 0 oldugunda 4.hanenin 
                telNoHaneler.set(3, temp2);     //---1,5,6,7 degerlerini alabilmesi saglandi.---//
            }
            if (temp1 == 5) {     //---3.hane 5 oldugunda 4.hanenin 
                telNoHaneler.set(3, temp3);     //---1,2,3,4,5,9 degerlerini alabilmesi saglandi.---//
            }
            if (temp1 == 6) {
                telNoHaneler.set(3, 1);
            }

            String temp = "";

            for (int i = 0; i < 11; i++) {      //---Olusturulan telefon numarasi bos bir temp'e atandi.---//
                temp += telNoHaneler.get(i);
            }
            rasgeleTelListesi.add("");
            rasgeleTelListesi.set(kisiSayaci, temp);    //---Temp'deki telefon numarasi telListesine atandi..---//
            temp = "";

            kisiSayaci++;
        }
    }
}
