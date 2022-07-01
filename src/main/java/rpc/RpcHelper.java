package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Item;

//to reduce code redundancy, use this class to handle all rpc parsing codes
public class RpcHelper {

	//write a JSONArray to http response
	public static void writeJSONArray(HttpServletResponse response, JSONArray array) throws IOException{
		response.setContentType("application/json");
		response.getWriter().print(array);
	};
	
	//write a JSONObject to http response
	public static void writeJSONObject(HttpServletResponse response, JSONObject obj) throws IOException{
		response.setContentType("application/json");
		response.getWriter().print(obj);
	};
	
	//parse a JSONObject from http request
	public static JSONObject readJSONObject(HttpServletRequest request) {
		StringBuilder sBuilder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				sBuilder.append(line);
			}
			return new JSONObject(sBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new JSONObject();
	}
	
	// Converts a list of Item objects to JSONArray.
	public static JSONArray getJSONArray(List<Item> items) {
		JSONArray result = new JSONArray();
		try {
			for (Item item : items) {
				result.put(item.toJSONObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
