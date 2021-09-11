package automationTest.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseTest {
   public static WebDriver driver = null;

    public void setup(){
//        String chromedriverPath = System.getProperty("user.dir")+ "\\Drivers\\chromedriver";
//        System.out.println("current dir = " + chromedriverPath);
//        System.setProperty("webdriver.chrome.driver",chromedriverPath +".exe");
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void threadSleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String strDate = "";
    public String getCurrentDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYY_HHmmss");
        strDate = sdf.format(cal.getTime());
        return strDate;
    }

    public void takeScreenShot(){
        String userDir = System.getProperty("user.dir");
        String screenShotDir = userDir+"/target/ScreenShots/";
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(screenShotDir+"/"+getCurrentDate()+".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tearDown(){
       driver.close();
       driver.quit();
    }
}
