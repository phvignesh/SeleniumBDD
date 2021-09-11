package automationTest.pages;

import automationTest.common.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomePage extends BaseTest {

    public void openurl(String url) {
        driver.get(url);
    }

    public void addProductsToWishlist(int numberOfProducts) throws InterruptedException {
       String addToWishlist="//li[contains(@class,'product-type-simple')]//a[@data-title='Add to wishlist']";
       driver.findElement(By.xpath("//a[contains(.,'Categories')]")).click();
       driver.findElement(By.xpath("//a[contains(.,'Clothing')]")).click();
        takeScreenShot();

       List<WebElement> listOfAddToWishlistElements= driver.findElements(By.xpath(addToWishlist));
        for (int i=0; i<numberOfProducts; i++) {
            listOfAddToWishlistElements.get(i).click();
            Thread.sleep(1000);
            takeScreenShot();
        }
    }










}



