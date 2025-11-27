package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;

    @Parameters({"os", "browser"})
    @BeforeClass
    public void setup(String os, String br) throws IOException {

        // ✅ 1. Load config.properties FIRST (fix for NullPointer)
        prop = new Properties();
        FileReader file = new FileReader("./src/main/resources/config.properties");
        prop.load(file);

        // Get execution environment
        String execEnv = prop.getProperty("execution_env").trim();

        // ✅ 2. Remote Execution
        if (execEnv.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS Setting
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN10);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("Invalid OS");
                return;
            }

            // Browser Setting
            switch (br.toLowerCase()) {
                case "chrome": capabilities.setBrowserName("chrome"); break;
                case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
                case "firefox": capabilities.setBrowserName("firefox"); break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        // ✅ 3. Local Execution
        else if (execEnv.equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome": driver = new ChromeDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                case "firefox": driver = new FirefoxDriver(); break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }
        }

        // Launch URL
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomnumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(4) + "@" + RandomStringUtils.randomNumeric(3);
}

    public String captureScreen(String tname) {
        String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+""+timestamp;
        return targetFilePath;
}
}

