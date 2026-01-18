package Aysu;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US_402 extends BaseDriver {
    @Test
    public void test402() {
        driver.get("https://shopdemo.fatfreeshop.com/");
        WebElement EBookaddtocart = driver.findElement(By.xpath("(//*[@class='view_product'])[2]"));
        EBookaddtocart.click();
        MyFunc.Wait(10);

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.EJIframeV3.EJOverlayV3")));

        WebElement payWithCard = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payWithCard.click();
        MyFunc.Wait(15);

        WebElement payButton = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        payButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement invalidMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'SnackBar')]")));

        String snackbarText = invalidMessage.getText();
        Assert.assertTrue(snackbarText.contains("Invalid Email"));
        Assert.assertTrue(snackbarText.contains("Invalid Billing Name"));
        GozleBagla();
    }
}



