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

public class TestScriptPage extends BaseTest {

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
    public void viewWishlistTable(){
        driver.findElement(By.xpath("//a[@title='Wishlist']")).click();
        Assert.assertTrue("not in wishlist page ",driver.getTitle().contains("Wishlist"));
        takeScreenShot();
    }

    public int getNumberOfItemsFromWishList(){
        return driver.findElements(By.xpath("//tbody/tr")).size();
    }

    static String lowPriceProduct = "";
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

    public void iVerifyProductAddedToCart(){
        threadSleep(2);
        waitForElement(driver.findElement(By.xpath("//a[@title='Cart']")));
        driver.findElement(By.xpath("//a[@title='Cart']")).click();
        String productInCart = "//td[@class='product-name']/a[contains(.,'"+lowPriceProduct+"')]";
        List<WebElement> productList = driver.findElements(By.xpath(productInCart));
        Assert.assertTrue("Product Not in the Cart", productList.size()>0);
        takeScreenShot();
    }



}



