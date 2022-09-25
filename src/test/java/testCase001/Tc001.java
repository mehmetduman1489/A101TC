package testCase001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Tc001 {/*
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

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.a101.com.tr");
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
        Actions actions = new Actions(driver);
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
        driver.findElement(By.xpath("//*[@name='title']")).sendKeys("Ev");
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Mehmet");
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Duman");
        driver.findElement(By.xpath("//*[@name='phone_number']")).sendKeys("05441768695");
        driver.findElement(By.xpath("//*[@name='city']")).sendKeys("BALIKESİR");
        WebElement ilce = driver.findElement(By.xpath("//*[@name='township']"));
        Select select = new Select(ilce);
        select.selectByIndex(14);
        WebElement mahalle = driver.findElement(By.xpath("//*[@name='district']"));
        Select select1 = new Select(mahalle);
        Thread.sleep(1000);
        select1.selectByIndex(4);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='line']")).sendKeys("403 sokak no 27 kat 1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='button green js-set-country js-prevent-emoji']")).click();
        //- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='button block green js-proceed-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='2. ÖDEME SEÇENEKLERİ']")).isDisplayed());


    }


}






