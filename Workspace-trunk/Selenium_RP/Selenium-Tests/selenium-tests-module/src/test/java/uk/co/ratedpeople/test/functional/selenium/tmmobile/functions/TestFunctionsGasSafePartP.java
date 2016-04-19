package uk.co.ratedpeople.test.functional.selenium.tmmobile.functions;

import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.openqa.selenium.WebDriver;

import uk.co.ratedpeople.TradesmanCertificatesResourceHelper;

public class TestFunctionsGasSafePartP {

	private TradesmanCertificatesResourceHelper tradesmanCertificatesResourceHelper;

	public TestFunctionsGasSafePartP(WebDriver webDriver) {
		tradesmanCertificatesResourceHelper = new TradesmanCertificatesResourceHelper();
	}

	// ---------- Gas / Part P Certificates -----

	public List<Integer> getListOfGasSafeCertificateIds(final String username, final String password) throws Exception {

		return tradesmanCertificatesResourceHelper.getListOfGasCertificationIds(username, password);
	}

	public List<Integer> getListOfPartPCertificateIds(final String username, final String password) throws Exception {

		return tradesmanCertificatesResourceHelper.getListOfPartPCertificateIds(username, password);
	}

	// required for initial release testing
	public HttpResponse addGasSafeCertification(final String username, final String password, final String certificateDetailsXml) throws Exception {
		HttpResponse response = tradesmanCertificatesResourceHelper.addGasSafeCertification(username, password, certificateDetailsXml);
		return response;
	}

	// required for initial release testing
	public HttpResponse addGasSafeCertificationV2(final String username, final String password, final String certificateDetailsXml) throws Exception {
		HttpResponse response = tradesmanCertificatesResourceHelper.addGasSafeCertificationV2(username, password, certificateDetailsXml);
		return response;
	}
	
	// required for initial release testing
	public HttpResponse deleteGasSafeCertification(final String certificationNumber, final String username, final String password) throws Exception {
		Integer certificationId = tradesmanCertificatesResourceHelper.getIdOfGasSafeCertificationNumber(certificationNumber, username, password);

		HttpResponse response = tradesmanCertificatesResourceHelper.deleteCertification(certificationId, username, password);
		return response;
	}

	public HttpResponse deleteGasSafeCertificationById(final Integer certificationId, final String username, final String password) throws Exception {

		HttpResponse response = tradesmanCertificatesResourceHelper.deleteCertification(certificationId, username, password);
		return response;
	}

	public HttpResponse addPartPCertification(final String username, final String password, final String certificateDetailsXml) throws Exception {

		HttpResponse response = tradesmanCertificatesResourceHelper.addPartPCertification(username, password, certificateDetailsXml);
		return response;
	}

	public HttpResponse deletePartPCertification(final String certificationNumber, final String username, final String password) throws Exception {

		Integer certificationId = tradesmanCertificatesResourceHelper.getIdOfPartPCertificationNumber(certificationNumber, username, password);

		HttpResponse response = tradesmanCertificatesResourceHelper.deleteCertification(certificationId, username, password);
		return response;
	}

	public HttpResponse deletePartPCertificationById(final Integer certificationId, final String username, final String password) throws Exception {

		HttpResponse response = tradesmanCertificatesResourceHelper.deleteCertification(certificationId, username, password);
		return response;
	}

	public String buildGasSafeCertificateDetailsXml(final String name, final String registrationNumber, final Date expirydate, final String username,
			final String password) throws Exception {

		return tradesmanCertificatesResourceHelper.createGasCertificationDetailsXml(name, registrationNumber, expirydate, username, password);
	}

	public String buildPartPCertificateDetailsXml(final String name, final String registrationNumber, final Date expirydate, final String certbodycode,
			final String username, final String password) throws Exception {

		return tradesmanCertificatesResourceHelper.createPartPCertificationDetailsXml(name, registrationNumber, expirydate, certbodycode, username, password);
	}
}
