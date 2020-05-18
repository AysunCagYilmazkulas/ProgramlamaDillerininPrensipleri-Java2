/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 * Rastgele belirlenmis isim, yas, kimlik no, telefon ve imei no
 * bilgilerini belirleyerek kisiler.txt dosyasina yazdiran ve
 * kimlik no ile imei no bilgilerinin gecerliligini yazdiran program.
 *
 */
package odev2_test;

import Pdp_RastgeleKisiUret.IMEINo;
import static Pdp_RastgeleKisiUret.IMEINo.rasgeleImeiListesi;
import Pdp_RastgeleKisiUret.KimlikNo;
import Pdp_RastgeleKisiUret.Kisi;
import Pdp_RastgeleKisiUret.RastgeleKisi;
import Pdp_RastgeleKisiUret.Telefon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Odev2_Test {

    public Kisi[] kisiler;
    public static int kisiSayisi;
    public static List<Integer> kimlikNoSayilarInt = new ArrayList<Integer>();
    public static List<Integer> imeiNoSayilarInt = new ArrayList<Integer>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner giris = new Scanner(System.in);    
        int secim = 0;

        while (secim != 3) {        //---Kullanici cikisi secmedigi surece secenek ekraninin gelmesi while ile saglandi.---//

            System.out.println("Lütfen seçim yapınız.");
            System.out.println("1- Rastgele Kişi Üret");
            System.out.println("2- Üretilmiş Dosya Kontrol Et");
            System.out.println("3- Çıkış");
            secim = giris.nextInt();        //---Kullanicinin secim yapmasi saglandi.---//

            switch (secim) {
                case 1:         //---Kullanicinin 1'i sectigi durumlar...---//

                    System.out.println("Kac kisi olusturmak istersiniz?");

                    Scanner s = new Scanner(System.in);
                    kisiSayisi = s.nextInt();       //---Kullanicidan kisi sayisi alindi.---//

                    Kisi[] kisiler = new Kisi[kisiSayisi];      //---Kisi sinifindan kisi sayisi kadar nesne olustuldu.---//

                    RastgeleKisi.DosyaOku("RandomIsimler", kisiSayisi);     //---RastgeleKisi sinifindan kisi sayisi kadar kisi getirildi.---//
                    FileWriter writer = new FileWriter("kisiler.txt");      

                    KimlikNo.kimlikNoHesapla(kisiSayisi);
                    IMEINo.imeiNoHesapla(kisiSayisi);
                    Telefon.telefonNoHesapla(kisiSayisi);

                    //---Dongu ile kullanicinin girdigi sayi kadar Kisi sinifindan olusturulan diziye
                    //--kisiler aktarildi. Bu diziler KimlikNo ve Telefon sinifindan nesne referansi ile verileri sagladilar.---//
                    //---Veriler istenilen sekilde kisiler.txt dosyasina yazdirildi.---//
                    for (int i = 0; i < kisiSayisi; i++) {
                        kisiler[i] = new Kisi(RastgeleKisi.rastgeleKisiler.get(i), RastgeleKisi.rastgeleYasListesi.get(i));
                        kisiler[i].TcKimlik = KimlikNo.rastgeleKimlikNoListesi.get(i);
                        kisiler[i].telNo = Telefon.rasgeleTelListesi.get(i);                      
                        writer.write(kisiler[i].TcKimlik + " " + kisiler[i].isimSoyIsim + " " + kisiler[i].yas + " " + kisiler[i].telNo + " (" + rasgeleImeiListesi.get(i) + ")" + System.lineSeparator());                       
                    }

                    writer.close();     //---kisiler.txt dosyasi kapatildi.---//

                    break;

                case 2:      //---Kullanicinin 2'yi sectigi durumlar...---//

                    kimlikNoSayilarInt.clear();     //---Secimin birden fazla yapilmasi durumu icin atanan veriler ilk olarak temizlendi.---//
                    imeiNoSayilarInt.clear();

                    List kimlikNo = new ArrayList();        //---Kimlik no ve imei no listeleri acildi.---//
                    List imeiNo = new ArrayList();

                    FileReader kisilerText = new FileReader("kisiler.txt");     //---1.secimde yazdirilan kisiler.txt dosyasi okundu.---//
                    BufferedReader okuyucu = new BufferedReader(kisilerText);

                    String satir;

                    while ((satir = okuyucu.readLine()) != null) {      //---Dosyada her satirdaki veriler boslukla ayrildi.---//
                        String[] ayrilmisVeriler = satir.split(" ");    //---ayrilmisVeriler dizisine aktarildi.---//
                        kimlikNo.add(ayrilmisVeriler[0]);       //---Ilk sutun kimlikNo dizisine aktarildi.---//
                        imeiNo.add(ayrilmisVeriler[5]);     //---Son sutun imeikNo dizisine aktarildi.---//
                    }

                    okuyucu.close();        //---Dosya okuma sonlandirildi.---//

                    String k = "";      
                    for (Object degerler : kimlikNo) {      //---KimlikNodaki degerler belirlendi.---//
                        k += degerler;
                    }
                    char[] kimlikNoSayilar = k.toCharArray();   //---Herbir deger char olarak kimlikNoSayilar dizisine aktarildi.---//

                    for (int i = 0; i < kimlikNoSayilar.length; i++) {
                        kimlikNoSayilarInt.add(Integer.parseInt(String.valueOf(kimlikNoSayilar[i])));   //---Char degerler integer olarak yeni bir diziye aktarildi.---//
                    }

                    String p = "";
                    for (Object degerler : imeiNo) {        //---imeiNodaki degerler belirlendi.---//
                        p += degerler;
                    }
                    char[] imeiNoSayilar = p.toCharArray();     //---Herbir deger char olarak imeiNoSayilar dizisine aktarildi.---//

                    for (int i = 0; i < imeiNoSayilar.length; i++) {
                        if (i % 17 != 0 && i % 17 != 16) {
                            imeiNoSayilarInt.add(Integer.parseInt(String.valueOf(imeiNoSayilar[i])));   //---Char degerler integer olarak yeni bir diziye aktarildi.---//
                        }
                    }

                    //---Dosyadan okunarak rakam rakam integer tipinde listelere aktarilan imeiNo ve kimlikNo verilerinin
                    //--kontrolu IMEINo ve KimlikNo siniflarindaki Kontrol metodlari ile saglandi.---//
                    IMEINo.imeiNoKontrol(imeiNoSayilarInt);     
                    KimlikNo.kimlikNoKontrol(kimlikNoSayilarInt);

                    break;

                case 3:         //---Kullanicinin 3'u sectigi durumlar...---//
                    System.exit(0);     //---Sistemden ciki saglandi.---//
                    break;

                default:        //---Diger durumlar...---//
                    System.out.println("Hatali secim! 1, 2 ya da 3'e basiniz.");
                    break;
            }
        }
    }
}
