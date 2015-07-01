package org.lemonPig.os.common;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class BeanUtils {
	public static String writeToJson(Object object) {
		ObjectMapper objectMapper=new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
}
