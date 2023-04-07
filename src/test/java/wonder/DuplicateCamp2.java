package wonder;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateCamp2{
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(cp);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

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
		//Click on the campaign
		JavascriptExecutor js5 = (JavascriptExecutor) driver;

		js5.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/aside[1]/ul[1]/li[2]/a[1]")).click();
		// Click on the start new campaign button
		Thread.sleep(6000);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/a[1]")));
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/a[1]")).click();
	}
	//	Start------------------------------------------------------------------------------------------------------------------
	@Test(dataProvider="CampaignCreationDataProvider")
	public void campaignCreation(String campaignName,String subjectLine,String monthyear,String date,String opensaudience,String othersaudience,String label) throws InterruptedException {
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		
         try {
		//click on the Advertiser drop down
		WebElement advertiserDrop=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[1]/div[1]/select[1]"));
		new Select(advertiserDrop).selectByValue("65");
		Thread.sleep(2000);
		//Enter the campaign name
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(campaignName);
		// Enter the Advertiser cost type free
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/label[1]")).click();
		// Enter the Advertiser cost type Normal
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[2]/label[1]")).click();
		// Enter the Campaign country
		Thread.sleep(2000);

		WebElement campaignCountry=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[5]/select[1]"));
		new Select(campaignCountry).selectByValue("79");
		// Enter the advertiser type
		Thread.sleep(2000);

		WebElement advertiserType=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[6]/select[1]"));
		new Select(advertiserType).selectByValue("1");
		//Enter  the Camapaign category
		Thread.sleep(2000);

		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[7]/input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Automotive')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/div[2]/div[1]/button[1]")).click();
		//Enter the Audience interest
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[8]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/div[2]/div[1]/label[1]")).click();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[2]/div[1]/button[1]")).click();

		//Enter the Select Publisher
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[12]/input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Latch 4')]")).click();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[8]/div[1]/div[2]/div[1]/button[1]")).click();

		//Enter the publisher cost
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[13]/div[1]/span[1]/label[1]")).click();

		//Enter the proceed button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[3]/button[1]")).click();

		//Enter the subject line
		driver.findElement(By.xpath("//input[@id='subjectone']")).sendKeys(subjectLine);
		Thread.sleep(20000);
		//Enter the FROM button
		driver.findElement(By.xpath("//input[@id='uploadBtn1']")).click();
		//Enter the Select button
		Thread.sleep(20000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/button[1]")).click();
		js5.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);


		WebElement Element = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[2]/div[1]/div[16]/button[1]"));

		//This will scroll the page Horizontally till the element is found		
		js5.executeScript("arguments[0].scrollIntoView();", Element);
		//Enter the proceed button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[2]/div[1]/div[16]/button[1]")).click();
		Thread.sleep(5000);
		//Enter the proceed button
		js5.executeScript("window.scrollBy(0, 200)");
		Thread.sleep(5000);
		//Click on the location
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]")).click();
		//select location
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[2]/div[1]/label[1]")).click();
		//Click on the submit button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		//		click on the RegionTextfield
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]")).click();
		//	    Click on the regions select all
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[2]/div[1]/label[1]")).click();
		//		Click on the Submit button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[2]/div[1]/button[1]")).click();
		//Click on the Town Text Field
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[1]/div[1]/div[5]/div[1]/input[1]")).click();
		//Click on the Town Select ALL Button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[2]/div[1]/label[1]")).click();
        //Click on the radio button of the advance option 
		driver.findElement(By.xpath("//label[contains(text(),'Enable')]")).click();
        //Click on the Please select the Email dropdown
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[1]/div[1]/div[9]/div[1]/select[1]")).click();
        //Select the drop down of the email status Opened
		WebElement opened=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[1]/div[1]/div[1]/div[2]/div[5]/select[1]"));
		new Select(opened).selectByIndex(2);
        //Click on the calender button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[1]/div[1]/div[9]/div[2]/button[1]")).click();
        //Select the month and year
		driver.findElement(By.xpath(monthyear)).click();
        //Select the date
		driver.findElement(By.xpath(date)).click();
        //Click on the opened audience reach
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[1]/span[1]/input[1]")).clear();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[1]/span[1]/input[1]")).sendKeys(opensaudience);
        //	Click on the others audience reach
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[2]/span[1]/input[1]")).clear();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[2]/span[1]/input[1]")).sendKeys(othersaudience);
		
		//Click on the Submit button
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(20000);

		
		
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[4]/button[1]")));
//		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[3]/div[1]/div[4]/button[1]")).click();
//		//Enter the select Audience reach
//		Thread.sleep(30000);
//		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[1]/span[1]/input[1]")).clear();
//		Thread.sleep(30000);
//		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/md-tabs[1]/md-tabs-content-wrapper[1]/md-tab-content[4]/div[1]/div[1]/div[1]/span[1]/input[1]")).sendKeys(selectAudienceReach);
		//Select the Email Deliverability
		Thread.sleep(20000);
		driver.findElement(By.xpath(label)).click();

		js5.executeScript("window.scrollBy(0, 500)");
		//Create the campaign Immediate
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Start Campaign Immediately')]")).click();
		Thread.sleep(2000);
		//Campaign Start button
		driver.findElement(By.xpath("//button[contains(text(),'Start Campaign')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/a[1]")).click();
	}
         catch(NoSuchElementException e) {
        	 System.out.println("Element Not Found Exception" + e.getMessage());
         }
         catch (ElementNotInteractableException e) {
             // Handle the ElementNotInteractableException
             System.out.println("Element not interactable: " + e.getMessage());
         }
	}

	//		End------------------------------------------------------------------------------------------


	@DataProvider(name = "CampaignCreationDataProvider")
	public String[][] getData() throws IOException {
		String path = "./src/test/resources/Book123.xlsx";
		UtilityFile file = new UtilityFile(path);

		int totalRows = file.getRowCount("Sheet1");
		int totalCols = file.getCellCount("Sheet1", 1);

		String campaignCreationData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				campaignCreationData[i - 1][j] = file.getCellData("Sheet1", i, j);
				// System.out.println(advertiserDataProvider[i]);
				// System.out.println(advertiserDataProvider[j]);
			}
		}
		return campaignCreationData;
	}

	@AfterClass
	void tearDown() {
		
		driver.close();
	}

}
