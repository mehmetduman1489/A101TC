package testCase001;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClassAfterClass;

public class Tc001 extends TestBaseBeforeClassAfterClass {/*
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

*/

    @Test
    public void test1() throws InterruptedException {
        //- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
        driver.get("https://www.a101.com.tr");
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();

        WebElement subMenu = driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]"));
        actions.moveToElement(subMenu).perform();
        driver.findElement(By.xpath("//*[text()='Dizaltı Çorap']")).click();
        //- Açılan ürünün siyah olduğu doğrulanır.
        driver.findElement(By.xpath("//*[@alt='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='SİYAH']")).getText().equalsIgnoreCase("siyah"));
        //- Sepete ekle butonuna tıklanır.
        driver.findElement(By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        //- Sepeti Görüntüle butonuna tıklanır.
        driver.findElement(By.xpath("//*[@class='go-to-shop']")).click();
        //- Sepeti Onayla butonuna tıklanır.
        driver.findElement(By.xpath("(//*[@title='Sepeti Onayla'])[2]")).click();
        //- Üye olmadan devam et butonuna tıklanır.
        driver.findElement(By.xpath("//*[@title='ÜYE OLMADAN DEVAM ET']")).click();
        //- Mail ekranı gelir.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='user_email']")).isEnabled());
        driver.findElement(By.xpath("(//*[@type='text'])[11]")).sendKeys("mehmetduman14@gmail.com", Keys.ENTER);
        //- Sonrasında adres ekranı gelir.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='new-address js-new-address']")).isDisplayed());
        driver.findElement(By.xpath("//*[@class='new-address js-new-address']")).click();
        //Adres oluştur dedikten sonra ödeme ekranı gelir.
        Faker faker = new Faker();
        WebElement adresIsim = driver.findElement(By.xpath("//*[@name='title']"));
        adresIsim.click();
        actions.sendKeys("Ev")
                .sendKeys(Keys.TAB).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.numerify("05441768695")).perform();
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("BALIKESİR");
        WebElement ilce = driver.findElement(By.xpath("//*[@name='township']"));
        Select select = new Select(ilce);
        select.selectByIndex(14);
        Thread.sleep(2000);
        WebElement mahalle = driver.findElement(By.xpath("//*[@class='js-district']"));
        Select select1 = new Select(mahalle);
        select1.selectByIndex(4);
        Thread.sleep(2000);


        WebElement fulladres = driver.findElement(By.xpath("//*[@name='line']"));

        fulladres.click();
        actions.sendKeys(faker.address().fullAddress()).perform();

        driver.findElement(By.xpath("//*[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")).click();
        //- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='button block green js-proceed-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='2. ÖDEME SEÇENEKLERİ']")).isDisplayed());


    }


}






