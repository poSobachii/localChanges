package FBdickPlugin.Properties_Test.PropertiesItself;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
class AppConfig {

}
