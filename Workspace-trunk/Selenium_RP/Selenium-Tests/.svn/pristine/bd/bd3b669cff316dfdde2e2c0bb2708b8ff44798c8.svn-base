/**
 * 
 */
package uk.co.ratedpeople.test.functional.selenium.core.regression;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;
import static org.testng.Assert.assertEquals;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uk.co.ratedpeople.test.functional.SeleniumTestContext;
import uk.co.ratedpeople.test.functional.selenium.TestScriptUtilities;
import uk.co.ratedpeople.test.functional.selenium.functions.Login;


/**
 * @author shabana.khanam
 *
 */
public class BuyaLead {	

	private WebDriver driver;
	private TestScriptUtilities scriptUtils;
	private Login login;
	private static final String TM_NAME_ONWEB = " Albert McLaren";
	public static Logger logger = Logger.getLogger("uk.co.ratedpeople.test.functional.selenium.core.regression.BuyaLead");

	private ScreenRecorder screenRecorder;

	public BuyaLead(SeleniumTestContext context, TestScriptUtilities scriptUtils) {
		this.driver = context.driver;
		this.scriptUtils = scriptUtils;
		login = new Login(scriptUtils, context);
	}
	
	public void loginTMapp(String username,String password){
		login.loginTP(username, password);
	}
	
	public void loginadmin(String username, String password) throws Exception {
		login.loginSupport(username, password);
		
	}
	
	
	 public void startRecording() throws Exception
     {
                           
          GraphicsConfiguration gc = GraphicsEnvironment
             .getLocalGraphicsEnvironment()
             .getDefaultScreenDevice()
             .getDefaultConfiguration();

         this.screenRecorder = new ScreenRecorder(gc ,
//        		 new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
//         		new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey,
//         		ENCODING_QUICKTIME_JPEG, DepthKey, (int) 24,FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
//         		KeyFrameIntervalKey, (int) (15 * 60)),
//         		new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, "black", FrameRateKey,Rational.valueOf(30)),
//         		null);
         new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
   		 new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	              CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	              DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
	              QualityKey, 1.0f, KeyFrameIntervalKey, (int)(15 * 60)),
	     new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
              FrameRateKey, Rational.valueOf(30)),null);
        		 
        this.screenRecorder.start();
       
        
        
        
       
//        		// Create a instance of ScreenRecorder with the required configurations
//        		screenRecorder = new ScreenRecorder(gc,
//        		new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
//        		new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey,
//        		ENCODING_QUICKTIME_JPEG, DepthKey, (int) 24,FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
//        		KeyFrameIntervalKey, (int) (15 * 60)),
//        		new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, "black", FrameRateKey,Rational.valueOf(30)),
//        		null);
     }
	 

     public void stopRecording() throws Exception
     {
       this.screenRecorder.stop();
     }
	
	
	public void tmBuyJobwithexistingcard(String balance, int whichjob) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		logger.info("Logged into TM desktop");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMACCBALANCE"))));
//		assertEquals(context.driver.findElement(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMACCBALANCE"))).getText(),balance);
		assertEquals(driver.findElement(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMNAME"))).getText(),TM_NAME_ONWEB);
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("JOBLEADS")));
		Thread.sleep(3000);
		getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE"));
		String leadPrice = getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE"));
		BuyaLeadXpathLocators.dataLookup.put("LEADPRICEVALUE",leadPrice);
		logger.info("This is the Lead price  :"+getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE")));
		String formxpath = BuyaLeadXpathLocators.xpathLookup.get("VIEWFULLDETAILS")+"["+whichjob+"]/div/p[2]/a";
		logger.info("This is the xpath formed : "+formxpath);
		scriptUtils.click(By.xpath(formxpath));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("BUYBUTTON"))));
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("BUYBUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CONFIRMBUTTON"))));
		logger.info("Get Text for Change Card details  :"+driver.findElement(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CHANGECARDDETAILS"))).getText());
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CONFIRMBUTTON")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CONTACT_INFO"))));
		getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF"));
		String jobReference = getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF"));
		BuyaLeadXpathLocators.dataLookup.put("JOBREFERENCE",jobReference);
		logger.info("This is the Job reference : "+getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF")));
 		logger.info("Finished buying a job ");
		Thread.sleep(3000);
	}
	
	
	public void pmdPopup() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='message-light-box']/a")));
		scriptUtils.click(By.xpath(".//*[@id='message-light-box']/a"));
