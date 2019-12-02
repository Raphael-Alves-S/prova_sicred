package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigUrl {
		protected  WebDriver driver;		

		public ConfigUrl(WebDriver driver) {
			this.driver = driver;
		}
		
		public ConfigUrl() {	    
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		}		

		public WebDriver getDriver() {
			return driver;
		}

}
