import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.Console;
import java.net.MalformedURLException;
import java.net.URL;
 
public class ChromeDocker extends Base 
{
    public static String status = "passed";
    static String environment="chrome";
   
    
    public static void main(String args[]) throws MalformedURLException{
 
  
        String search_string =" LambdaTest";
        String exp_title = "Most Powerful Cross Browser Testing Tool Online | LambdaTest";
 
        if (environment.equalsIgnoreCase("chrome"))
        {
            setupThread("chrome");
        }
        WebDriver webdriver = getDriver();
        webdriver.navigate().to("https://www.google.com");
        webdriver.manage().window().maximize();
        System.out.println("Started session");
 
        try {
            /* Code from Chorme */
            WebElement search_box = webdriver.findElement(By.xpath("//input[@name='q']"));
            search_box.sendKeys(search_string);
 
            search_box.submit();
            Thread.sleep(3000);
 
            /* Click on the first result which will open up the LambdaTest homepage */
            WebElement lt_link = webdriver.findElement(By.xpath("//span[.='LambdaTest: Most Powerful Cross Browser Testing Tool Online']"));
            lt_link.click();
            Thread.sleep(5000);
 
            String curr_window_title = webdriver.getTitle();
           // Assert.assertEquals(curr_window_title, exp_title);
            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (getDriver() != null)
        {
            tearDownDriver();
        }
    }
 
  
}