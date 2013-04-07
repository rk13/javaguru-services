package lv.javagury.android;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/")
public class Application extends PackagesResourceConfig {

	public Application() {
		super("lv.javagury.android");

		final Map<String, Object> props = new HashMap<String, Object>();
		props.put("com.sun.jersey.api.json.POJOMappingFeature", true);
		setPropertiesAndFeatures(props);
	}
}
