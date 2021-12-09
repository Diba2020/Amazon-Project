package AmazonSearch.AmazonProject;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest {
	
   public String baseUrl = "https://www.amazon.com/";
   String driverPath = "C:\\Users\\shafi\\Documents\\geckodriver.exe";
   public WebDriver driver;
     
   @BeforeTest
    public void launchBrowser()  
   {
	   System.out.println("launching browser");
    	System.setProperty("webdriver.gecko.driver", driverPath);
    	 driver = new FirefoxDriver();
    	driver.get(baseUrl);
    }
    	
   @Test
    	public void verifyHomepageTitle() throws InterruptedException 
   {
        driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    	searchBox.sendKeys("iPhone 13 Pro Max case");
    	searchBox.submit();
    	driver.findElement(By.linkText("Cell Phone Cases & Covers")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
    	driver.findElement(By.linkText("Children's Books")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.linkText("Activities, Crafts & Games")).click();
    	driver.findElement(By.linkText("Crafts & Hobbies")).click();
    	driver.findElement(By.linkText("I Am Confident, Brave & Beautiful: A Coloring Book for Girls")).click();
    	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).sendKeys("Add to Cart");
    	
    	}
    	
   @AfterTest
    	public void terminateBrowser() {
    	driver.close();
    		
    		}
    	

    }

