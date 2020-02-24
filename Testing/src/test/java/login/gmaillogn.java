package login;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class gmaillogn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extentreportgmail.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		ExtentTest test1 = extent.createTest("login ","login user");

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shraddha\\Downloads\\geckodriver.exe");
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
			driver.get("http://automationpractice.com/index.php");
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test1.log(Status.INFO, "starting test case");
			WebElement frame;
			frame=driver.findElement(By.linkText("Sign in"));
			frame.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
		     WebElement web1;
					web1=driver.findElement(By.id("email"));
					web1.clear();
					web1.sendKeys("testuser001@dispostable.com");
					web1.click();
					Thread.sleep(10000);
					
					WebElement web2;
					web2=driver.findElement(By.id("passwd"));
					web2.sendKeys("testuser001");
					 Thread.sleep(10000);
					 WebElement web4;
					 
					 WebElement web3;
					 web3=driver.findElement(By.id("SubmitLogin"));
					 web3.click();
					 Thread.sleep(10000);
					 
					 String str1;
					 str1="My account";
					 String web8;
					 web8=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a/span")).getText();
					 
					 
					 if(str1.equalsIgnoreCase(str1))
					 {
						 test1.pass(" Logged in successfully") ;
					 }
					 else
					 {
					 test1.fail("Login Failed");
					 }
					  WebElement web9;
					  web9=driver.findElement(By.linkText("Sign out"));
					  web9.click();
					
					  String w1;
					  w1=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1")).getText();
					  
					  String w2;
					  w2="Authentication";
					  if(w1.equalsIgnoreCase(w2))
						 {
							 test1.pass(" Logged out successfully") ;
						 }
						 else
						 {
						 test1.fail("Log out Failed");
						 }
					  
					
				 
					
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(driver != null)
				driver.close();
			test1.pass("closed the browser");
			
			test1.info("Test completed");
			extent.flush();
		}

	}

}
