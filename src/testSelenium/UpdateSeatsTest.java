package testSelenium;
//Davide
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateSeatsTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\david\\Documents\\GitHub\\Studio1.0\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/Studio1.0/");
		driver.findElement(By.xpath("//*[@id=\"user\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"emailLogin\"]")).sendKeys("librarian@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwordLogin\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"buttonUpdateSeats\"]/button[1]")).click();
		driver.close();
	}


}
