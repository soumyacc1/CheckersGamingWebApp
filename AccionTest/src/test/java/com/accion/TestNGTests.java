package com.accion;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTests {
    static WebDriver driver;

// To initialize drivers and browsers
    @BeforeTest
    public void setup() {


        String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://www.gamesforthebrain.com/game/checkers/");
    }

    @Test(enabled = true, groups = {"sanity"})
    public void checkSiteisUp() {
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Checkers"));
    }

    @Test(enabled = true, groups = {"functional"})
    public void verifyRestart() {

        WebElement linkRestart = driver.findElement(By.xpath("//*[@class='footnote']//a[contains(text(), 'Restart')]"));
        linkRestart.click();
        WebElement msgOnrestart = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(msgOnrestart.getText().equalsIgnoreCase("Select an orange piece to move."));
    }

    @Test(enabled = true, groups = {"regression"})
    public void fiveMovesOrange() throws InterruptedException {
        makeMoves();

        WebElement msgOnrestart = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(msgOnrestart.getText().contains("Make a move."));
    }


    @AfterTest
    public void teardown() {
//        driver.quit();
    }


    // Function to make moves
    static void makeMoves() throws InterruptedException {

       /* driver.findElement(By.cssSelector("div:nth-child(6) > img:nth-child(4)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > img:nth-child(5)")).click();
        driver.findElement(By.cssSelector("div:nth-child(6) > img:nth-child(8)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > img:nth-child(7)")).click();
        driver.findElement(By.cssSelector("div:nth-child(6) > img:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > img:nth-child(3)")).click();
        driver.findElements(By.cssSelector("div:nth-child(7) > img")).get(0).click();
        driver.findElement(By.cssSelector("div:nth-child(6) > img:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > img:nth-child(3)")).click();*/

        driver.findElement(By.xpath("//img[@name='space42']")).click();
        driver.findElement(By.xpath("//img[@name='space33']")).click();
        Thread.sleep(10000);

       /* WebElement msgOnrestart = driver.findElement(By.xpath("//*[@id='message' and text()='Make a move.']"));
        WebDriverWait wait=new WebDriverWait(driver,20000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message' and text()='Make a move.']")));*/
        driver.findElement(By.xpath("//img[@name='space02']")).click();
        driver.findElement(By.xpath("//img[@name='space13']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@name='space62']")).click();
        driver.findElement(By.xpath("//img[@name='space53']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@name='space71']")).click();
        driver.findElement(By.xpath("//img[@name='space53']")).click();
        Thread.sleep(5000);


    }
}
