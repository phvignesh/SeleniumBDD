package automationTest.pages;

import automationTest.common.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartPage extends BaseTest {


    public void iVerifyProductAddedToCart(){
        threadSleep(2);
        waitForElement(driver.findElement(By.xpath("//a[@title='Cart']")));
        driver.findElement(By.xpath("//a[@title='Cart']")).click();
        String productInCart = "//td[@class='product-name']/a[contains(.,'"+WishListPage.lowPriceProduct+"')]";
        List<WebElement> productList = driver.findElements(By.xpath(productInCart));
        Assert.assertTrue("Product Not in the Cart", productList.size()>0);
        takeScreenShot();
    }
}
