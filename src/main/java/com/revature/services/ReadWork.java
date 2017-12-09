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
//import com.revature.beans.Employee;
//
//public class ReadWork {
//	public static <Employee> List<Employee> parseJsonArray(String json,
//            Class<Employee> MyDao) 
//            throws IOException, ClassNotFoundException {
//				ObjectMapper mapper = new ObjectMapper();
//				Class<Employee[]> arrayClass = (Class<Employee[]>) Class.forName("[L" + MyDao.getName() + ";");
//				Employee[] objects = mapper.readValue(json, arrayClass);
//				
//	
//			try {
//				JsonFactory f = new JsonFactory();
//				List<Employee> lstUser = null;
//				JsonParser jp = f.createJsonParser(new File("C:\\maven\\user.json"));
//				TypeReference<List<Employee>> tRef = new TypeReference<List<Employee>>() {};
//				lstUser = mapper.readValue(jp, tRef);
//				for (Employee emp : lstUser) {
//					System.out.println(emp.toString());
//				}
//
//				} catch (JsonGenerationException a) {
//					a.printStackTrace();
//				} catch (JsonMappingException o) {
//					o.printStackTrace();
//				} catch (IOException i) {
//					i.printStackTrace();
//				}
//			
//	return Arrays.asList(objects);
//	}
//}
