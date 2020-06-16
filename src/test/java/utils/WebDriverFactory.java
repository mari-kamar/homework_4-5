package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverFactory {

    public static WebDriver createDriver(String browser, String options) {
        String browserName = browser == null ? "CHROME" : browser.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (Browsers.valueOf(browserName)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (options.length() > 0) chromeOptions.addArguments(options);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(options);
                if (options.length() > 0) firefoxOptions.addArguments(options);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                firefoxOptions.merge(capabilities);
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalStateException("browser name must be specified");
        }

    }

    public static WebDriver createDriver(String browser) {
        return createDriver(browser, new String());
    }
}