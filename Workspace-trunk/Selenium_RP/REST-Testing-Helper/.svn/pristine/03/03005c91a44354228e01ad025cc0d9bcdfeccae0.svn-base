package uk.co.ratedpeople;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * {@link PropertySource} implementation that reads the properties from a properties-file.
 */
public class FilePropertySource implements PropertySource {
	private Properties properties;

	public FilePropertySource(final String resourcePath) throws IOException {
		final Resource resource = new DefaultResourceLoader().getResource(resourcePath);

		if (!resource.exists()) {
			throw new IOException("No resource found at path " + resourcePath);
		}

		this.properties = new Properties();
		final InputStream resourceInputStream = resource.getInputStream();
		this.properties.load(resourceInputStream);
		resourceInputStream.close();
	}

	@Override
	public String getProperty(final String propertyName) {
		return this.properties.getProperty(propertyName);
	}

	@Override
	public String getProperty(final String propertyName, final String defaultValue) {
		final String readValue = this.getProperty(propertyName);
		final String returnValue = readValue != null ? readValue : defaultValue;
		return returnValue;
	}
}
