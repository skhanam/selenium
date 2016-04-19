package uk.co.ratedpeople;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientBuilderForTest {
	
	public HttpClient buildTestClient() {
		final HttpClient httpClient = new DefaultHttpClient();
		httpClient.getConnectionManager().getSchemeRegistry().register(buildHttpsScheme());
		return httpClient;
	}
	
	
	private Scheme buildHttpsScheme() {
		try {
			final SSLContext context = SSLContext.getInstance("SSL");
			context.init(null, new TrustManager[] { new EasyTrustManger() }, null);
			final SSLSocketFactory ssf = new SSLSocketFactory(context, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return new Scheme("https", 443, ssf);
		} catch (KeyManagementException e) {
			throw new IllegalStateException("Issue obtaining key ", e);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No SSL algorithm", e);
		}
	}
	
	private final class EasyTrustManger implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			// Oh, I am easy!
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			// Oh, I am easy!
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

}
