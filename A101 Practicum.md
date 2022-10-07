# A101TC
Bu Projede A101 ve Patika.dev işbirliği ile oluşturulan practicum için istenen Case üzerine, Java üzerinde Selenium JUnit kodlarıyla hazırladığım test projesidir. 



CASE:

Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi yapılacak.

Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak zorunlu. 
- Senaryoya üye kaydı oluşturmadan devam edilecek.
- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
- Açılan ürünün siyah olduğu doğrulanır.
- Sepete ekle butonuna tıklanır.
- Sepeti Görüntüle butonuna tıklanır.
- Sepeti Onayla butonuna tıklanır.
- Üye olmadan devam et butonuna tıklanır.
- Mail ekranı gelir.
- Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.

Kod Açıklaması:

öncelikle TestBase classı aracılığı ile test öncesi browser  test ve wait ayarlamalarını yaptım.Chrome driver ve Actions objesini burada oluşturdum.
Test kodları oluştururken locate almada öncelikle unique ise id sonra name sonra da xpath kullandım. Faker classı ile gereken veileri olusturdum.
Doğrulama yapmak için ise Assert classı kullandım.
 
