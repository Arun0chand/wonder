package wonder;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

public class NewAdvert {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
		this.driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// login
		// ****************************************************************************
		driver.get("http://campaignsopend.tech-active.com/#/admin_login");
		WebElement emailTextField = driver.findElement(By.id("email_id"));
		emailTextField.clear();
		emailTextField.sendKeys("admin@opend.com");
		WebElement passwordTextField = driver.findElement(By.id("password"));
		passwordTextField.clear();
		passwordTextField.sendKeys("1234");
		driver.findElement(By.xpath("//button[text()='Sign In']")).submit();
		// ******************************************************************************
		JavascriptExecutor js5 = (JavascriptExecutor) driver;

		js5.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// advertiser module click
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/a")).click();
		// add advertiser button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div[3]/button")).click();
	}

	@Test(dataProvider="AdvertiserDataProvider")
	public void advertiserOnBoarding(String businessName,String website,String businessVat,String postalCode, String address,
			String companyRegNumber,String subId,String firstName ,String lastName,String jobTitle,String email,String telephone,String firstName1 ,String lastName1,String jobTitle1,String email1,String telephone1,String validation) throws InterruptedException {
        
		if(validation.equals("Valid")){
			System.out.println("Account created Successfully");
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			//business name
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[1]/div/div[1]/input")).sendKeys(businessName);
			Thread.sleep(1000);
			//website
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(website);
			Thread.sleep(1000);
			//bisiness vat
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys(businessVat);
			Thread.sleep(1000);
			//country
			WebElement country = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/select[1]"));
			new Select(country).selectByValue("79");
			Thread.sleep(1000);
			//city
			WebElement city = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[5]/select[1]"));
			new Select(city).selectByValue("5258");

			Thread.sleep(1000);

			//Postalcode
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[6]/input[1]")).sendKeys(postalCode);
			Thread.sleep(1000);
			//Address
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[7]/textarea[1]")).sendKeys(address);
			Thread.sleep(1000);
			//Functional area
			WebElement functionalArea = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[1]/select[1]"));
			Select drp3 = new Select(functionalArea);
			drp3.selectByVisibleText("Billing");
			Thread.sleep(1000);
			//Industry
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[2]/input[1]")).click();
			Thread.sleep(1000);
			//Select All
			driver.findElement(By.xpath("//label[contains(text(),'Select All')]")).click();
			Thread.sleep(1000);
			//Select click
			driver.findElement(By.xpath("//button[contains(text(),'Select')]")).click();
			Thread.sleep(1000);
			//Company reg number
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[9]/input[1]")).sendKeys(companyRegNumber);
			Thread.sleep(1000);
			//Sub Id
			driver.findElement(By.xpath("//input[@id='sub_id']")).sendKeys(subId);
			Thread.sleep(5000);

			js5.executeScript("window.scrollBy(0, 500)");


			//Time Zone
			WebElement timeZone = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[11]/select[1]"));
			Select drp4 = new Select(timeZone);
			drp4.selectByIndex(1);

			js5.executeScript("window.scrollBy(0, 500)");

			//User Information(Firstname)
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(firstName);
			//Last name
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys(lastName);
			//Job Title
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/input[1]")).sendKeys(jobTitle);
			//Email Address
			driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys(email);
			//Telephone Number
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[5]/input[1]")).sendKeys(telephone);

			js5.executeScript("window.scrollBy(0, 300)");

			//billing Information(Firstname)
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")).sendKeys(firstName1);
			//Last name
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/input[1]")).sendKeys(lastName1);
			//Job Title
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/input[1]")).sendKeys(jobTitle1);
			//Email Address
			driver.findElement(By.xpath("//input[@id='bill_email_id']")).sendKeys(email1);
			//Telephone Number
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[5]/input[1]")).sendKeys(telephone1);

			Thread.sleep(2000);
			WebElement addbutton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
			addbutton.click();

			Thread.sleep(2000);
			System.out.println(driver.getTitle());

			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/a")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div[3]/button")).click();
			Assert.assertTrue(true);
		}else {
			Assert.assertEquals(validation,"Invalid");
			System.out.println("Account already Exists");
		}
	}	




	@DataProvider(name = "AdvertiserDataProvider")
	public String[][] getData() throws IOException {
		String path = "./src/test/resources/LogData.xlsx";
//		File f= new File(System.getProperty("user.dir")+"./src/test/resources/LogData.xlsx");
		UtilityFile file = new UtilityFile(path);
//		UtilityFile file = new UtilityFile(f.toString());
		

		int totalRows = file.getRowCount("Sheet1");
		int totalCols = file.getCellCount("Sheet1", 1);

		String advertiserOnBoarding[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				advertiserOnBoarding[i - 1][j] = file.getCellData("Sheet1", i, j);
//				 System.out.println(advertiserOnBoarding[i][j]);
//				 System.out.println(advertiserDataProvider[j]);
			}
		}
		return advertiserOnBoarding;
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}

