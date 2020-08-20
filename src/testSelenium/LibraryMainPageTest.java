package testSelenium;
//Matteo
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryMainPageTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\david\\Documents\\GitHub\\Studio1.0\\Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/Studio1.0/");
		driver.findElement(By.xpath("//*[@id=\"user\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"emailLogin\"]")).sendKeys("bib@live.it");
		driver.findElement(By.xpath("//*[@id=\"passwordLogin\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"tableBookings\"]/tbody/tr[1]/td[3]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"tableBookings\"]/tbody/tr[1]/td[3]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"buttonUpdateSeats\"]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"buttonUpdateSeats\"]/a[2]")).click();
	}

}
