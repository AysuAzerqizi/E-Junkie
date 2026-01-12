package Nihad.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    static //tearStart()
    {
        driver = new ChromeDriver();

        js=(JavascriptExecutor) driver;

        //driver.manage().window().maximize(); // ekrani max et
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        // 20 saniye sehifenin yuklenmesi ucun gozle - bu demek deyil her defe 20 saniye gozleyecek
        // sadece sehifenin yuklenmesi ucun max muddetdir, sehife yuklenen kimi bu kecerlilik bitecek

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // sehifedeki elemetni tapmaq ucun max 20 saniye gozleme muddeti
        // Bu o demek deyil ki! - elementi 20 saniyeye tapacaq. Sadece gozleme muddetidir tapilan qeder

    }

    public static void gozleBagla() //tearDown()
    {
        MyFunc.Wait(3);
        driver.quit();
    }
}
