import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
                (By.xpath("//*[@id=\"Title1_Menu1-menuItem002-subMenu-menuItem003\"]")))
                .click().build().perform();


        //Take a screenshot and save it in home folder.

        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("/home/psg/screenshot.png"));

        //*[@id="PDGcourpercView"]/tbody/tr[8]/td[7]



        //Hold down the keys "Control" and "T" to open a new tab and open stackoverflow.com

        String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL,"t");
        driver.findElement(By.tagName("body")).sendKeys(selectLinkOpenInNewTab);
        driver.get("stackoverflow.com");

    }
}
