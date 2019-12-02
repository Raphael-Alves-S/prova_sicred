package pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.ConfigUrl;

public class DeleteCustomerPage extends ConfigUrl{
	private String xpathLink = "//*[@id=\"report-success\"]/p/a[2]";
	private String classTable = "table table-bordered grocery-crud-table table-hover";
	private String classSearch = "el el-search";
	private String classButtonSearch = "search-input search-input-big";
	private String xpathCheckbox = "*//div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input";
	private String classButtonDelete = "btn btn-outline-dark delete-selected-button";
	private String classModal = "modal-header";
	private String xpathTextModal = "*//div[2]/div[2]/div[3]/div/div/div[2]/p[2]";
	private String msg = "Are you sure that you want to delete this 1 item?";
	private String classDeleteModal = "btn btn-danger delete-multiple-confirmation-button";
	private String sucessDeleteAlert = "alert alert-success growl-animated animated bounceInDown";
	private String xpathTextAlert = "*//div[3]/span[3]";
	private String msgAlert = "Your data has been successfully deleted from the database.";
	
	public DeleteCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	public void backHomepage() {
		driver.findElement(By.xpath(xpathLink)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classTable)));
	}
	
	
	public void searchName() {
		driver.findElement(By.className(classSearch)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classButtonSearch)));
		
		WebElement inputsearch = driver.findElement(By.className(classButtonSearch));
		inputsearch.sendKeys("La Rochelle Gifts");
		inputsearch.sendKeys(Keys.ENTER);	
	}
	
	public void buttonDelete() {
		driver.findElement(By.xpath(xpathCheckbox)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classButtonDelete)));
		
		driver.findElement(By.className(classButtonDelete)).click();
	}

	public void modalAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classModal)));
		
		String sucess = driver.findElement(By.xpath(xpathTextModal)).getText();
		assertEquals(msg, sucess);		
	}
	
	public void deleteCustomer() {
		driver.findElement(By.className(classDeleteModal)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(sucessDeleteAlert)));
		
		String sucess = driver.findElement(By.xpath(xpathTextAlert)).getText();
		assertEquals(msgAlert, sucess);		
		
	}
	
}
