package com.makemytrip.Base;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

	public static ThreadLocal<RemoteWebDriver> tldriver = new ThreadLocal<RemoteWebDriver>();
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

	public static void setDriver(String BrowserName) throws MalformedURLException {
		if (BrowserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("remote_url")),options));
		} else if (BrowserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("remote_url")),options));
		} else {
			ChromeOptions options = new ChromeOptions();
			tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("remote_url")),options));
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
