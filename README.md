# ProgramlamaDillerininPrensipleri-Java2

Sakarya Üniversitesi 2019 - 2020 eğitim öğretim yılı Programlama Dillerinin Prensipleri dersi projesinin kaynak kodlarını içermektedir.

Java programlama dilini kullanarak (NetBeans ortamında) rastgele kişi üretebilerek kütüphane tasarlanmıştır. Bu kütüphane çalıştırılabilir bir program değildir. Kişi sınıfı özellikleri;
- T.C. Kimlik (Nesne referansı)
- İsim, soyisim
- Yaş
- Telefon (Nesne referansı)
Kişi rastgele üretileceği zaman isimler “random_isimler.txt” dosyasından çekilmiştir. Yaş 0-100 arası rastgele atanmıştır. T.C. kimlik numarası yine rastgele oluşturulmuş fakat hesaplama kuralına sadık kalınmıştır. T.C. Kimlik numarasının bir hesaplama algoritması vardır. Her üretilen kişiye rastgele atanan T.C. kimlik numarası bu hesaplamaya uymaktadır. Kişinin telefonu rastgele üretilen bir numara olup Türkiye’deki numaralara uyumludur. Her telefon’a ait bir IMEI numarası olup ve bu numara da rastgele oluşturulmuştur. 15 haneli bir numara olan IMEI ilk 14 hanesi ile belli hesaplamalar yapılarak 15. Hanesi bulunmuştur. Rastgelelikte bu kurala uyulmalıdır.

Bu ödevde rastgele üretilecek herhangi bir şey, hazır rastgele metotlar yerine kendi yazdığım metotlar tarafından üretilmiştir. (Random gibi hazır metot veya sınıflar kullanılmamıştır.)
