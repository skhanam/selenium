package uk.co.ratedpeople;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;

/**
 * Helper class for submitting jobs.
 * 
 * Ideally all should be data independant, and as such, use of elise cross is deprecated. Find another way!
 */
public class JobSubmitter {

	private static final Logger LOGGER = Logger.getLogger(JobSubmitter.class.getName());
	
	private static final String SUMMARY_FOR_TEST_JOB = "Summary for test job ";

	public static final String CUSTOMER_USERNAME = "elisecross@ratedtrades.com";
	public static final String CUSTOMER_FIRST_NAME = "Elise";
	public static final String CUSTOMER_LAST_NAME = "Elise";
	public static final String CUSTOMER_PASSWORD = "password";
	public static final String CUSTOMER_MOBILE = "07700900000";

	public static final String QUALIFICATION_STATUS = "For Qualification";
	private static final String REQUESTING_STATUS = "Requesting Quotes";

	private static final int SECONDS_PER_POLL = 2;
	private static final int SECONDS_TO_WAIT_FOR_JOB_SUBMISSION = 900;

	private final HttpRequestCreator requestCreator;
	private final HttpRequestExecutor requestExecutor;

	private XmlUtils xmlUtils;
	private HttpResponseUtils httpResponseUtils;
	private XmlDocumentUtils xmlDocUtils;

	private UserRetriever userRetriever = new UserRetriever();
	
	private TestContext testContext; 

	public enum Trade {
		AERIAL_NETWORK("network"), BATHROOM("bathroom"), BRICKLAYER("bricklayer"), BUILDER("builder"), CARPENTER("carpenter"), CLEANER("cleaner"), CRAFTSMAN(
						"craftsman"), DECORATOR("decorator"), DRAINAGE("drainage"), DRIVEWAY("driveway"), ELECTRICIAN("electrician"), FLOORING(
						"flooring"), GARDENER("gardener"), HANDYMAN("handyman"), HEATING("heating"), KITCHEN("kitchen"), LOCKSMITHS("locksmiths"), LOFT(
						"loft"), METALWORKER("metalworker"), NETWORK("network"), PEST("pest"), PLASTERER("plasterer"), PLUMBER("plumber"), POOL(
						"pool"), ROOFER("roofer"), SECURITY("security"), SPECIALIST("specialist"), STONEWORKER("stoneworker"), TILER("tiler"), TREE(
						"tree"), WINDOWS("windows");

		private final String tradeCode;

		private Trade(final String tradeCode) {
			this.tradeCode = tradeCode;
		}

		public String getTradeCode() {
			return this.tradeCode;
		}
	}

	
	public static interface SkillTypeIds {
		static final String LOCKSMITH_JOB_TYPE = "70";
		public static final String PLUMBER_BATHINSTALL_JOB_TYPE = "18";
		public static final String METAL_FENCING_JOB_TYPE = "107";
		public static final String GAS_BOILERS_JOB_TYPE = "140";
		public static final String CHIMNEY_BUILDING_TYPE = "97";
		public static final String SPECIALIST_JOBTYPE_ONE = "131";
		public static final String GARDENER_JOBTYPE_ONE = "82";
		public static final String CARPET_CLEANING_JOB_TYPE = "144";
		public static final String POWER_SHOWERS_AND_PUMP_JOB_TYPE = "59";
	}
	
	public static final String URGENTLY_TIMING = "URGENTLY";
	public static final String READY_TO_HIRE_INTENT = "READY_TO_HIRE";
	
	public enum Budget {

		LT_100("LT_100"), 
		RANGE_100_250("RANGE_100_250"), 
		RANGE_250_500("RANGE_250_500"), 
		RANGE_500_1000("RANGE_500_1000"), 
		RANGE_1000_2000("RANGE_1000_2000"), 
		RANGE_2000_4000("RANGE_2000_4000"), 
		RANGE_4000_8000("RANGE_4000_8000");

		private final String budget;

		private Budget(final String budget) {
			this.budget = budget;
		}

