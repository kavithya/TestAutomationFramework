package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties conf = new Properties();
	public static Properties loc = new Properties();
	public static FileReader config;
	public static FileReader locators;

@BeforeMethod
	public void setUp() throws IOException {
		if (driver == null) {
			config = new FileReader(System.getProperty("user.dir") +"\\src\\test\\resources\\configfiles\\config.properties");
			locators = new FileReader(System.getProperty("user.dir") +"\\src\\test\\resources\\configfiles\\locators.properties");
			conf.load(config);
			loc.load(locators);
		}
		if (conf.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(conf.getProperty("testurl"));
		}
		if (conf.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(conf.getProperty("testurl"));
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("TearDown Successful");
	}

}
