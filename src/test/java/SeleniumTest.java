import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest
{


    @Test
    void Setup()
    {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver","C:/Users/moreetus/IdeaProjects/TestNGProject/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("sa");

        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("sa");

        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        String act = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]")).getText();
        System.out.println("Test -- "+act);

        Assert.assertEquals(act,"Formal Shoes");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();



    }

}