		public String getBudget() {
			return budget;
		}

	}

	public JobSubmitter() {
		this.requestCreator = new HttpRequestCreator();
		this.requestExecutor = new HttpRequestExecutor();
		this.xmlUtils = new XmlUtils();
		this.httpResponseUtils = new HttpResponseUtils();
		this.xmlDocUtils = new XmlDocumentUtils();
		
		try {
			testContext = TestContext.getDefault();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Posts a "metal worker -> security fencing" job using Customer login of elise cross.
	 * 
	 * @param postcode
	 *            Postcode of job
	 * @return The job which has been submitted.
	 * @throws Exception
	 *             If the received status is not 200
	 */
	public APIJob submitMetalWorkerJobForExistingUser(String postcode) throws Exception {
		RestDomainXMLBeanUser user = createRandomNewHO();
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.METALWORKER, SkillTypeIds.METAL_FENCING_JOB_TYPE, user);
		return postAJob(jobToSubmit);
	}

	public APIJob submitGasBoilerJobForGivenUser(String firstName, String lastName, String username, String password, String postcode)
					throws Exception {
		return submitGasBoilerJobForGivenUser(firstName, lastName, username, postcode);
	}
	
	public APIJob submitGasBoilerJobForNewUser(String postcode) throws Exception {
		return submitJobForNewUser(postcode, Trade.PLUMBER, SkillTypeIds.GAS_BOILERS_JOB_TYPE);
	}

	public APIJob submitChimneyBuildingJobForGivenUser(String firstName, String lastName, String username, String password, String postcode)
					throws Exception {
		return submitChimneyBuildingJobForGivenUser(firstName, lastName, username, postcode);
	}

	public APIJob submitMetalWorkerJobForGivenUser(String firstName, String lastName, String username, String password, String postcode)
					throws Exception {
		return submitMetalWorkerJobForGivenUser(firstName, lastName, username, postcode);
	}

	public APIJob submitJob(String firstName, String lastName, String email, String password, String mobile, Trade trade, String jobTypeId,
					Budget budgetCode, String postCode) throws UnsupportedEncodingException, Exception {
		return submitJob(firstName, lastName, email, mobile, trade, jobTypeId, budgetCode, postCode, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}
	
	public APIJob submitJobTimingIntent(String postcode, Trade trade, String jobTypeId, String budget, String timing, String intent) throws Exception {
		RestDomainXMLBeanUser user = createRandomNewHO();
		LOGGER.info(postcode + " " + trade + " " + jobTypeId + " " + budget + " " + intent + " " + user);
		APIJob jobToSubmit = createJob(postcode, trade, jobTypeId, budget, user, null, timing, intent);
		return postAJob(jobToSubmit);
	}

	public APIJob submitJobForSpecifiedUser(String firstName, 
											 String lastName, 
											 String username, 
											 String postcode, 
											 Trade trade, 
											 String jobTypeId, 
											 String budgetCode, 
											 Integer reservedTradesmanUserId, 
											 String timing, 
											 String intent)
			         throws Exception {
		
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = prepareJob(user, postcode, Trade.LOCKSMITHS, SkillTypeIds.LOCKSMITH_JOB_TYPE, "LT_100", null, "URGENTLY", "READY_TO_HIRE");

		return postAJob(jobToSubmit);
	}
	
	public APIJob submitLocksmithJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = prepareJob(user, postcode, Trade.LOCKSMITHS, SkillTypeIds.LOCKSMITH_JOB_TYPE, "LT_100", null, "URGENTLY", "READY_TO_HIRE");
		return postAJob(jobToSubmit);		
	}
	
	public APIJob submitLocksmithJobForGivenUser(String firstName, String lastName, String username, String postcode, String timing, String intent) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = prepareJob(user, postcode, Trade.LOCKSMITHS, SkillTypeIds.LOCKSMITH_JOB_TYPE, "LT_100", null, timing, intent);
		return postAJob(jobToSubmit);
	}
	
