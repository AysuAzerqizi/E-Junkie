package Nihad.US_401;

import Nihad.Utility.BaseDriver;
import Nihad.Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _40101_AddingeBookToCart extends BaseDriver {
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h5[text()='Demo eBook']")));
        WebElement eBookInShoppingCart = driver.findElement(By.xpath("//div/h5[text()='Demo eBook']"));
        Assert.assertTrue("eBook sebete elave edilmedi.",eBookInShoppingCart.getText().equals("Demo eBook"));
        gozleBagla();
    }
}
