package TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class VerifyingSuccessfulLoginPage {
	@Test
	public void verifyingSuccessfulLoginPage() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		//STEP1: SEARCH THE GIVEN URL AND CONFIRM THAT THE CORRECT URL IS OPENED
		driver.get("https://app.germanyiscalling.com/common/login/");
		Assert.assertEquals(driver.getTitle(), "Login | Germany Is Calling");

		//STEP2: ENTER THE INCORRECT USERNAME AND PASSWORD
		driver.findElement(By.id("username")).sendKeys("yashnandhyala@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Yaships@1");

		//STEP3: CLICK ON SUBMIT BUTTON
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//STEP4: VERIFY WHETHER THE LOGIN IS SUCCESSFUL
		/*Here verifying the 'Upload the CV' text for successful login*/
		assertTrue(driver.findElement(By.id("card_text")).getText().contains("Upload your CV"),"Verifying the upload the CV text" );
		driver.close();
	}

}
