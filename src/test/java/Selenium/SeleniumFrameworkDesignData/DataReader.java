package Selenium.SeleniumFrameworkDesignData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class DataReader {
	
	
	public   List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException 
	{
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
	    
		// string to hashmap jackson binder
		
		ObjectMapper Mapper = new ObjectMapper();
		List<HashMap<String, String>> data = Mapper.readValue(jsonContent, new TypeReference<List<HashMap<String , String>>>() {});		
		return data;
	}
	
	
	
	

}
