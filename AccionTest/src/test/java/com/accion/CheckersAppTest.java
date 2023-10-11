package com.accion;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckersAppTest {
    public static void main(String args[]) {
        WebDriver driver;
        String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.out.println(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.get("https://www.gamesforthebrain.com/game/checkers/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Checkers"));


        WebElement linkRestart = driver.findElement(By.xpath("//*[@class='footnote']//a[contains(text(), 'Restart')]"));
        linkRestart.click();

        WebElement msgOnrestart = driver.findElement(By.xpath("//*[@id='message']"));

        Assert.assertTrue(msgOnrestart.getText().equalsIgnoreCase("Select an orange piece to move."));

    }
}