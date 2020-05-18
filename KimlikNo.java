/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Kimlik no bilgilerini rasgele sinifini kullanarak ve
 * hesaplama algoritmasini dikkate alarak olusturan sinif.
 * Ayrica olusturulan sayilarin kurala uygun olup olmadigini
 * kontrol eden metodu da icermektedir.
 *
 */
package Pdp_RastgeleKisiUret;

import java.util.ArrayList;
import java.util.List;

public class KimlikNo {

    public static Rastgele randomRakamlar = new Rastgele(10);
    public static ArrayList<Integer> tcHane = new ArrayList<Integer>();
    public static int tekHanelerToplami = 0;
    public static int ciftHanelerToplami = 0;
    public static int onuncuHane;
    public static int sonHane;

    public static ArrayList<String> rastgeleKimlikNoListesi = new ArrayList<String>();

    public static void kimlikNoHesapla(int toplamKisiSayisi) {
        //---Kullanilcinin istedigi kadar kisi icin kimlik numarasi olusturabilmesi icin
        //--metoda toplam kisi sayisi parametresi verildi.--//

        //---Rastgele sinifi kullanilarak rakamlar atandi.---//
        int kisiSayaci = 0;

        while (kisiSayaci < toplamKisiSayisi) {

            tcHane.clear();
            ciftHanelerToplami = 0;
            tekHanelerToplami = 0;
            onuncuHane = 0;
            sonHane = 0;

            //---Kimlik numarasinin ilk 9 hanesini iceren tcHane listesine random degerler atandi.---//
            for (int i = 0; i < 9; i++) {
                tcHane.add(randomRakamlar.nextInt());
            }
            //---Ilk hane 0 oldugunda 1 artirilarak 0 olmasi engellendi.---//

            if (tcHane.get(0) == 0) {
                int ilkHane = tcHane.get(0) + 1;
                tcHane.set(0, ilkHane);
            }

            for (int i = 0; i < 9; i++) {

                
                if (i % 2 == 0) {
                    ciftHanelerToplami += tcHane.get(i);    //---Tc'nin 1.,3.,5.,7.,9. hanesi toplanarak ciftHanelerToplamina aktarildi.---//
                } else {
                    tekHanelerToplami += tcHane.get(i);     //---Tc'nin 2.,4.,6.,8. hanesi toplanarak tekHanelerToplamina aktarildi.---//
                }
            }

            ciftHanelerToplami = ciftHanelerToplami * 7;    //---Cift haneler toplaminin 7 kati alindi.---//
            onuncuHane = Math.abs(ciftHanelerToplami - tekHanelerToplami);     //---Bu toplamlar birbirinden cikarildi ve mutlak degerleri alindi.---//
            onuncuHane = (onuncuHane % 10);       //---Belirlenen sayinin 10'a bolumunden kalan bulundu.---//
            tcHane.add(onuncuHane);         //---Bulunan rakam 10.hane olarak tcHane'ye eklendi.---//


            for (int i = 0; i < 10; i++) {      //---Belirlenen sayilar toplanarak sonHaneye aktarildi.---//
                sonHane += tcHane.get(i);
            }

            sonHane = (sonHane % 10);       //---Son hanenin 10'a bolumunden kalan sayi bulundu.---//
            tcHane.add(sonHane);        //---Bulunan rakam 11.hane olarak tcHane'ye eklendi.---//

            String temp = "";

            for (int i = 0; i < 11; i++) {  //---Olusturulan kimlik numarasi bos bir temp'e atandi.---//
                temp += tcHane.get(i);
            }
            rastgeleKimlikNoListesi.add("");
            rastgeleKimlikNoListesi.set(kisiSayaci, temp);   //---Temp'deki tc degeri rastgeleKimlikNoListesi'ne atandi..---//          
            kisiSayaci++;
            
        }
    }

    public static void kimlikNoKontrol(List<Integer> KimlikNoKontrol) {

        //---KimlikNoKontrolu icin test dosyasinda olusturulan kimlik numaralarinin 
        //--atildigi liste parametreli metod olusturuldu.---//
        
        int gecerliSayac = 0;       //---Gecerli ve gecersiz numaralar icin sayac olusturldu.---//
        int gecersizSayac = 0;

        for (int i = 0; i < (int) (KimlikNoKontrol.size() / 11); i++) {
            int ciftHanelerToplami1 = 0;
            int tekHanelerToplami1 = 0;
            int sonHane1 = 0;
            int onuncuHane1 = 0;

            //---Test dosyasinda olusturulan listedeki herbir 11 haneli grup bir TC degeridir.
            //--Bu yuzden herbir 11 hanenin icindeki rakamlar incelendi.--//
            for (int j = (11 * i); j < (11 * i + 11); j++) {

                //---11 hanenin 1.,3.,5.,7.,9.haneler toplami ciftHanelerToplamina eklendi.---//
                if (j % 11 == 0 || j % 11 == 2 || j % 11 == 4 || j % 11 == 6 || j % 11 == 8) {
                    ciftHanelerToplami1 += (KimlikNoKontrol.get(j));
                }

                //---11 hanenin 2.,4.,6.,8. haneler toplami tekHanelerToplamina eklendi.---//
                if (j % 11 == 1 || j % 11 == 3 || j % 11 == 5 || j % 11 == 7) {
                    tekHanelerToplami1 += (KimlikNoKontrol.get(j));
                }
            }
            
            //---Cifthanelertoplaminin 7 katindan tekhanelertoplami cikarilarak mutlak degerleri alindi.---//
            //--Bulunan sayinin 10'a bolumunden kalan sayi belirlendi.---//

            ciftHanelerToplami1 = ciftHanelerToplami1 * 7;

            onuncuHane1 = Math.abs(ciftHanelerToplami1 - tekHanelerToplami1);
            onuncuHane1 = (onuncuHane1 % 10);
            
            //---Belirlenen 11'li gruplarin son hanesi haric diger sayilari toplanarak 10'a bolumunden kalan sayi bulundu.---//           
            for (int j = (11 * i); j < (11 * i + 11); j++) {
                if (j != ((11 * i) + 10)) {
                    sonHane1 += KimlikNoKontrol.get(j);
                }
            }

            sonHane1 = (sonHane1 % 10);

            //---Eger her bir gruptaki TC'nin 10. ve son hanesine kurala uygun olarak atanmissa
            //--gecerliSayac arttirildi.Uygun olarak atanmamissa gecersizSayac arttirildi.
            if (((onuncuHane1) == KimlikNoKontrol.get((11 * i) + 9)) && (sonHane1 == KimlikNoKontrol.get((11 * i) + 10))) {
                gecerliSayac++;
            } else {
                gecersizSayac++;
            }
        }

        //---Burada her kimlik numarasi yukaridaki kurala uygun olarak olusturuldugu icin
        //---gecersiz kimlik numarasi her durumda 0 olarak cikacaktir.
        //---Ancak istenilirse yanlis olarak belirlenen bir text dosyainda durum kontrol edilebilir.---//
        System.out.println("T.C. Kimlik Kontrol");
        System.out.println(gecerliSayac + "   Geçerlı");
        System.out.println(gecersizSayac + "   Geçersiz");

    }
}
