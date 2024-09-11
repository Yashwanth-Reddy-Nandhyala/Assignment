package TestScripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class VerifyingUnsuccessfulLoginAttempt {
	
	@Test
	public void verifyingUnsuccessfulLoginAttempt() {

		WebDriver driver = new ChromeDriver();
		
		//STEP1: SEARCH THE GIVEN URL AND CONFIRM THAT THE CORRECT URL IS OPENED
		driver.get("https://app.germanyiscalling.com/common/login/");
		Assert.assertEquals(driver.getTitle(), "Login | Germany Is Calling");
		
		//STEP2: ENTER THE INCORRECT USERNAME AND PASSWORD
		driver.findElement(By.id("username")).sendKeys("yashnandhyala@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Yaships");
		
		//STEP3: CLICK ON SUBMIT BUTTON
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//STEP4: VERIFY THE ERROR MESSAGE
		String error = driver.findElement(By.xpath("//ul/li")).getText();
		assertEquals(error,"Please enter a correct username and password. Note that both fields may be case-sensitive." );
		driver.close();
		
	}

}
