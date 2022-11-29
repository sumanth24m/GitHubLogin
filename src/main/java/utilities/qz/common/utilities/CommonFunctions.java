package utilities.qz.common.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFunctions {
    public static Properties prop;
    public static WebDriver driver;


    public static Properties loadPropertyFile() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);
        return prop;
    }

    public static void navigateUrl()
    {
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public static void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    @BeforeSuite

    public static void launchBrowser() throws IOException   {

        prop= loadPropertyFile();

        //String browser=System.getProperty("browser");
        String browser = prop.getProperty("browser");
        // String url=prop.getProperty("url");
        String chromepath = prop.getProperty("chromepath");
        String firefoxpath = prop.getProperty("firefoxpath");
        String iepath = prop.getProperty("iepath");


        if (browser.equalsIgnoreCase("Chrome")) {
            //System.setProperty("webdriver.chrome.driver", chromepath);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", firefoxpath);
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("InternetExplorer"))
        {
            System.setProperty("webdriver.ie.driver", iepath);
            driver = new InternetExplorerDriver();
        }

        navigateUrl();

        maximizeWindow();
        //driver.get(url);
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
