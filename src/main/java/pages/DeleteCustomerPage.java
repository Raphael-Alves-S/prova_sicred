package pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.ConfigUrl;

public class DeleteCustomerPage extends ConfigUrl{
	private String xpathLink = "//*[@id=\"report-success\"]/p/a[2]";
	private String xpathSearch = "*//div[2]/div[2]/div[1]/div[2]/form/div[1]/div[2]/a[3]";
	private String nameButtonSearch = "search";
	private String xpathCheckbox = "*//div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input";
	private String classButtonDelete = "text-danger";
	private String xpathTextModal = "*//div[2]/div[2]/div[3]/div/div/div[2]/p[2]";
	private String msg = "Are you sure that you want to delete this 1 item?";
	private String xpathDeleteModal = "*//div[2]/div[2]/div[3]/div/div/div[3]/button[2]";
	private String xpathDeleteAlert = "/html/body/div[3]/span[3]/p";
	private String xpathTextAlert = "/html/body/div[3]/span[3]/p";
	private String msgAlert = "Your data has been successfully deleted from the database.";
	
	public DeleteCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	public void backHomepage() {
		driver.findElement(By.xpath(xpathLink)).click();
		
	}
	
	
	public void searchName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(xpathSearch)).click();
		Thread.sleep(2000);		
		WebElement inputsearch = driver.findElement(By.name(nameButtonSearch));
		inputsearch.sendKeys("Teste Sicredi");
		inputsearch.sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
	}
	
	public void buttonDelete() {
		driver.findElement(By.xpath(xpathCheckbox)).click();		
		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className(classButtonDelete)));
		
		driver.findElement(By.className(classButtonDelete)).click();
	}

	public void modalAlert() {
		String sucess = driver.findElement(By.xpath(xpathTextModal)).getText();
		assertEquals(msg, sucess);		
	}
	
	public void deleteCustomer() {
		driver.findElement(By.xpath(xpathDeleteModal)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDeleteAlert)));
		String sucess = driver.findElement(By.xpath(xpathTextAlert)).getText();
		assertEquals(msgAlert, sucess);		
		
	}
	
	public void quitDriver() {
		driver.quit();
	}
}
