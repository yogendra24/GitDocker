import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirefoxDocker extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String environment = "Firefox";
		// TODO Auto-generated method stub
		if (environment.equalsIgnoreCase("Firefox")) {
			setupThread("Firefox");
		}
		WebDriver webdriver = getDriver();
		webdriver.navigate().to("https://docs.docker.com/search/?q=test");
		webdriver.manage().window().maximize();
		System.out.println("Started session");
		Thread.sleep(5000);
                //code for reading data from UI
		try

		{

			String enteredText = webdriver.findElement(By.id("home")).getText();
			System.out.println("text is:" + enteredText);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (getDriver() != null) {
			tearDownDriver();
		}
	}

}
