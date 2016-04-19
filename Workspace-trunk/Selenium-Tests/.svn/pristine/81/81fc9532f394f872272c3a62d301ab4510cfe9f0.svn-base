package uk.co.ratedpeople.test.functional.selenium.coresystems.mk3_flushcache;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.ratedpeople.test.functional.selenium.TestScript;

public class FlushCacheTest extends TestScript {
	
	private FlushCache slogin; 
	
	@BeforeClass
	public void beforeClass() throws IOException {
		slogin = new FlushCache(this.context);		
	}
	
	@Test(enabled=false)
	public void RPflushCache(){
	slogin.loginSupport("sangeetha.kumar@ratedpeople.com", "password");
	slogin.rpPropertyUtilsFlushCache();
	}
		
}
