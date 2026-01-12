package Nihad.US_401;

import Nihad.Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _40101_AddingeBookToCart extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://shopdemo.fatfreeshop.com/");

        WebElement eBook = driver.findElement(By.xpath("//div[@class='column all_tag']//a[text()='Ebook']"));
        eBook.click();


        gozleBagla();
    }
}
