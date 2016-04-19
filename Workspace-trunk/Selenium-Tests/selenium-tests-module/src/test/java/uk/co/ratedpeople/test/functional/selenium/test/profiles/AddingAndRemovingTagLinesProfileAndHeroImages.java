package uk.co.ratedpeople.test.functional.selenium.test.profiles;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;

public class AddingAndRemovingTagLinesProfileAndHeroImages extends TestScriptUtilities {
private WebDriver driver;
private final String imageFolderPath;
private final String heroImagePath;
private final String heroImagePath2;
private final String smallImagePath;
private final String pdfImagePath;
//private final String bigheroImagePath;
private final String gifImagePath;
private final String portraitImagePath;
private static final Logger LOGGER = Logger.getLogger(AddingAndRemovingTagLinesProfileAndHeroImages.class.getName());
private static final DateFormat df = new SimpleDateFormat("EEE, dd MMM HH mm");
private static final Date date = new Date(); 
private String testUrl;
WebDriverWait wait = new WebDriverWait(context.driver, 30);
//private String getUsername = "integration.test@ratedtrades.com";

	public AddingAndRemovingTagLinesProfileAndHeroImages(SeleniumTestContext context) {
		super(context);
		driver = context.driver;
		testUrl = context.getTestUrl ();
		imageFolderPath = context.getTestImageFolderPath(); 	    	
		LOGGER.log(Level.INFO, "imageFolderPath="+imageFolderPath);
		
		
		heroImagePath2 = imageFolderPath + File.separator + "profile" + File.separator + "photos.jpg";
		smallImagePath = imageFolderPath + File.separator + "profile" + File.separator + "small_photo.png";
		pdfImagePath = imageFolderPath + File.separator + "profile" + File.separator + "pdf_photo.pdf";
		//bigheroImagePath = imageFolderPath + File.separator + "profile" + File.separator + "big-hero-photo.jpg";
		gifImagePath = imageFolderPath + File.separator + "profile" + File.separator + "tradesman-photo.gif";
		portraitImagePath = imageFolderPath + File.separator + "profile" + File.separator + "Photo_Portrait.jpg";
		heroImagePath = imageFolderPath + File.separator + "profile" + File.separator + "hero-photo.jpg";
	}
	
