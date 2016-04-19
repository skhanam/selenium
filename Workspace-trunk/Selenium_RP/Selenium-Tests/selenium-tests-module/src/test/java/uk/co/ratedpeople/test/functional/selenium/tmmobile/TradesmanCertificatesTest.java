package uk.co.ratedpeople.test.functional.selenium.tmmobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.ratedpeople.IntegrationTestUsers;
import uk.co.ratedpeople.test.functional.selenium.TestScript;
import uk.co.ratedpeople.test.functional.selenium.tmmobile.functions.TestFunctionsGasSafePartP;

public class TradesmanCertificatesTest extends TestScript {

	private static final String GAS_CERT_POSTREQ_FOR_ADD_DELETE = 

	"<gassafecertificate>" +
	"<name>Watertight</name>"+
	"<registrationnumber>215772</registrationnumber>" +
	"<expirydate>2020-01-01T00:00:00Z</expirydate>"+ 
	"</gassafecertificate>";
	
	private WebDriver driver;
	private TestFunctionsGasSafePartP testFunctions;
	private static final String CERTIFICATE_REG_NUM_ONE = "215772";

	@BeforeMethod
	public void setUp() throws Exception {
		driver = context.driver;
		testFunctions = new TestFunctionsGasSafePartP(driver);
	}

	@Test(enabled = true)
	public void testGetAllGasCertificates() throws Exception {

		List<Integer> idsList = testFunctions.getListOfGasSafeCertificateIds(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		System.out.println(idsList);
		assertNotNull(idsList);
	}

	@Test(enabled = true)
	public void testAddAndDeleteGasSafeCertificate() throws Exception {

		List<Integer> listOfCert = testFunctions.getListOfGasSafeCertificateIds(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		if(listOfCert!=null && !listOfCert.isEmpty()){
			HttpResponse deleteResponse1 = testFunctions.deleteGasSafeCertification(CERTIFICATE_REG_NUM_ONE, IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
				assertEquals(deleteResponse1.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}
		
		List<Integer> idsList = testFunctions.getListOfGasSafeCertificateIds(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		assertNotNull(idsList);
		String registrationNumber = ("" + System.currentTimeMillis()).substring(0, 7);
		String certificateDetailsXml = testFunctions.buildGasSafeCertificateDetailsXml("Watertight", "215772",
				getDateTenYearsFromNow(), IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		System.out.println(certificateDetailsXml);
		HttpResponse postResponse = testFunctions.addGasSafeCertification(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD,
				certificateDetailsXml);
		assertEquals(postResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		Header locationHeader = postResponse.getFirstHeader("Location");
		assertNotNull(locationHeader.getValue());

		System.out.println(locationHeader.getValue());

		// delete it as we do not need to keep it.
		HttpResponse deleteResponse = testFunctions.deleteGasSafeCertification(registrationNumber, IntegrationTestUsers.TP_ADD_DELETE_TEST_USER,
				IntegrationTestUsers.TP_PASSWORD);
		assertEquals(deleteResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}

	@Test(enabled = true)
	public void testAddV2AndDeleteV1GasSafeCertificate() throws Exception {

		List<Integer> listOfCert = testFunctions.getListOfGasSafeCertificateIds(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		if(listOfCert!=null && !listOfCert.isEmpty()){
			HttpResponse deleteResponse1 = testFunctions.deleteGasSafeCertification(CERTIFICATE_REG_NUM_ONE, IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
				assertEquals(deleteResponse1.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}
		
		List<Integer> idsList = testFunctions.getListOfGasSafeCertificateIds(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD);
		assertNotNull(idsList);
		String registrationNumber = ("" + System.currentTimeMillis()).substring(0, 7);
		String certificateDetailsXml  = GAS_CERT_POSTREQ_FOR_ADD_DELETE;
		System.out.println(certificateDetailsXml);
		HttpResponse postResponse = testFunctions.addGasSafeCertificationV2(IntegrationTestUsers.TP_ADD_DELETE_TEST_USER, IntegrationTestUsers.TP_PASSWORD,
				certificateDetailsXml);
		assertEquals(postResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		Header locationHeader = postResponse.getFirstHeader("Location");
		assertNotNull(locationHeader.getValue());

		System.out.println(locationHeader.getValue());

		// delete it as we do not need to keep it.
		HttpResponse deleteResponse = testFunctions.deleteGasSafeCertification(registrationNumber, IntegrationTestUsers.TP_ADD_DELETE_TEST_USER,
				IntegrationTestUsers.TP_PASSWORD);
		assertEquals(deleteResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test(enabled = true)
	public void testGetAllPartPCertificates() throws Exception {

		List<Integer> idsList = testFunctions.getListOfPartPCertificateIds(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD);
		System.out.println(idsList);
		assertNotNull(idsList);
	}

	@Test(enabled = true)
	public void testAddAndDeletePartPCertificate() throws Exception {

		List<Integer> idsList = testFunctions.getListOfPartPCertificateIds(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD);
		assertNotNull(idsList);
		String registrationNumber = "" + System.currentTimeMillis();
		String certificateDetailsXml = testFunctions.buildPartPCertificateDetailsXml("" + System.currentTimeMillis(), registrationNumber,
				getDateTenYearsFromNow(), "BSI", IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD);
		System.out.println(certificateDetailsXml);
		HttpResponse postResponse = testFunctions.addPartPCertification(IntegrationTestUsers.TP_INTEGRATION_TEST, IntegrationTestUsers.TP_PASSWORD,
				certificateDetailsXml);
		assertEquals(postResponse.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

		Header locationHeader = postResponse.getFirstHeader("Location");
		assertNotNull(locationHeader.getValue());
		System.out.println(locationHeader.getValue());

		// delete it as we do not need to keep it.
		HttpResponse deleteResponse = testFunctions.deletePartPCertification(registrationNumber, IntegrationTestUsers.TP_INTEGRATION_TEST,
				IntegrationTestUsers.TP_PASSWORD);
		assertEquals(deleteResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}

	@Test(enabled = false)
	public void testExpireGasCertificate() throws Exception {
		throw new RuntimeException("Not yest implemented");
	}

	private Date getDateTenYearsFromNow() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 10);
		return cal.getTime();
	}
}
