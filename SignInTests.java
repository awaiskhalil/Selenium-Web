package signIn;
   
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SignInTests {
	
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\zst\\Downloads\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	//maximize the browser window
	driver.manage().window().maximize();
	
	//land on the nisnass website
	driver.get("https://www.nisnass.ae/");
	
	//Goto Sign In button
	driver.findElement(By.className("icon-account")).click();
	//driver.findElement(By.className("CustomerPopup-signInButton")).click();
			
	driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("awaiskhalil.pk@gmail.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("awais1");
	
	//click on submit button
	driver.findElement(By.className("SignInForm-signInButton")).submit();
	
	//implicit wait to make sure the success message appears
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			 Actions builder = new Actions(driver);
			 WebElement element = driver.findElement(By.linkText("ACCOUNT"));
			 builder.moveToElement(element).build().perform();
			element.click();		
	
			driver.findElement(By.cssSelector(".Account-link:nth-child(2) > .Account-linkLabel")).click();
	//update the phone number
	driver.findElement(By.name("phoneNumber")).clear();
	driver.findElement(By.name("phoneNumber")).sendKeys("67324238");
	// driver.findElement(By.name("phoneNumber")).sendKeys(Keys.chord(Keys.CONTROL,"")," ");
	driver.findElement(By.className("Profile-updateDetailsButton")).click();
	// using close will close current browser window
  driver.close();

	}
}