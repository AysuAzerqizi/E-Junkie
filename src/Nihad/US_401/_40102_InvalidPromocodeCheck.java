package Nihad.US_401;


import Nihad.Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _40102_InvalidPromocodeCheck  extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://shopdemo.fatfreeshop.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column all_tag']//a[text()='Ebook']")));
        WebElement eBook = driver.findElement(By.xpath("//div[@class='column all_tag']//a[text()='Ebook']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='column all_tag']//a[text()='Ebook']")));
        eBook.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class='EJ-ShopLink']")));
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='basicDetails']/button"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='basicDetails']/button")));
        addToCart.click();

        driver.switchTo().frame(6);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()='Add Promo Code']")));
        WebElement addPromoCodeButton = driver.findElement(By.xpath("//div/button[text()='Add Promo Code']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[text()='Add Promo Code']")));
        addPromoCodeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input")));
        WebElement addPromoCodeInput = driver.findElement(By.xpath("//div/input"));
        addPromoCodeInput.sendKeys("XXXX");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[@class='Promo-Apply']")));
        WebElement applyButton = driver.findElement(By.xpath("//div/button[@class='Promo-Apply']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[@class='Promo-Apply']")));
        applyButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[text()='Invalid promo code']")));
        WebElement invalidPromoCodeMssg = driver.findElement(By.xpath("//div/span[text()='Invalid promo code']"));

        Assert.assertTrue("Duzgun xeberdarliq mesaji gosterilmedi",invalidPromoCodeMssg.getText().equals("Invalid promo code"));
        gozleBagla();
    }
}
