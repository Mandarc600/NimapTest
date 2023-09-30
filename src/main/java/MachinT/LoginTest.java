package MachinT;


import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest 
{
	
	     WebDriver driver;
	
         @Parameters({"browser","url"})
	     @Test
	     public void OpenBrow(String browser, String url) {
    	
    	 System.out.println("Running browser is:" + browser);
    	
    	 if(browser.equals("chrome")) {
    		
    	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");
    		
    	 driver = new ChromeDriver();
    }
    	
    	 else if (browser.equals("firefox"))
    {
    	 driver= new FirefoxDriver();
   	}
    	 else if(browser.equals("ie"))
    {
    	 driver=new InternetExplorerDriver();
    }
		
		 driver.get(url);
	}
         
         @Parameters({"username","password",})
         @Test(priority=1)
         public void LoginTest(String username, String password) throws InterruptedException {
        	 
         driver.findElement(By.id("mat-input-0")).sendKeys(username);
     	 driver.findElement(By.id("mat-input-1")).sendKeys(password);
     		
     	 String str = JOptionPane.showInputDialog("Enter Captcha");
     	 WebElement Ele = driver.findElement(By.xpath("//*[@id=\"kt_login\"]/div/div[2]/kt-login/div[2]/div/form/div[3]/kt-captcha/div/div/form/input"));
     	 Ele.sendKeys(str);
     		 
     	 Thread.sleep(5000);
     	 driver.findElement(By.id("kt_login_signin_submit")).click();
     		 
     	 Thread.sleep(5000);

     }
         
            @Test(priority=2)
                
             public void Popup() throws InterruptedException 
                  {
          	 
             driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])[3]")).click();
             Thread.sleep(2000);
             ChromeOptions options= new ChromeOptions();
             options.addArguments("disable-geolocation");
             Thread.sleep(2000);      
        }
    
                 
              @Test(priority=3)
              public void  AddU() throws InterruptedException {
              driver.findElement(By.xpath("(//*[text()='My Customers'])[1]")).click();
              Thread.sleep(2000);
              driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])[7]")).click();       
            	
      }
             @Parameters({"CustName","RefNo","ConperName","MoNo","Email","ConPerDes","Add"})
             @Test(priority=4)
             public void AddUser(String CustName, String RefNo, String ConperName, String MoNo, String Email, String ConPerDes, String Add) throws InterruptedException
       {
            	
              driver.findElement(By.id("mat-input-9")).sendKeys(CustName);
              
              driver.findElement(By.xpath("//*[@id='mat-input-10']")).sendKeys(RefNo);
     	
        	  driver.findElement(By.id("mat-input-11")).sendKeys(ConperName);
        	    
        	  driver.findElement(By.xpath("//*[@id='mat-input-12']")).sendKeys(MoNo);
        	  
        	  driver.findElement(By.id("mat-input-14")).sendKeys(Email);
        	  
        	  driver.findElement(By.id("mat-input-15")).sendKeys(ConPerDes);
        	  
        	  driver.findElement(By.id("mat-input-16")).click();
        	  
        	  WebElement Address = driver.findElement(By.id("mat-input-23"));
        	  Address.clear();
        	  Address.sendKeys(Add);
        	  
        	  driver.findElement(By.xpath("//*[@class='float-right mat-raised-button mat-button-base mat-primary']")).click(); 
        	    
        	  driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])[21]")).click();
        	  
        	  }
}