import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUIOptimization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cebupacificair.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("DepartureCont")).click();
		
		
		//Selecting dynamic date in calendar
		By date = By.xpath("//*[@class='ui-datepicker-title']/span[1]");
		

		while(!driver.findElement(date).getText().contains("January")) {
			
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			
		}
		
		//Selecting dynamic  date values values in a calendar
		By dateValue = By.xpath("//*[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']");
		int count = driver.findElements(dateValue).size();
				
				for(int i =0; i < count; i++) {
			//go to each and every item in the list
				String text = driver.findElements(dateValue).get(i).getText();
				
				if(text.equals("15")) {
					driver.findElements(dateValue).get(i).click();
					break;
				}
			
		}
		

	}

}
