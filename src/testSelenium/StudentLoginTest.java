package testSelenium;
//Adriano
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentLoginTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\matte\\Documents\\GitHub\\Studio1.0\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/Studio1.0/");
		driver.findElement(By.xpath("//*[@id=\"user\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"emailLogin\"]")).sendKeys("stu@live.it");
		driver.findElement(By.xpath("//*[@id=\"passwordLogin\"]")).sendKeys("1234");
	}

}
