package Farid;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Us_403 extends BaseDriver {

    @Test
    public void Junkie() {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        Actions actions = new Actions(driver);
        MyFunc.Wait(2);

        WebElement addTangible = driver.findElement(By.xpath("//button[contains(@onclick, '1597355')]"));
        actions.moveToElement(addTangible).click().build().perform();
        MyFunc.Wait(3);

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.EJIframeV3.EJOverlayV3")));

        driver.findElement(By.xpath("//option[@value='AZ']")).click();
        MyFunc.Wait(2);

        WebElement zip = driver.findElement(By.xpath("//input[@class='Shipping-Section-Postcode']"));
        zip.clear();
        zip.sendKeys("1111");
        MyFunc.Wait(2);

        driver.findElement(By.xpath("//*[contains(text(),'Shipping / Tax')]")).click();
        MyFunc.Wait(2);

        driver.findElement(By.xpath("//button[@data-option='CC']")).click();
        MyFunc.Wait(3);

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("farid.misirov444@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).sendKeys("farid.misirov444@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Name On Card']")).sendKeys("Farid");
        MyFunc.Wait(2);

        driver.findElement(By.xpath("//p[contains(@class,'Shipping-Address1')]//input")).sendKeys("Baku");
        driver.findElement(By.xpath("//p[contains(@class,'Shipping-City')]//input")).sendKeys("Baku");
        MyFunc.Wait(2);

        WebElement cardIframe = driver.findElement(By.xpath("//iframe[contains(@name,'__privateStripeFrame')]"));
        driver.switchTo().frame(cardIframe);

        driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("1111 1111 1111 1111");
        driver.findElement(By.name("exp-date")).sendKeys("1226");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("000");
        MyFunc.Wait(1);

        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'hCaptcha')]")));
        driver.findElement(By.id("anchor")).click();

        MyFunc.Wait(20);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.EJIframeV3.EJOverlayV3")));

        driver.findElement(By.cssSelector("button.Pay-Button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'error') or contains(text(),'card number')]")));

        Assert.assertTrue(errorMsg.isDisplayed());

        GozleBagla();
    }
}