	public APIJob submitPlumbingJobForNewUser(String postcode) throws Exception {
		return submitJobForNewUser(postcode, Trade.PLUMBER, SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE);
	}

	public APIJob submitPlumbingJobForNewUserNoWaitForQualify(String postcode) throws Exception {
		RestDomainXMLBeanUser user = createRandomNewHO();
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.PLUMBER, SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE, user);
		return postAJobNoWaitForQualify(jobToSubmit);
	}
	
	public APIJob submitVeryExpensivePlumbingJobForExistingUserNoWaitForQualify(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createVeryExpensiveJob(postcode, Trade.PLUMBER, SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE, user);
		return postAJobNoWaitForQualify(jobToSubmit);
	}

	/**
	 * Posts a "plumber -> bath installation" job using user details passed in.
	 * 
	 * @param postcode
	 *            Postcode of job
	 * @return The job which has been submitted.
	 * @throws Exception
	 *             If the received status is not 200
	 */
	public APIJob submitPlumbingJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.PLUMBER, "17"/*PLUMBER_BATHINSTALL_JOB_TYPE*/, user);

		return postAJob(jobToSubmit);
	}
	public APIJob submitPlumbingJobForGivenUserWhereSpecType18(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.PLUMBER, "18"/*PLUMBER_BATHINSTALL_JOB_TYPE*/, user);
		
		return postAJob(jobToSubmit);
	}

	public APIJob submitGasBoilerJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.PLUMBER, SkillTypeIds.GAS_BOILERS_JOB_TYPE, user);

		return postAJob(jobToSubmit);
	}

	public APIJob submitGardeningJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.GARDENER, SkillTypeIds.GARDENER_JOBTYPE_ONE, user);

		return postAJob(jobToSubmit);
	}
	
	public APIJob submitChimneyBuildingJob(String postcode) throws Exception {
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.BUILDER, SkillTypeIds.CHIMNEY_BUILDING_TYPE);
		return postAJob(jobToSubmit);
	}

	public APIJob submitChimneyBuildingJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.BUILDER, SkillTypeIds.CHIMNEY_BUILDING_TYPE, user);
		return postAJob(jobToSubmit);
	}
	
	public APIJob submitChimneyBuildingJobForNewUser(String postcode) throws Exception {
		return submitJobForNewUser(postcode, Trade.BUILDER, SkillTypeIds.CHIMNEY_BUILDING_TYPE);
	}

	public APIJob submitChimneyBuildingJobForGivenUserNotWaitForQualify(String firstName, String lastName, String username, String postcode)
			throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.BUILDER, SkillTypeIds.CHIMNEY_BUILDING_TYPE, user);
		return postAJobNoWaitForQualify(jobToSubmit);
	}

	public APIJob submitMetalWorkerJobForGivenUser(String firstName, String lastName, String username, String postcode) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJob(postcode, Trade.METALWORKER, SkillTypeIds.METAL_FENCING_JOB_TYPE, user);

		return postAJob(jobToSubmit);
	}
	
	public APIJob submitMetalWorkerJobForNewUser(String postcode) throws Exception {
		return submitJobForNewUser(postcode, Trade.METALWORKER, SkillTypeIds.METAL_FENCING_JOB_TYPE);
	}
	
	
	public APIJob submitJobForNewUser(String postcode, Trade trade, String skillId) throws Exception {
		RestDomainXMLBeanUser user = createRandomNewHO();
		APIJob jobToSubmit = createInexpensiveJob(postcode, trade, skillId, user);
		return postAJob(jobToSubmit);
	}
	
	private RestDomainXMLBeanUser createRandomNewHO() {
		String username = new UniqueEmailAddressGenerator().generateUniqueEmailAddress();
		String customerMobile = "07" + RandomStringUtils.randomNumeric(9);
		RestDomainXMLBeanUser user = createUser("Test", "User", customerMobile, username);
		return user;
	}

	public APIJob submitMetalWorkerJobForGivenUserWithReservedTMUserId(String firstName, String lastName, String username, String postcode,
			Integer reservedTMUserId) throws Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, CUSTOMER_MOBILE, username);
		APIJob jobToSubmit = createInexpensiveJobWithReservedTMUserId(postcode, Trade.METALWORKER, SkillTypeIds.METAL_FENCING_JOB_TYPE, user, reservedTMUserId);

		return postAJob(jobToSubmit);
	}

	public APIJob submitJob(String postcode, Trade trade, String jobTypeId, Budget budget) throws Exception {
		LOGGER.info(postcode + " " + trade + " " + jobTypeId + " " + budget.getBudget());
		return submitJob(postcode, trade, jobTypeId, budget, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}
	
	public APIJob submitJob(String postcode, Trade trade, String jobTypeId, Budget budget, String timing, String intent) throws Exception {
		RestDomainXMLBeanUser user = createRandomNewHO();
		APIJob jobToSubmit = createJob(postcode, trade, jobTypeId, budget.getBudget(), user, null, timing, intent);
		return postAJob(jobToSubmit);
	}

	public APIJob submitJob(String firstName, String lastName, String email, String mobile, Trade trade, String jobTypeId, Budget budget,
			String postCode, String timing, String intent) throws UnsupportedEncodingException, Exception {
		RestDomainXMLBeanUser user = createUser(firstName, lastName, mobile, email);
		APIJob jobToSubmit = createJob(postCode, trade, jobTypeId, budget.getBudget(), user, null, timing, intent);

		jobToSubmit.getUser().setEmail(email);
		jobToSubmit.getUser().setMobilePhone(mobile);
		return postAJob(jobToSubmit);
	}

	public HttpResponse submitAJobForGivenUserWithNoWait(String username, String password, String jobTypeId, String mobile, String postCode, String budget, String timing, String intent) throws Exception {
		RestDomainXMLBeanUser user = userRetriever.getUser(username, password);
		String name = user.getFirstName() + " " + user.getLastName();
		String mobilePhone = mobile == null ? user.getMobilePhone() : mobile;
		String jobXml = getXmlForCreatingJob(jobTypeId, "Test job submitted by " + name + ". Timestamp: " + getQualifiableDateTime() + ". Postcode is " + postCode,
				budget, postCode, true, user.getFirstName(), user.getLastName(), username, mobilePhone, null, timing, intent);
		return postAJobNoWaitForQualify(jobXml);
	}

   /*
	* Note it is necessary to give a somewhat convoluted date time so that the job auto-qualifies.
	* If you use a more normal timestamp, it will be thought to be a phone number and have to be qualified manually.
	*/
	private String getQualifiableDateTime() {
		
		final Date date = new Date();
		final DateFormat dfDate = new SimpleDateFormat("EEE, MMM dd");
		final DateFormat dfHours = new SimpleDateFormat("HH");
		final DateFormat dfMins = new SimpleDateFormat("mm");
		final DateFormat dfDays = new SimpleDateFormat("ss");
		
		String dateTimeString = dfDate.format(date)+" - "+dfHours.format(date)+" hours, "+dfMins.format(date)+" mins, "+dfDays.format(date)+" seconds";

		return dateTimeString;
	}

	public HttpResponse submitAJobInternalPaintingDecoratingForGivenUserWithNoWait(String username, String password, String jobTypeId, String mobile,
			String postCode) throws Exception {
		RestDomainXMLBeanUser user = userRetriever.getUser(username, password);
		String name = user.getFirstName() + " " + user.getLastName();
		String mobilePhone = mobile == null ? user.getMobilePhone() : mobile;
		String jobXml = getXmlForCreatingJobInternalPaintingDecorating(jobTypeId, "Test job submitted by " + name + ". Timestamp: " + getQualifiableDateTime()
				+ ". Postcode is " + postCode, "RANGE_500_1000", postCode, true, user.getFirstName(), user.getLastName(), username, mobilePhone, null);
		return postAnInternalPaintingDecoratingJobNoWaitForQualify(jobXml);
	}
	
	public String getJobStatus(String userId, String jobRef, String agentUserName, String agentPassword) throws Exception {
		XmlUtils xmlUtils = new XmlUtils();
		HttpGet jobInfoGet = requestCreator.createGetRequestForUri("/api/v1/homeowner/" + userId + "/job/" + jobRef);
		requestCreator.assignDefaultAuthenticationHeader(jobInfoGet, agentUserName, agentPassword);
		HttpResponse response = requestExecutor.execute(jobInfoGet);
		int responseCode = response.getStatusLine().getStatusCode();
		if (responseCode != HttpStatus.SC_OK) {
			throw new IllegalStateException("Could not get job information after submission. Status was " + responseCode);
		}
		final String responseBody = new ResponseContentUnwrapper().unwrapContentAsString(response);
		Document doc = xmlUtils.getDocument(responseBody);
		return xmlUtils.asString(doc, "jobInformationPrivate/status");
	}
	
	public String getJobStatus(String userId, String jobRef) throws Exception {
		return getJobStatus(userId, jobRef, APIAccessConstants.AGENT_USERNAME, APIAccessConstants.AGENT_PASSWORD);
	}

	public APIJob postAJobNoWaitForQualify(APIJob jobToSubmit) throws Exception {

		String xml = createJobDetailsXml(jobToSubmit);

		HttpResponse response = postAJobNoWaitForQualify(xml);

		Header tokenHeader = response.getFirstHeader("token");
		Document jobDoc = this.httpResponseUtils.documentFromResponseBody(response);
		Document tokenDoc = null;
		
		if (tokenHeader != null) {
			String token = tokenHeader.getValue();
			
			if (token != null) {
				String tokenUri = "/api/v2/homeowner/credentials/" + token;
				System.out.println("HEADER=" + tokenHeader);

				HttpUriRequest request = requestCreator.createGetRequestForUri(tokenUri, testContext.getAccessKey(), testContext.getAccessKeyId());

				HttpResponse tokenResponse = requestExecutor.execute(request);
				tokenDoc = this.httpResponseUtils.documentFromResponseBody(tokenResponse);
			} 
		}
		
		APIJob job = getJobFromDocuments(jobDoc, tokenDoc);

		return job;
	}

	private HttpResponse postAJobNoWaitForQualify(String jobXml) throws Exception {
		String uriForJobSubmission = "/api/v2/homeowner/jobs";
		HttpPost submitJobHttpRequest = requestCreator.createPostRequestForUri(uriForJobSubmission);
		HttpEntity entity = new StringEntity(jobXml);
		submitJobHttpRequest.setEntity(entity);

		HttpResponse response = requestExecutor.execute(submitJobHttpRequest);
		
		return response;
	}

	private HttpResponse postAnInternalPaintingDecoratingJobNoWaitForQualify(String jobXml) throws Exception {
		String uriForJobSubmission = "/api/v2/homeowner/jobs/internal_painting_decorating";
		HttpPost submitJobHttpRequest = requestCreator.createPostRequestForUri(uriForJobSubmission);
		HttpEntity entity = new StringEntity(jobXml);
		submitJobHttpRequest.setEntity(entity);

		HttpResponse response = requestExecutor.execute(submitJobHttpRequest);
		return response;
	}

	private APIJob getJobFromDocuments(Document jobDoc, Document tokenDoc) throws Exception {

		RestDomainXMLBeanUser user = new RestDomainXMLBeanUser();
		String encryptionKey = testContext.getAccessKey().substring(0, 16);

		System.out.println(this.xmlDocUtils.formatDocument(jobDoc));
		
		if (tokenDoc != null) {
			System.out.println(this.xmlDocUtils.formatDocument(tokenDoc));
			String decryptedPassword = AESEncryption.decrypt(xmlUtils.asString(tokenDoc, "userCredentials/encryptedHashedPassword"), encryptionKey);
			user.setEmail(xmlUtils.asString(tokenDoc, "userCredentials/userName"));
			user.setPassword(decryptedPassword);
		}
		user.setId(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/userRef"));
		user.setFirstName(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/firstName"));
		user.setLastName(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/lastName"));
		user.setMobilePhone(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/mobilePhone"));
		user.setSubscribedToNewsletter(Boolean.getBoolean(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/subscribedToNewsletter")));

		APIJob job = new APIJob();
		job.setAgreedToTandC(Boolean.getBoolean(xmlUtils.asString(jobDoc, "jobDetails/agreedToTandC")));
		job.setDescription(xmlUtils.asString(jobDoc, "jobDetails/description"));
		job.setId(xmlUtils.asString(jobDoc, "jobDetails/jobRef"));
		job.setJobTypeId(xmlUtils.asString(jobDoc, "jobDetails/jobTypeId"));
		
		// This is a bit odd - it's not an ID it's a code
		job.setJobBudgetId(xmlUtils.asString(jobDoc, "jobDetails/jobBudgetCode"));
		
		job.setTiming(xmlUtils.asString(jobDoc, "jobDetails/timing"));
		job.setIntent(xmlUtils.asString(jobDoc, "jobDetails/homeownerIntent"));
		job.setPostcode(xmlUtils.asString(jobDoc, "jobDetails/postCode"));
		job.setSummary(xmlUtils.asString(jobDoc, "jobDetails/description"));
		job.setThirdPartyMarketingOptIn(Boolean.getBoolean(xmlUtils.asString(jobDoc, "jobDetails/homeownerDetails/thirdPartyMarketingOptIn")));
		job.setUser(user);

		return job;
	}

	private String createJobDetailsXml(APIJob jobToSubmit) {

		return getXmlForCreatingJob(jobToSubmit.getJobTypeId(), jobToSubmit.getDescription(), jobToSubmit.getJobBudgetId(), jobToSubmit.getPostcode(), true,
				jobToSubmit.getUser().getFirstName(), jobToSubmit.getUser().getLastName(), jobToSubmit.getUser().getEmail(), jobToSubmit.getUser()
						.getMobilePhone(), jobToSubmit.getReservedTradesmanUserId(), jobToSubmit.getTiming(), jobToSubmit.getIntent());
	}

	private String getXmlForCreatingJob(String jobTypeId, String description, String jobBudgetCode, String postCode, boolean agreedTandC, String firstName,
			String lastName, String email, String mobilePhone, Integer reservedTradesmanUserId, String timing, String intent) {

		StringBuilder xml = new StringBuilder();
		xml.append("<jobDetails>");
		xml.append("<jobTypeId>" + jobTypeId + "</jobTypeId>");
		xml.append("<description>" + description + "</description>");
		xml.append("<jobBudgetCode>" + jobBudgetCode + "</jobBudgetCode>");
		xml.append("<postCode>" + postCode + "</postCode>");
		xml.append("<agreedToTandC>" + agreedTandC + "</agreedToTandC>");
		if (reservedTradesmanUserId != null)
			xml.append("<reservedTradesmanUserId>" + reservedTradesmanUserId + "</reservedTradesmanUserId>");
		xml.append("<homeownerDetails>");
		xml.append("<firstName>" + firstName + "</firstName>");
		xml.append("<lastName>" + lastName + "</lastName>");
		xml.append("<email>" + email + "</email>");
		xml.append("<mobilePhone>" + mobilePhone + "</mobilePhone>");
		xml.append("</homeownerDetails>");
		if (timing != null) {
			xml.append("<timing>" + timing + "</timing>");
		}
		if (intent != null) {
			xml.append("<homeownerIntent>" + intent + "</homeownerIntent>");
		}
	
		xml.append("</jobDetails>");

		return xml.toString();
	}

	private String getXmlForCreatingJobInternalPaintingDecorating(String jobTypeId, String description, String jobBudgetCode, String postCode,
			boolean agreedTandC, String firstName, String lastName, String email, String mobilePhone, Integer reservedTradesmanUserId) {

		StringBuilder xml = new StringBuilder();
		xml.append("<jobDetailsForJobInternalPaintingDecorating>");
		xml.append("<jobTypeId>" + jobTypeId + "</jobTypeId>");
		xml.append("<description>" + description + "</description>");
		xml.append("<jobBudgetCode>" + jobBudgetCode + "</jobBudgetCode>");
		xml.append("<postCode>" + postCode + "</postCode>");
		xml.append("<agreedToTandC>" + agreedTandC + "</agreedToTandC>");
		if (reservedTradesmanUserId != null)
			xml.append("<reservedTradesmanUserId>" + reservedTradesmanUserId + "</reservedTradesmanUserId>");
		xml.append("<homeownerDetails>");
		xml.append("<firstName>" + firstName + "</firstName>");
		xml.append("<lastName>" + lastName + "</lastName>");
		xml.append("<email>" + email + "</email>");
		xml.append("<mobilePhone>" + mobilePhone + "</mobilePhone>");
		xml.append("</homeownerDetails>");
		xml.append("<internalPaintingDecoratingSpecificDetails><timeframeCode>ASAP</timeframeCode></internalPaintingDecoratingSpecificDetails>");
		xml.append("</jobDetailsForJobInternalPaintingDecorating>");

		return xml.toString();
	}

	private APIJob postAJob(APIJob jobToSubmit) throws Exception {
		
		APIJob job = this.postAJobNoWaitForQualify(jobToSubmit);
		waitForQualification(job.getUser().getId(), job.getId(), SECONDS_TO_WAIT_FOR_JOB_SUBMISSION);
		return job;
	}

	public void waitForQualification(String homeownerId, String jobRef, int secondsToWaitForQualification) throws InterruptedException, Exception {
		waitForQualification(homeownerId, jobRef, secondsToWaitForQualification, APIAccessConstants.AGENT_USERNAME, APIAccessConstants.AGENT_PASSWORD);
	}
	
	public void waitForQualification(String homeownerId, String jobRef, int secondsToWaitForQualification, String agentUserName, String agentPassword) throws InterruptedException, Exception {
		long giveUpTime = System.currentTimeMillis() + (secondsToWaitForQualification * 1000);
		String status = "";

		while (System.currentTimeMillis() < giveUpTime && !status.equals(REQUESTING_STATUS)) {
			System.out.println("Milliseconds until we give up " + (giveUpTime - System.currentTimeMillis()));
			Thread.sleep(SECONDS_PER_POLL * 1000);
			status = getJobStatus(homeownerId, jobRef, agentUserName, agentPassword);
			System.out.println("Waiting for qualification for jobRef=" + jobRef + " for HO ID=" + homeownerId + " . Current status: " + status);
		}

		if (!status.equals(REQUESTING_STATUS)) {
			throw new IllegalStateException("status was still " + status + " after " + secondsToWaitForQualification + " seconds.");
		}
	}
	
	@Deprecated
	private APIJob createJobWithReservedTMId(String postcode, Trade trade, String jobTypeId, String budgetCode, RestDomainXMLBeanUser user, Integer reservedTradesmanUserId, String timing, String intent)
					throws UnsupportedEncodingException {
			
		return prepareJob(user, postcode, trade, jobTypeId, budgetCode, reservedTradesmanUserId, timing, intent);
	}



	private APIJob createJob(String postcode, Trade trade, String jobTypeId, String budgetCode, RestDomainXMLBeanUser user, Integer reservedTradesmanUserId, String timing, String intent)
			throws UnsupportedEncodingException {
		APIJob job = createJobWithReservedTMId(postcode, trade, jobTypeId, budgetCode, user, reservedTradesmanUserId, timing, intent);
		job.setUser(user);
		return job;
	}

	@Deprecated
	private APIJob createInexpensiveJob(String postcode, Trade trade, String jobTypeId) throws UnsupportedEncodingException {
		return createJobWithReservedTMId(postcode, trade, jobTypeId, "RANGE_500_1000", createEliseCross(), null, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}

	private APIJob createInexpensiveJob(String postcode, Trade trade, String jobTypeId, RestDomainXMLBeanUser user) throws UnsupportedEncodingException {
		return createJob(postcode, trade, jobTypeId, "RANGE_500_1000", user, null, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}

	@Deprecated
	private APIJob createInexpensiveJobWithReservedTMUserId(String postcode, Trade trade, String jobTypeId, RestDomainXMLBeanUser user, Integer reservedTMUserId)
			throws UnsupportedEncodingException {
		return createJobWithReservedTMId(postcode, trade, jobTypeId, "RANGE_500_1000", user, reservedTMUserId, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}

	private APIJob createVeryExpensiveJob(String postcode, Trade trade, String jobTypeId, RestDomainXMLBeanUser user) throws UnsupportedEncodingException {
		return createJob(postcode, trade, jobTypeId, "GT_30000", user, null, URGENTLY_TIMING, READY_TO_HIRE_INTENT);
	}

	public APIJob submitJob(Trade trade, RestDomainXMLBeanUser user, String postCode) throws UnsupportedEncodingException {
		final String jobTypeId = this.getDefaultJobTypeIdFor(trade);
		final APIJob job = this.createInexpensiveJob(postCode, trade, jobTypeId, user);

		try {
			final APIJob postedJob = this.postAJob(job);
			return postedJob;
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	private String getDefaultJobTypeIdFor(Trade trade) {
		// return trade.getDefaultJobTypeId();
		switch (trade) {
		case PLUMBER: {
			return SkillTypeIds.PLUMBER_BATHINSTALL_JOB_TYPE;
		}
		case BUILDER: {
			return SkillTypeIds.CHIMNEY_BUILDING_TYPE;
		}
		case METALWORKER: {
			return SkillTypeIds.METAL_FENCING_JOB_TYPE;
		}
		case SPECIALIST: {
			return SkillTypeIds.SPECIALIST_JOBTYPE_ONE;
		}
		case GARDENER: {
			return SkillTypeIds.GARDENER_JOBTYPE_ONE;
		}
		default: {
			throw new UnsupportedOperationException("Unsupported Trade: " + trade);
		}
		}
	}

	public APIJob submitJobForExistingUser(final Trade trade, final String postCode) throws Exception {
		final String jobTypeId = getDefaultJobTypeIdFor(trade);
		final APIJob jobToSubmit = createInexpensiveJob(postCode, trade, jobTypeId);
		final APIJob submittedJob = postAJob(jobToSubmit);
		return submittedJob;
	}
	

	@Deprecated
	private RestDomainXMLBeanUser createEliseCross() {
		
		return createUser("Cross", "Elise", CUSTOMER_MOBILE, CUSTOMER_USERNAME);
	}
	
	private RestDomainXMLBeanUser createUser(String firstName, String lastName, String mobile, String email) {

		RestDomainXMLBeanUser user = new RestDomainXMLBeanUser();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMobilePhone(mobile);
		return user;
	}
	
	private APIJob prepareJob(RestDomainXMLBeanUser user, 
			                   String postcode, 
			                   Trade trade, 
			                   String jobTypeId, 
			                   String budgetCode, 
			                   Integer reservedTradesmanUserId, 
			                   String timing, 
			                   String intent)
			throws UnsupportedEncodingException {

		APIJob job = new APIJob();
		job.setAgreedToTandC(true);
		final String tradeCode = trade.getTradeCode();
		job.setDescription("Description for job. tradeId is " + tradeCode + " jobTypeId is " + jobTypeId);
		job.setTradeId(tradeCode);
		job.setSummary(SUMMARY_FOR_TEST_JOB + Calendar.getInstance().get(Calendar.MILLISECOND));
		job.setJobTypeId(jobTypeId);
		job.setJobStartDateId("TWO_FOUR_MONTHS");
		job.setPostcode(postcode);
		job.setJobBudgetId(budgetCode);
		job.setTiming(timing);
		job.setIntent(intent);
		job.setUser(user);
		job.setReservedTradesmanUserId(reservedTradesmanUserId);
		return job;
	}
	
}