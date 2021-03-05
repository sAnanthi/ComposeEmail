import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


public class ComposeEmail {	
	
	private static RemoteWebDriver driver;
	
	
	public static void main(String[] args) throws Exception {
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://gmail.com/intl/en/mail/help/about.html");
		
		driver.manage().window().maximize();
		
		String loginName="shan.ananthi2002@gmail.com";
		String pwd="password";
		String sendMailID="hema@gmail.com";
		String sub="Sending email using selenium script";
		
		String emailBody="Welcome to Gmail";
		
		
		/* Enter username and password */
		
		driver.findElement(By.linkText("Sign in")).click();
		
		
		
		driver.findElement(By.xpath("//div[text()='Email or phone']")).clear();
		driver.findElement(By.xpath("//div[text()='Email or phone']")).sendKeys(loginName);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		
		//**Clicking Composing button
		
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
		driver.findElement(By.xpath("//span[text()='To']/following::textarea")).clear();
		driver.findElement(By.xpath("//span[text()='To']/following::textarea")).sendKeys(sendMailID);
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).clear();
		
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(sub);
		
		WebElement printbody = driver.switchTo().activeElement();
		printbody.sendKeys(emailBody);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
		
		//*****Verify in Sent box
		
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
		if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='"+sub+"']")) != null)
		{
		System.out.println("Wowww.. Email sent sucessfully!!!");
		}
		else
		{
		System.out.println("Failed to send email !!!");
		}
		
		driver.quit();
		
		
	
		

	}
	
	
	
}
	
			
	
	


