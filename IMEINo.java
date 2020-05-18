/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Imei no bilgilerini rasgele sinifini kullanarak ve
 * hesaplama algoritmasini dikkate alarak olusturan sinif.
 * Ayrica olusturulan sayilarin kurala uygun olup olmadigini
 * kontrol eden metodu da icermektedir.
 *
 */
package Pdp_RastgeleKisiUret;

import java.util.ArrayList;
import java.util.List;

public class IMEINo {

    public static ArrayList<Integer> imeiHaneler = new ArrayList<Integer>();
    public static int ciftHaneler = 0;
    public static int tekHaneler = 0;
    public static int sonHane = 0;

    public static ArrayList<String> rasgeleImeiListesi = new ArrayList<String>();

    public static void imeiNoHesapla(int toplamKisiSayisi) {

        //---Kullanilcinin istedigi kadar kisi icin imei numarasi olusturabilmesi icin
        //--metoda toplam kisi sayisi parametresi verildi.--//
        //---Rastgele sinifi kullanilarak rakamlar atandi.---//
       // Rastgele randomRakamlar = new Rastgele(10);

        int kisiSayaci = 0;

        while (kisiSayaci < toplamKisiSayisi) {

            imeiHaneler.clear();
            ciftHaneler = 0;
            tekHaneler = 0;
            sonHane = 0;

            //---Imei numarasinin ilk 14 hanesini iceren imeiHaneler listesine random degerler atandi.---//
            for (int i = 0; i < 14; i++) {
                imeiHaneler.add(KimlikNo.randomRakamlar.nextInt());
            }

            //---ImeiNo hanelerinin cift haneleri toplandi.---//
            //--Tek hanelerin2 kati alinarak bulunan deger 10'dan kucukse direk toplandi, 
            //--iki basamakli ise basamaklarina ayrilarak toplandi.--//
            for (int i = 0; i < 14; i++) {
                if (i % 2 == 0) {
                    ciftHaneler += imeiHaneler.get(i);
                } else {
                    if (imeiHaneler.get(i) * 2 < 10) {
                        tekHaneler += (imeiHaneler.get(i) * 2);
                    }
                    if (imeiHaneler.get(i) * 2 > 9) {
                        tekHaneler += ((imeiHaneler.get(i) * 2) % 10 + 1);
                    }
                }
            }

            //---Belirlenen cift haneler ve tek haneler degerleri toplanarak
            //--10'a gore modu alindi. 
            //--Bulunan son hane degeri imeiHanelerin 15. hanesi olarak eklendi.---//
            sonHane = (ciftHaneler + tekHaneler) % 10;
            imeiHaneler.add(sonHane);

            String temp = "";

            for (int i = 0; i < 15; i++) {      //---Olusturulan kimlik numarasi bos bir temp'e atandi.---//
                temp += imeiHaneler.get(i);                
            }
            rasgeleImeiListesi.add("");
            rasgeleImeiListesi.set(kisiSayaci, temp);   //---Temp'deki imei degeri rastgeleImeiListesi'ne atandi..---//
             
            kisiSayaci++;
        }
    }

    public static void imeiNoKontrol(List<Integer> imeiNoKontrol) {

        //---imeiNoKontrolu icin test dosyasinda olusturulan imei numaralarinin 
        //--atildigi liste parametreli metod olusturuldu.---//
        int kontrolSayisi = 15;
          int gecerliSayac = 0;
          int gecersizSayac = 0;

        for (int i = 0; i < (int) (imeiNoKontrol.size()) / 15; i++) {
            int ciftHanelerToplami1 = 0;
            int tekHanelerToplami1 = 0;

            //---Test dosyasinda olusturulan listedeki herbir 15 haneli grup bir imeiNo degeridir.
            //--Bu yuzden herbir 15 hanenin icindeki rakamlar incelendi.--//
            for (int j = (kontrolSayisi * i); j < (kontrolSayisi * i + kontrolSayisi); j++) {

                //---15 hanenin 1.,3.,5.,7.,9.,11.,13. haneler toplami ciftHanelerToplamina eklendi.---//
                if (j % 15 == 0 || j % 15 == 2 || j % 15 == 4 || j % 15 == 6 || j % 15 == 8 || j % 15 == 10 || j % 15 == 12) {
                    ciftHanelerToplami1 += (imeiNoKontrol.get(j));
                }

                //---15 hanenin 2.,4.,6.,8.,10.,12.,14. hanelerin 2 kati alindi.
                //--Bulunan degerler 10'dan kucukse direk toplandi, iki basamakli ise 
                //--basamaklarina ayrilarak toplandi ve tekHanelerToplamina eklendi.---//
                if (j % 15 == 1 || j % 15 == 3 || j % 15 == 5 || j % 15 == 7 || j % 15 == 9 || j % 15 == 11 || j % 15 == 13) {
                    if ((imeiNoKontrol.get(j) * 2) < 10) {
                        tekHanelerToplami1 += (imeiNoKontrol.get(j) * 2);
                    }
                    if ((imeiNoKontrol.get(j) * 2) >= 10) {
                        tekHanelerToplami1 += (imeiNoKontrol.get(j) * 2) % 10 + 1;
                    }
                }
            }

            //---Eger her bir gruptaki imei'nin son hanesine kurala uygun olarak atanmissa
            //--gecerliSayac arttirildi.Uygun olarak atanmamissa gecersizSayac arttirildi.
            if ((ciftHanelerToplami1 + tekHanelerToplami1) % 10 == imeiNoKontrol.get(i * 15 + 14)) {
                gecerliSayac++;
                
            } else {
                gecersizSayac++;
    
            }
        }

        //---Burada her imei numarasi yukaridaki kurala uygun olarak olusturuldugu icin
        //---gecersiz imei numarasi her durumda 0 olarak cikacaktir.
        //---Ancak istenilirse yanlis olarak belirlenen bir text dosyainda durum kontrol edilebilir.---//
        System.out.println("IMEI No Kontrol");
        System.out.println("Gecerliler: " + gecerliSayac);
        System.out.println("Gecersizler: " + gecersizSayac);

    }

}