	private String getTagLine() {
		return "Hello all! I am a good Tradesman, before I publish my RSS on the our RSS aggregators. " +
			"In Ninja RSS Syndicator is possible to limit description by words, but I need description with 252 characters. " +
			"Please, tell get to me for good work. This is to test that you cant add more than 250 characters to the taglin " + df.format(date);
	}
	private String getTagLine2() {
		return "Hello all! We are a very hardworking and trustworthy Tradesmen. We will do a Good Job. "  + df.format(date);
	}
		public void addingAndRemovingTagline() throws Exception{
			WebDriverWait wait = new WebDriverWait(context.driver, 50);
			goTo(testUrl + "/log-in");  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName"))).sendKeys("profile.user@ratedtrades.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpPassword"))).sendKeys("password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-tp-button"))).click();
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Website"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        equals(driver.findElement(By.id("tag_line")).getAttribute("We are a family owned bathroom specialist company with over 25 years of experience, providing bespoke installations."));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("www.ratedpeople.com");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        sleep(3000);
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add your contact info");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("i am a good tradesman hotmail");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag-line-errors")));
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add your contact info");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();	        
	        driver.findElement(By.id("tag_line")).sendKeys(getTagLine());
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag-line-errors")));
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add more than 255 characters");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("<img src=\"smiley.gif\" alt=\"Smiley face\" height=\"42\" width=\"42\">");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add html");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("<h1></h1>");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add html");
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).sendKeys("07988673205");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
	        assertEquals(driver.findElement(By.id("tag-line-errors")).getText(), "Please don't add phone number");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line"))).clear();
	        driver.findElement(By.id("tag_line")).sendKeys(getTagLine2());
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag_line_button"))).click();
			sleep(3000);
			assertEquals(driver.findElement(By.xpath("//*[@id='tag-line-confirmation']")).getText(), "Updated Successfully");
		}
		
		public void AddingAndDeletingProfileImage () throws Exception{
			WebDriverWait wait = new WebDriverWait(context.driver, 50);
			goTo(testUrl + "/log-in");  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName"))).sendKeys("profile.user@ratedtrades.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpPassword"))).sendKeys("password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-tp-button"))).click();
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Website"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(heroImagePath);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-image-crop-submit"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(smallImagePath);
	        assertEquals(driver.findElement(By.xpath("//*[@id='lightbox1']/div/div[1]/span")).getText(), "Image resolution of the uploaded image is too low.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-image-crop-cancel"))).click();
			//assert you can't add pdf
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(pdfImagePath);
			assertEquals(driver.findElement(By.xpath("//*[@id='profile-image-errors']")).getText(), "Please use a .jpg, .jpeg, .png, .gif or .bmp file type");
			//delete profile image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile_image_delete_link"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-image-remove-confirm"))).click();
						
		}
		public void AddingAndDeletingHeroImage () throws Exception {
			WebDriverWait wait = new WebDriverWait(context.driver, 50);
			goTo(testUrl + "/log-in");  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName"))).sendKeys("profile.user@ratedtrades.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpPassword"))).sendKeys("password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-tp-button"))).click();
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Website"))).click();
	        driver.findElement(By.cssSelector("form#hero_image_form > table.wwFormTable tbody tr td > input#imageUpload")).sendKeys(heroImagePath); 
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-image-crop-submit"))).click();
			driver.findElement(By.cssSelector("form#hero_image_form > table.wwFormTable tbody tr td > input#imageUpload")).sendKeys(gifImagePath); 
			assertEquals(driver.findElement(By.xpath("//*[@id='lightbox2']/div/div[1]/span")).getText(), "Image resolution of the uploaded image is too low.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-image-crop-cancel"))).click();
			driver.findElement(By.cssSelector("form#hero_image_form > table.wwFormTable tbody tr td > input#imageUpload")).sendKeys(pdfImagePath ); 
			assertEquals(driver.findElement(By.xpath("//*[@id='hero-image-errors']")).getText(), "Please use a .jpg, .jpeg, .png, .gif or .bmp file type");
		    
			driver.findElement(By.cssSelector("form#hero_image_form > table.wwFormTable tbody tr td > input#imageUpload")).sendKeys(portraitImagePath); 
			assertEquals(driver.findElement(By.xpath("//*[@id='lightbox2']/div/div[1]/span")).getText(), "Image resolution of the uploaded image is too low.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hero-image-crop-cancel"))).click();
			
			
}
		public void AddingMyPhotos () throws Exception {
			WebDriverWait wait = new WebDriverWait(context.driver, 50);
			goTo(testUrl + "/log-in");   
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpUserName"))).sendKeys("profile.user@ratedtrades.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpPassword"))).sendKeys("password");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-as-tp-button"))).click();
			WebElement account = driver.findElement(By.xpath("//*[@id='profile-link']"));
			Actions builder = new Actions(driver);
	        Action hoverAction = builder.moveToElement(account).build();
	        hoverAction.perform();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Photos"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(heroImagePath2);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageDescription"))).sendKeys("This is my new photo");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-photo-save-submit"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageUpload"))).sendKeys(heroImagePath2);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imageDescription"))).sendKeys("This is my new photo");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-photo-save-submit"))).click();
	        //scroll photos
			sleep(4000);
			 ((JavascriptExecutor)driver).executeScript("scrollTo(0,6000)");
			 sleep(4000);
			 ((JavascriptExecutor)driver).executeScript("scrollTo(0,6000)");
			 System.out.println("scroll complete");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[3]/div/ul/li[2]/figure/a/img"))).click();
			 //driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/ul/li[2]/figure/a/img")).click();
			 System.out.println("image clicked");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("image-description"))).clear();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("image-description"))).sendKeys("This is my new photo 2");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("image-update"))).click();
			 sleep(3000);
			 assertEquals(driver.findElement(By.xpath("//*[@id='img-overlay']/div/div[3]/p[3]")).getText(), "Image description has been succesfully updated");
			 						 
		}
		
		}