//		.//*[@id='message-light-box']/a
	}
	
	public void supporttm(String username) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"))));
		scriptUtils.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"),username);
 	    scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("MK3SEARCHGOBUTTON")));
 	    scriptUtils.sleep(5000);

 	    logger.info("Logged into support and searched the TM ");
 	    //Storing JBill id in support
 	    gettmsupportjbillid(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID"));
		String jbillid = gettmsupportjbillid(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID"));
		BuyaLeadXpathLocators.dataLookup.put("SUPPORTJBILLID",jbillid);
		logger.info("This is the JBilling id in support  :"+gettmsupportjbillid(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID")));
 	    logger.info("Logged into support and searched the TM ");
    	scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID")));
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID"))));
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SUPPORTJBILLINGID")));
 	    	    	

	}
	
	
	public void supporttmSearch(String username) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"))));
		scriptUtils.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"),username);
 	    scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("MK3SEARCHGOBUTTON")));
 	    scriptUtils.sleep(5000);
 	   }

	
	
	
	public void supporttm(String username,String status,String newstatus,String blacklistxpath,String unblacklistxpath) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"))));
		scriptUtils.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("MK3USERSEARCH"), username);
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("MK3SEARCHGOBUTTON")));
		scriptUtils.sleep(5000);
		logger.info("Logged into support and searched the TM ");
		assertEquals(status, checkStatus());
		logger.info("Now the user status is : " + checkStatus());
		changeStatus(blacklistxpath);
		driver.navigate().refresh();
		Thread.sleep(3000);
		logger.info("Now the user status is : " + checkStatus());
		assertEquals(checkStatus(), newstatus);
		logger.info("New Status of TM is  : " + checkStatus());
		changeStatus(unblacklistxpath);
		logger.info("New Status of TM is  : " + checkStatus());
		driver.navigate().refresh();
		Thread.sleep(3000);
		assertEquals(checkStatus(), status);
		logger.info("Back to Old Status of TM is  : " + checkStatus());
	}
	
	
	
	
	public String checkStatus(){
		String getStatus = scriptUtils.getValue(BuyaLeadXpathLocators.xpathLookup.get("BLACKLISTSTATUS"));
		logger.info("Checking status of TM : " + getStatus);
		return getStatus;
	}	
	
	public void changeStatus(String xpath) throws TimeoutException, InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		scriptUtils.clickXpath(xpath);
		Thread.sleep(6500);
		driver.navigate().refresh();
	}
	
	public void jBilling(String xpathAmount,String jobRefSubstr) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);		
		// switch focus of WebDriver to the next found window handle (that's your newly opened window)
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BuyaLeadXpathLocators.xpathLookup.get("JUSERNAME"))));
        scriptUtils.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("JUSERNAME"), BuyaLeadXpathLocators.dataLookup.get("JUNAME"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BuyaLeadXpathLocators.xpathLookup.get("JPASSWORD"))));
        scriptUtils.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("JPASSWORD"), BuyaLeadXpathLocators.dataLookup.get("JPWD"));
        scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("JLOGIN")));
        scriptUtils.sleep(5000);
        logger.info("Logged into JBilling ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("USER_ID"))));
        scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("USER_ID")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMJBILLID"))));
//        scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMJBILLID")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SHOW_ALL_ORDERS"))));
        scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SHOW_ALL_ORDERS")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathAmount)));
        scriptUtils.click(By.xpath(xpathAmount));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("JBILL_USER_ID"))));
        getJbilluserid(BuyaLeadXpathLocators.xpathLookup.get("JBILL_USER_ID"));
		logger.info("This is the JBilling user id : "+getJbilluserid(BuyaLeadXpathLocators.xpathLookup.get("JBILL_USER_ID")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_REF"))));
//        getJbillingjobref(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_REF"),jobRefSubstr);
        if(presentJbillingjobref(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_REF"),jobRefSubstr)){
        	logger.info("Job Reference matches TM App "+BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"));
        }
        	
		logger.info("This is the JBilling Job reference : "+presentJbillingjobref(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_REF"),jobRefSubstr));
		getJbillingtotaljobvalue(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_LEAD_TOTAL"));
		logger.info("This is the JBilling Lead price : "+getJbillingtotaljobvalue(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_LEAD_TOTAL")));
//        assertEquals(BuyaLeadXpathLocators.dataLookup.get("JOBREFERENCE"),getJbillingjobref(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_REF"),jobRefSubstr));
		assertEquals(BuyaLeadXpathLocators.dataLookup.get("LEADPRICEVALUE"),getJbillingtotaljobvalue(BuyaLeadXpathLocators.xpathLookup.get("JBILLING_JOB_LEAD_TOTAL")));
		assertEquals(BuyaLeadXpathLocators.dataLookup.get("SUPPORTJBILLID"),getJbilluserid(BuyaLeadXpathLocators.xpathLookup.get("JBILL_USER_ID")));
		
	}
	
	public void tmBuyJobwithNewCard(String balance) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMACCBALANCE"))));
		assertEquals(driver.findElement(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("TMACCBALANCE"))).getText(),balance);
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("JOBLEADS")));
	    Thread.sleep(3000);
		getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE"));
		logger.info("This is the Lead price  :"+getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE")));
		String leadPrice = getLeadPrice(BuyaLeadXpathLocators.xpathLookup.get("LEADPRICE"));
		BuyaLeadXpathLocators.dataLookup.put("LEADPRICEVALUE",leadPrice);
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("VIEWFULLDETAILS")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("BUYBUTTON"))));
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("BUYBUTTON")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CHANGECARDDETAILS"))));
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CHANGECARDDETAILS")));
		logger.info("Adding new card details");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CARDHOLDERNAME"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("CARDHOLDERNAME"), BuyaLeadXpathLocators.dataLookup.get("NAME_ONTHE_CARD"));
//		.fillInTextField(BuyaLeadXpathLocators.xpathLookup.get("CARDHOLDERNAME"), BuyaLeadXpathLocators.dataLookup.get("NAME_ONTHE_CARD"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CARDTYPE"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("CARDTYPE"), BuyaLeadXpathLocators.dataLookup.get("CARD_TYPE"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CARDNUMBER"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("CARDNUMBER"), BuyaLeadXpathLocators.dataLookup.get("CARDNUMBER"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("ENDDATE_MONTH"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("ENDDATE_MONTH"), BuyaLeadXpathLocators.dataLookup.get("END_DATE_MONTH"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("ENDDATE_YEAR"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("ENDDATE_YEAR"), BuyaLeadXpathLocators.dataLookup.get("END_DATE_YEAR"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CVV"))));
		scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("CVV"), BuyaLeadXpathLocators.dataLookup.get("CVV"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("ADDCARD_BUYJOB_BUTTON"))));
		scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("ADDCARD_BUYJOB_BUTTON")));
