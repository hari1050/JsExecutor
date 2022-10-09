package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.Base;

public class JSExecutor2 extends Base {
	JavascriptExecutor js;
	WebElement StudName;
	//To Open the URL
    public void OpenUrl(){
		
		driver.get("http://www.stqatools.com/demo/Alerts.php");
	}
    
    //To handle alert in the browser
	public void alert() throws InterruptedException{
		js = (JavascriptExecutor)driver;
		
		//To show alert
		js.executeScript("alert('Hello World');");
		Thread.sleep(1000);
		
		//To accept alert
		driver.switchTo().alert().accept();
	}
	
	//To navigate to the next URL
	public void navigateTo(){
		driver.navigate().to("https://www.stqatools.com/demo/");
	}
	
	//To fill up the form
	public void DataEntry(){
		StudName=driver.findElement(By.id("studentname"));
		js.executeScript("arguments[0].value='Amol'", StudName);
		
		WebElement FatherName=driver.findElement(By.id("fathername"));
		js.executeScript("arguments[0].value='Raj'", FatherName);
		
		WebElement paddress=driver.findElement(By.id("paddress"));
		js.executeScript("arguments[0].value='Pune'", paddress);
		
		WebElement PersonalAdd=driver.findElement(By.id("personaladdress"));
		js.executeScript("arguments[0].value='Pune'", PersonalAdd);
		
		WebElement gender=driver.findElement(By.name("sex"));
		js.executeScript("arguments[0].click();", gender);
		
		driver.findElement(By.xpath("//select[@name='City']/child::option[3]")).click();
		
		driver.findElement(By.xpath("//select[@name='Course']/child::option[2]")).click();
		
		driver.findElement(By.xpath("//select[@name='District']/child::option[2]")).click();
		
		driver.findElement(By.xpath("//select[@name='State']/child::option[3]")).click();
		
		WebElement pin=driver.findElement(By.id("pincode"));
		js.executeScript("arguments[0].value='411009'", pin);
		
		WebElement email=driver.findElement(By.id("emailid"));
		js.executeScript("arguments[0].value='abc@gmail.com'", email);
		
		//To scroll down
		js.executeScript("window.scrollBy(0,120)");

	}
	
	// To Submit the form
	public void reset() throws InterruptedException{
		
		WebElement reset=driver.findElement(By.xpath("//td/input[@type='reset']"));
		js.executeScript("arguments[0].click();", reset);
		
		js.executeScript("window.scrollBy(0,90)");
		Thread.sleep(2000);
	}
	
	//To verify Submission of the form
	public void ResetChecking(){
		
		 if(StudName.getAttribute("value").isEmpty()){
			 System.out.println("Reset Successfully and Verified");
		 }
		 else{
			 System.out.println("Failed");
		 }
	}
	
	//To execute all methods
	public static void main(String[] args) throws InterruptedException{
		JSExecutor2 jseu= new JSExecutor2();
		jseu.driverSetup();
		jseu.OpenUrl();
		jseu.alert();
		jseu.navigateTo();
		jseu.DataEntry();
		jseu.reset();
		jseu.ResetChecking();
		jseu.closeBrowser();
	}

}
