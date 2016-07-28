import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

/**
 * Created by psg on 29/7/16.
 */
public class Sample {
    public static void main(String[] args) throws IOException {
//        System.setProperty("webdriver.chrome.driver","/home/psg/selenium-2.53.1/chromedriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://ecampus.psgtech.ac.in/");
        driver.findElement(By.className("current")).click();
        driver.findElement(By.name("Txtstudid")).sendKeys("14i339");
        driver.findElement(By.name("TxtPasswd")).sendKeys("26jul96");
        driver.findElement(By.name("btnlogin")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"Title1_Menu1-menuItem002\"]"));
        action.moveToElement(element).moveToElement(driver.findElement
                (By.xpath("//*[@id=\"Title1_Menu1-menuItem002-subMenu-menuItem003\"]"))).click().build().perform();

        // When using Whatsapp Web Hack use the following to get the id.
        // driver.find_elements_by_xpath("//*[contains(text(), 'My Button')]")
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("/home/psg/screenshot.png"));


    }
}