//		wait.until(ExpectedConditions.titleIs(scriptUtils.getTitle()));
		Thread.sleep(5000);
		logger.info("Check if it is a sage page ... : "+scriptUtils.getTitle());
		if(scriptUtils.getTitle().contentEquals("threedauthentication")){
			logger.info("It is a sage page ... : "+scriptUtils.getTitle());
			scriptUtils.clear(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("THREEDPASSWORD")));
			scriptUtils.fillInXpathField(BuyaLeadXpathLocators.xpathLookup.get("THREEDPASSWORD"), "password");
			
			scriptUtils.click(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("SUBMITTHREED")));
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BuyaLeadXpathLocators.xpathLookup.get("CONTACT_INFO"))));
		getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF"));
		logger.info("This is the Job reference : "+getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF")));
		String jobReference = getJobReference(BuyaLeadXpathLocators.xpathLookup.get("JOBREF"));
		BuyaLeadXpathLocators.dataLookup.put("JOBREFERENCE",jobReference);
		logger.info("Successfully bought job with new card ");
	}
	
	private  String getJobReference(String xpathjobreference) throws Exception{
		String jobreference = scriptUtils.getValue(xpathjobreference).substring(14);
		return jobreference;
		
	} 
	
	
	private String getLeadPrice(String xpathleadprice) throws Exception{
		String leadprice = scriptUtils.getValue(xpathleadprice);
		return leadprice;
		
	}
	
	private String gettmsupportjbillid(String xpathtmjbillid) throws Exception{
		String tmsupportjbillid = scriptUtils.getValue(xpathtmjbillid);
		return tmsupportjbillid;
		
	}
	
	private boolean presentJbillingjobref(String xpathjbillingjobref, String jobref)
			throws Exception {
		String jbillingjobref = scriptUtils.getValue(xpathjbillingjobref).replaceAll("\\s+", "");
		logger.info("Jbilling JobReference : " + jbillingjobref);
		boolean foundjobref = jbillingjobref.contains(jobref);
		return foundjobref;
	}
	
	private String getJbillingtotaljobvalue(String xpathJbillingtotaljobvalue) throws Exception{
		String jbillingtotaljobvalue = scriptUtils.getValue(xpathJbillingtotaljobvalue).substring(0,3);
		if(BuyaLeadXpathLocators.dataLookup.get("LEADPRICEVALUE").equals(jbillingtotaljobvalue))
		{
			return jbillingtotaljobvalue;
		}else{
			String jbillingtotalvalue = scriptUtils.getValue(xpathJbillingtotaljobvalue).substring(1,4);
			return jbillingtotalvalue;
		}
	}
	
	private String getJbilluserid(String xpathJbillinguserid) throws Exception{
		String jbillingid = scriptUtils.getValue(xpathJbillinguserid);
		return jbillingid;
		
	}
}
