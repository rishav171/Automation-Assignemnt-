package util;

import java.util.Properties;



public class Configuration {
	
	public  String environment = "";
	public  Properties configdata;
	public  Properties acntData;
		
	public Configuration()
	{
		
		if(environment.equals("QA"))
		{
			configdata = PropertiesReader.ReadFunc("src/test/resources/configQA.properties");
			
		}
		else if(environment.equals("UAT"))
		{
			configdata = PropertiesReader.ReadFunc("src/test/resources/configUAT.properties");
			
		}
		else
		{
			configdata = PropertiesReader.ReadFunc("src/test/resources/configuration.properties");
			
		}
			
	}

}
