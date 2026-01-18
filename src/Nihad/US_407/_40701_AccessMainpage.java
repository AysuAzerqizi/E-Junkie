package Nihad.US_407;

import Nihad.Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _40701_AccessMainpage  extends BaseDriver {
    @Test
    public void Test(){

        driver.get("https://shopdemo.fatfreeshop.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class='EJ-ShopLink']")));
        WebElement linkToMainPage = driver.findElement(By.xpath("//div/a[@class='EJ-ShopLink']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[@class='EJ-ShopLink']")));
        linkToMainPage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='container']/div/div/a)[1]")));
        WebElement eJunkie = driver.findElement(By.xpath("(//div[@class='container']/div/div/a)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='container']/div/div/a)[1]")));
        eJunkie.click();

        Assert.assertTrue("Current URL is not right",driver.getCurrentUrl().toString().equals("https://www.e-junkie.com/"));
        gozleBagla();
    }
}