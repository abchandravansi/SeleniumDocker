package com.makemytrip.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public static Properties prop;
	public static String path = System.getProperty("user.dir");

	public BasePage() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path + "\\src\\main\\resources\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setDriver(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		} else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		} else {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static String getScreenshot(String PageName) {
		try {
			File src = ((TakesScreenshot) tldriver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + PageName + System.currentTimeMillis()
					+ ".png";
			File destination = new File(path);
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void closeBrowser() {
		tldriver.get().close();
		tldriver.remove();
	}
}
