package uk.co.ratedpeople;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Environment {

	/**
	 * Obtains the {@link List} of {@link PropertySource} Objects representing properties and configuration about the Environment.
	 */
	private static class EnvironmentPropertySourcesObtainer {
		private static class EnvironmentVariableNames {
			private static final String ENVIRONMENT_PROPERTIES_PATH = "ENVIRONMENT_PROPERTIES_PATH";
		}

		private static class EnvironmentFilePaths {
			static final String DEFAULT_ENVIRONMENT_PROPERTIES_PATH = "classpath:/uk/co/ratedpeople/environment/default.properties";
		}

		private static final Logger LOGGER = Logger.getLogger(Environment.EnvironmentPropertySourcesObtainer.class.getName());

		EnvironmentPropertySourcesObtainer() {
		}

		PropertySource[] readProperties() throws IOException {
			final List<PropertySource> list = this.readPropertiesAndBuildList();
			final PropertySource[] sources = list.toArray(new PropertySource[] {});
			return sources;
		}

		private List<PropertySource> readPropertiesAndBuildList() throws IOException {
			final List<PropertySource> sourceList = new ArrayList<PropertySource>();
			readAndAddCustomPropertiesIfSpecified(sourceList);
			readAndAddDefaultPropertiesTo(sourceList);
			return sourceList;
		}

		private void readAndAddDefaultPropertiesTo(final List<PropertySource> sourceList) throws IOException {
			final FilePropertySource defaultProperties = readDefaultProperties();
			sourceList.add(defaultProperties);
		}

		private FilePropertySource readDefaultProperties() throws IOException {
			final String defaultEnvironmentPropertiesPath = EnvironmentFilePaths.DEFAULT_ENVIRONMENT_PROPERTIES_PATH;
			final FilePropertySource defaultProperties = new FilePropertySource(defaultEnvironmentPropertiesPath);
			return defaultProperties;
		}

		private void readAndAddCustomPropertiesIfSpecified(final List<PropertySource> sources) throws IOException {
			final String customPropertiesPath = readCustomPropertiesPathFromSystemEnvironment();
			if (customPropertiesPath == null) {
				LOGGER.warning("Could not find shell/environment variable " + EnvironmentVariableNames.ENVIRONMENT_PROPERTIES_PATH
						+ ".  Falling back to default path: " + EnvironmentFilePaths.DEFAULT_ENVIRONMENT_PROPERTIES_PATH);
				return;
			}
			final FilePropertySource customProperties = new FilePropertySource(customPropertiesPath);
			sources.add(customProperties);
		}

		private String readCustomPropertiesPathFromSystemEnvironment() {
			final String customPropertiesPath = System.getenv(EnvironmentVariableNames.ENVIRONMENT_PROPERTIES_PATH);
			return customPropertiesPath;
		}
	}

	private static final Logger LOGGER = Logger.getLogger(Environment.class.getName());

	/**
	 * Creates an Environment from a system-wide property (environment/shell variable), with a fall-back in the event no such property can be derived.
	 */
	public static Environment getSystemEnvironmentWithDefault() throws IOException {
		final PropertySource[] sources = readProperties();
		LOGGER.log(Level.INFO, "Environment has: {0} Property Sources.", sources.length);
		final Environment environment = new Environment(sources);

		return environment;
	}

	private static PropertySource[] readProperties() throws IOException {
		final EnvironmentPropertySourcesObtainer obtainer = new EnvironmentPropertySourcesObtainer();
		final PropertySource[] sources = obtainer.readProperties();
		return sources;
	}

	private final PropertySource[] propertySources;
	
	public Environment(final LiteralMap<String, String> nameValuePairs) {
		this(new MapPropertySource(nameValuePairs));
	}

	public Environment(final PropertySource... propertySources) {
		if (propertySources.length == 0) {
			throw new IllegalArgumentException("Must provide at least one PropertySource");
		}

		this.propertySources = propertySources;
	}

	public String getProperty(final String propertyName) {
		
		final String propertyValue = System.getenv(propertyName);
		if (null != propertyValue) {
			return propertyValue;
		}
		
		for (final PropertySource propertySource : propertySources) {
			final String result = propertySource.getProperty(propertyName);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	public String getProperty(final String propertyName, final String defaultValue) {
		final String result = getProperty(propertyName);
		final String returnValue = result != null ? result : defaultValue;
		return returnValue;
	}
}
