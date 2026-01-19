package Asef;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class US_404 extends BaseDriver {

    @Test
    public void Test_US_404(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        Actions actions = new Actions(driver);
        MyFunc.Wait(2);

        WebElement Demoebook = driver.findElement(By.xpath("//button[contains(@onclick, '1595015')]"));
        actions.moveToElement(Demoebook).click().build().perform();
        MyFunc.Wait(3);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        MyFunc.Wait(3);
        WebElement DebitCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        DebitCard.click();
        MyFunc.Wait(3);
        WebElement email= driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("mecad90461@elafans.com");
        MyFunc.Wait(3);
        WebElement confirmEmail= driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("mecad90461@elafans.com");
        MyFunc.Wait(3);

        WebElement NameonCard= driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        NameonCard.sendKeys("Name on Card");
        MyFunc.Wait(3);
        WebElement Phone= driver.findElement(By.xpath("(//input[@autocomplete='phone'])[1]"));
        Phone.sendKeys("12345678");
        MyFunc.Wait(2);
        WebElement Company= driver.findElement(By.xpath("(//input[@autocomplete='company'])[1]"));
        Company.sendKeys("Company");


        MyFunc.Wait(4);

        driver.switchTo().frame(driver.findElement(By.xpath(
                "(//iframe[contains(@name,'__privateStripeFrame')])[1]")));

        WebElement Cardnumber= driver.findElement(By.xpath("//input[@name='cardnumber']"));
        Cardnumber.sendKeys("4242 4242 4242 4242");
        MyFunc.Wait(3);
        WebElement ExprDate= driver.findElement(By.xpath(
                "//input[@name='exp-date']"));
        ExprDate.sendKeys("1226");
        MyFunc.Wait(3);
        WebElement CVC= driver.findElement(By.xpath(
                "//input[@name='cvc']"));
        CVC.sendKeys("000");
        MyFunc.Wait(3);

        driver.switchTo().parentFrame();
        MyFunc.Wait(3);

        driver.switchTo().frame(driver.findElement(By.xpath(
                "//iframe[@title='Widget containing checkbox for hCaptcha security challenge']")));

        WebElement checkbox= driver.findElement(By.xpath("//div[@id='checkbox']"));
        checkbox.click();
        MyFunc.Wait(10);

        driver.switchTo().parentFrame();
        MyFunc.Wait(3);

        WebElement paybtn= driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        paybtn.click();
        MyFunc.Wait(5);
        driver.switchTo().defaultContent();


        WebElement Dwnlod= driver.findElement(By.xpath("//span[@class='download_btn top10']"));
        Dwnlod.click();

        WebElement msg= driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        Assert.assertEquals("Eyni deyil","Name on, your order is confirmed. Thank you!",msg.getText());

        GozleBagla();



    }
}
