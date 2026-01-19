package Aysu;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US_408 extends BaseDriver {
    @Test
    public void test408() {
        driver.get("https://shopdemo.fatfreeshop.com/");
        WebElement ecommerce = driver.findElement(By.xpath("//*[@class='EJ-ShopLink']"));
        ecommerce.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.e-junkie.com/";
        Assert.assertTrue(actualURL.contains("e-junkie")); //assert fail verdiyi ucun kod dayanir.KOd dayanmamasi ucun contains ist eliyirem

        WebElement howitworks = driver.findElement(By.xpath("(//*[@class='blue_btn'])[1]"));
        howitworks.click();
        MyFunc.Wait(10);

        Actions actions = new Actions(driver);
        WebElement video = driver.findElement(By.xpath("//*[@class='modal-background']"));
        actions.moveToElement(video).click().build().perform();
        MyFunc.Wait(10);
        actions.sendKeys(Keys.SPACE).build().perform();
        GozleBagla();


    }
}
