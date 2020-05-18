/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ  aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 26.04.2020
 *
 *Kisi sinifina kimlik,isim-soyisim, yas ve telefon numarasi
 *ozellikleri verildi. Odevde istenilen sekilde kimlik ve telefon
 * degerleri nesne referansi ile saglandi. Diger degerlerde nesne referansi istenmedigi
 * icin yapici metod ile degerler atandi.
 *
 */
package Pdp_RastgeleKisiUret;

public class Kisi {

//---Odevde istendigi sekilde ozellikler atandi.Bu ozellikler nesne referansi 
//--ile calistirlabilir programda cagrilarak kullanildi.---//
    public String TcKimlik;
    public String isimSoyIsim;
    public int yas;
    public String telNo;

    public Kisi(String Isim, int Yas) {

//---Nesne referansi istenmeyen ozellikler icin yapici metod kullanildi.---//
        isimSoyIsim = Isim;
        yas = Yas;
    }
}
