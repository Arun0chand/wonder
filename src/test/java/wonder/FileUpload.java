package wonder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.dockerjava.api.model.Event;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FileUpload {
WebDriver driver;
@BeforeTest
public void settup()
{
WebDriverManager.chromedriver().setup();
ChromeOptions cp=new ChromeOptions();
cp.addArguments("--remote-allow-origins=*");
driver = new ChromeDriver(cp);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.google.com/maps/d/edit?hl=en&mid=1GnLo8qeQUS85iVk1Y64LrVOH46ZAyso&ll=15.854161601052223%2C82.75998700000002&z=4");
driver.manage().window().maximize();
}

@Test
public void kml_creation() throws AWTException, InterruptedException
{
driver.findElement(By.xpath("//input[@type='email']")).sendKeys("nagaraj@active.agency");
driver.findElement(By.xpath("//span[.='Next']")).click();
driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Nagu@123");
Thread.sleep(2000);
Robot rt=new Robot();
rt.keyPress(KeyEvent.VK_ENTER);
rt.keyRelease(KeyEvent.VK_ENTER);
    driver.findElement(By.xpath("(//div[.='Import'])[1]")).click();
    int size = driver.findElements(By.tagName("iframe")).size();
System.out.println("Number of iframes on the page are " + size);
// driver.findElement(By.xpath("//body/div[@id='docs-editor']/div[@id='map-area-container']/div[@id='map-renderer-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/iframe[1]")).click();
    driver.switchTo().frame("//body/div[@id='docs-editor']/div[@id='map-area-container']/div[@id='map-renderer-container']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/iframe[1]");
   rt.keyPress(KeyEvent.VK_ENTER);
   rt.keyRelease(KeyEvent.VK_ENTER);
   Thread.sleep(2000);
  
   StringSelection stringSelection = new StringSelection("C:\\Users\\Active.30\\Downloads\\Tiny_Supp.csv(10m).csv");
   Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
   clipboard.setContents(stringSelection, null);
   Robot robot = null;
   try {
       robot = new Robot();
   } catch (AWTException e) {
       e.printStackTrace();
   }
   robot.delay(250);
  
   robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_V);
   robot.keyRelease(KeyEvent.VK_V);
   robot.keyRelease(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_ENTER);
   robot.delay(150);
   robot.keyRelease(KeyEvent.VK_ENTER);
}

}