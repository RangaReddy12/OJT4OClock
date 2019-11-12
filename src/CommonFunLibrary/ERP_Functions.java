package CommonFunLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ERP_Functions {
WebDriver driver;
/*ProjectName:ERP_Stock
 * ModuleName:Launching url
 * TesterName:Ranga
 */
public String launchUrl(String url)throws Throwable
{
String res="";
System.setProperty("webdriver.chrome.driver", "./CommonJars/chromedriver.exe");
driver=new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
Thread.sleep(5000);
if(driver.findElement(By.id("btnsubmit")).isDisplayed())
{
res="Launch Application Success";
}
else{
res="Launch Application Fail";
}
return res;
}
/*ProjectName:ERP_Stock
 * ModuleName:Login
 * TesterName:Ranga
 */
public String verifyLogin(String username,String password)throws Throwable
{
	String res="";
	WebElement user=driver.findElement(By.name("username"));
	user.clear();
	Thread.sleep(2000);
	user.sendKeys(username);
	Thread.sleep(2000);
	WebElement pass=driver.findElement(By.name("password"));
	pass.clear();
	Thread.sleep(2000);
	pass.sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.name("btnsubmit")).click();
	Thread.sleep(4000);
	if(driver.findElement(By.id("mi_logout")).isDisplayed())
	{
		res="Login SUccess";
	}
	else
	{
		res="Login Fail";
	}
	return res;
	
   }
/*ProjectName:ERP_Stock
 * ModuleName:Logout
 * TesterName:Ranga
 */
public String verifyLogout()throws Throwable
{
String res="";
driver.findElement(By.xpath("//li[@id='mi_logout']//a[contains(text(),'Logout')]")).click();
Thread.sleep(4000);
if(driver.findElement(By.name("btnsubmit")).isDisplayed())
{
	res="Application Logout Success";
}
else{
	res="Application Logout Fail";
}
return res;
}
/*ProjectName:ERP_Stock
 * ModuleName:Supplier Creation
 * TesterName:Ranga
 */
public String verifySupplier(String sname,String address,String city,
String country,String cperson,String pnumber,String email,
String mnumber,String note)throws Throwable
{
	String res="";
driver.findElement(By.linkText("Suppliers")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")).click();
Thread.sleep(3000);
//get supplier number and store
String Exp_data=driver.findElement(By.name("x_Supplier_Number")).getAttribute("value");
driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
driver.findElement(By.id("x_Address")).sendKeys(address);
driver.findElement(By.id("x_City")).sendKeys(city);
driver.findElement(By.id("x_Country")).sendKeys(country);
driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
driver.findElement(By.id("x__Email")).sendKeys(email);
driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
driver.findElement(By.id("x_Notes")).sendKeys(note);
driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
Thread.sleep(4000);
driver.findElement(By.xpath("//*[text()='OK!']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("(//*[text()='OK'])[6]")).click();
Thread.sleep(4000);
if(driver.findElement(By.id("psearch")).isDisplayed())
{
driver.findElement(By.id("psearch")).clear();
Thread.sleep(3000);
driver.findElement(By.id("psearch")).sendKeys(Exp_data);
driver.findElement(By.id("btnsubmit")).click();
Thread.sleep(3000);
}
else
{
driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-search ewIcon']")).click();
driver.findElement(By.id("psearch")).clear();
Thread.sleep(3000);
driver.findElement(By.id("psearch")).sendKeys(Exp_data);
driver.findElement(By.id("btnsubmit")).click();
Thread.sleep(4000);
}
String Act_data=driver.findElement(By.xpath
("//table[@id='tbl_a_supplierslist']/tbody/tr[1]/td[6]/div/span/span")).getText();
Thread.sleep(4000);
System.out.println(Exp_data+"         "+Act_data);
if(Exp_data.equals(Act_data))
{
res="Pass";
}
else
{
res="Fail";
}
driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
return res;
}
public void logout()
{
	driver.quit();
}
}













