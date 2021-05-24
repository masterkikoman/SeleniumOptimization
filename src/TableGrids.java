import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableGrids {

	
	
	public static void main(String[] args) {
		//Getting total points of players in boxscore
		
		int sum = 0;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kalmazan\\AutomationDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://tv5.espn.com/nba/boxscore?gameId=401248438");
		//WebElement table = driver.findElement(By.xpath("//*[@class='col column-one gamepackage-away-wrap']/div/div/table"));
		int count =driver.findElements(By.xpath("//*[@class='col column-one gamepackage-away-wrap']/div/div/table/tbody/tr/td[@class='pts']")).size();
		//int count = table.findElements(By.xpath("//tbody/tr/td[@class='pts']")).size();
		
		for (int i=0; i<count-2;i++) {
			String points = driver.findElements(By.xpath("//tbody/tr/td[@class='pts']")).get(i).getText();
			int indPoints = Integer.parseInt(points);
			sum = sum+indPoints;		
	
		}
	
		if(sum==106) {
			System.out.println("Total points Match");
		}
		else {
			System.out.println("Total points not Match");
		}
		
		
	}

}
