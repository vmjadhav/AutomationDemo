package Jenkins_Demo.Jenkins_Demo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;

import com.experitest.appium.SeeTestClient;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {

	private String testName = "Jenkins Demo Android Phone";
	protected AndroidDriver<AndroidElement> driver = null;
	protected DesiredCapabilities dc = new DesiredCapabilities();
	private SeeTestClient client;
    //private String accessKey = "eyJ4cC51Ijo2MzYyMDQxLCJ4cC5wIjo2MzYyMDQwLCJ4cC5tIjoiTVRVMU9ERTNOalEyTXpNNE5BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NzM1MzY0NjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.I0lYQp0QK3EQPxosVQHZ3PyJRzdQLUxLdll8fQZ6Rwc";
      
	
 
    @Before
    public void setUp() throws MalformedURLException {
	   
        	dc.setCapability("testName", testName);
		//dc.setCapability("deviceQuery", System.getenv("deviceQuery"));
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("stream", "jenkins_android_phone");
		dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
		dc.setCapability("accessKey", "accessKey");
        	dc.setCapability(MobileCapabilityType.UDID, System.getenv("RESERVED_DEVICE"));
        	
    		
	        
        driver = new AndroidDriver<AndroidElement>(new URL(System.getenv("url")), dc);
        client = new SeeTestClient(driver);
    }

    @Test
    public void test() {
    	client.install("cloud:uniqueName=testEribankAndroid_" + System.getenv("BUILD_NUMBER"), true, false);
    	client.launch("cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity", true, true);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
