package keywords;

import java.io.FileInputStream;
import java.util.Properties;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ApplicationKeywords extends ValidationKeywords {
	
	
	public ApplicationKeywords() {
		String path =System.getProperty("user.dir")+"//src/test/resources/env.properties";
		prop=new Properties();
		envProp=new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
			String env=prop.getProperty("env")+".properties";
			path =System.getProperty("user.dir")+"//src/test/resources/"+env;
			fs = new FileInputStream(path);
			envProp.load(fs);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println();
		
		
	}	
	

	
	
	
	public void login() {
		
	}
	
	public void selectDateFromCalender() {
		
		
	}
	
	public void verifystockAdded() {
		
		
	}

}
