package Aysu;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US_408 extends BaseDriver {
    @Test
    public void us408()
    {
        driver.get("https://shopdemo.fatfreeshop.com/");
        WebElement ecommerce = driver.findElement(By.xpath("//*[@class='EJ-ShopLink']"));
        ecommerce.click();

        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.e-junkie.com/";
        Assert.assertEquals(expectedURL,actualURL);

        WebElement bluebtn = driver.findElement(By.xpath("(//*[@class='blue_btn'])[1]"));
        bluebtn.click();


        Actions actions = new Actions(driver);
        WebElement videoElement = driver.findElement(By.xpath("video"));

        actions.moveToElement(videoElement).click().perform();
        System.out.println("Video başladıldı.");
        MyFunc.Wait(10);

        actions.click(videoElement).perform();
        System.out.println("Video dayandırıldı.");


        GozleBagla();



    }
}
