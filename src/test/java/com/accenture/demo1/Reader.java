package com.accenture.demo1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Reader {
	
	private static int count = 1;
	private static HashMap<String,Object> hm = new HashMap<String,Object>();
	private static List<Map<String, Object>> staticObj = null;
	private static JSONArray jar = null;
	
	
	public static JSONArray returnResponse()
	{
		return jar;
	}
	public static JSONArray receiveResponse(Object obj)
	{
		if(jar == null)
		{
			jar = new JSONArray();
			jar.put(obj);
		}
		else
		{
			jar.put(obj);
		}
		System.out.println(jar);
		return jar;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static  List<Map<String, Object>> storeJson(Object response)
	{
		System.out.println("out");
		hm.put("key", response);
		staticObj = (List<Map<String, Object>>) hm;
		
			//hm.put("keu", response);
		
	
		
		/*
		 * else { staticObj.addAll((Collection<? extends Map<String, Object>>)
		 * response); }
		 */
		//hm.put("getR1", response);
		return staticObj;
	}
	public static  List<Map<String, Object>> returnJson()
	{
		return staticObj;
		
	}

	public static void writeFile(Object data, String fileName, String fileInput) throws IOException {
		
		String key = "selectQuery" + count;
		String fileInputFinal = fileName+fileInput;
		System.out.println(fileInputFinal);
		File file = new File(fileInputFinal);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			if (br.readLine() == null) {
				System.out.println("File is empty");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				JSONObject jsOutput = new JSONObject();
				jsOutput.put(key, data);
				writer.append(jsOutput.toString());
				System.out.println(writer);
				count = count + 1;
				writer.close();
			} else {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				BufferedReader br1 = new BufferedReader(new FileReader(file));

				String s = null;
				String message = new String();

				while ((s = br1.readLine()) != null) {
					message += s;
				}
				System.out.println(s);
				JSONObject jsOutput = new JSONObject();
				JSONObject object = new JSONObject(message);
				int len = object.length();
				len = len + 1;
				key = "selectQuery" + len;
				jsOutput.put(key, data);
				String data1 = jsOutput.toString();
				StringBuffer sb = new StringBuffer(message);
				StringBuffer sb1 = new StringBuffer(data1);
				sb.deleteCharAt(sb.length() - 1);
				sb1.deleteCharAt(0);
				sb.append(',');
				sb.append(sb1);
				BufferedWriter bs = Files.newBufferedWriter(file.toPath(), StandardOpenOption.TRUNCATE_EXISTING);
				writer.append(sb);
				count = count + 1;
				br1.close();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

