//package com.revature.services;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.catalina.User;
//import org.codehaus.jackson.JsonFactory;
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//
//import com.revature.beans.Application;
//
//public class ReadApps {
//	public static <Application> List<Application> parseJsonArray(String json,
//            Class<Application> MyDao) 
//            throws IOException, ClassNotFoundException {
//				ObjectMapper mapper = new ObjectMapper();
//				Class<Application[]> arrayClass = (Class<Application[]>) Class.forName("[L" + MyDao.getName() + ";");
//				Application[] objects = mapper.readValue(json, arrayClass);
//				
//				try {
//					JsonFactory f = new JsonFactory();
//					List<Application> lstUser = null;
//					JsonParser jp = f.createJsonParser(new File("C:\\maven\\user.json"));
//					TypeReference<List<Application>> tRef = new TypeReference<List<Application>>() {};
//					lstUser = mapper.readValue(jp, tRef);
//					for (Application app : lstUser) {
//						System.out.println(app.toString());
//					}
//
//				} catch (JsonGenerationException a) {
//					a.printStackTrace();
//				} catch (JsonMappingException e) {
//					e.printStackTrace();
//				} catch (IOException i) {
//					i.printStackTrace();
//				}
//				return Arrays.asList(objects);
//}
//}
