package automationTest.pages;

import automationTest.common.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishListPage extends BaseTest {
    public static String lowPriceProduct = "";

    public void viewWishlistTable(){
        driver.findElement(By.xpath("//a[@title='Wishlist']")).click();
        Assert.assertTrue("not in wishlist page ",driver.getTitle().contains("Wishlist"));
        takeScreenShot();
    }
    public int getNumberOfItemsFromWishList(){
        return driver.findElements(By.xpath("//tbody/tr")).size();
    }


    public void iSearchLowestPriceProduct(){
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        List<WebElement> priceOfItems = driver.findElements(By.xpath("//td[@class='product-price']//bdi"));
        ArrayList<Double> amounts = new ArrayList<>();
        for (WebElement ele: priceOfItems  ) {
            amounts.add(Double.valueOf(ele.getText().replaceAll("£","")));
        }
        Collections.sort(amounts);

        lowPriceProduct = driver.findElement(By.xpath("//tbody//bdi[text()='"+decimalFormat.format(amounts.get(0))+"']/ancestor::td/preceding-sibling::td[@class='product-name']")).getText();
        takeScreenShot();
    }
    public void iAddLowestPriceProductToCart(){
        String addLowestPriceProduct = "//td[@class='product-name']/a[contains(.,'"+lowPriceProduct+"')]/../following-sibling::td[3]/a";
        driver.findElement(By.xpath(addLowestPriceProduct)).click();
        Assert.assertTrue("Unable to add product to cart",driver.getPageSource().contains("Product added to cart successfully"));
        takeScreenShot();
    }
}
