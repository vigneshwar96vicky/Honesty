package orh.omega;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilpKartAutoMation {
	public static WebDriver driver;

	public void launch() {
		String path = "E://Eclipse Workspace/Honesty/Omega/target/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
	}
	public void URL(String s){
		this.launch();
		driver.navigate().to(s);
		driver.manage().window().maximize();
		
	}
	
}
