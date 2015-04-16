package edu.cmu.oneshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleExample {
	public static void main(String[] args) {
		Product prod1 = new Product();
		
		prod1.setDescription("Description test");
		prod1.setMajor(345);
		prod1.setMinor(234);
		prod1.setPrice(12.4);
		prod1.setImage("http://testing.com");
		prod1.setName("samsung");
		
		Product prod2 = new Product();
		
		prod2.setDescription("Description test prod2");
		prod2.setMajor(34);
		prod2.setMinor(23);
		prod2.setPrice(1.4);
		prod2.setImage("http://testing2.com");
		prod2.setName("Intel");
		
		List<Product> test = new ArrayList<Product>();
		test.add(prod1);
		test.add(prod2);
		JSONArray array = new JSONArray();
		
		Iterator<Product> ite = test.iterator();
		JSONObject obj2 = new JSONObject();
		while(ite.hasNext()){
			Product temp = ite.next();
			JSONObject obj = new JSONObject();
			obj.put("name", temp.getName());
			obj.put("description", temp.getDescription());
			obj.put("major",temp.getMajor());
			obj.put("minor", temp.getMinor());
			obj.put("price",temp.getPrice());
			obj.put("imageUrl", temp.getImage());
			
			array.add(obj);
		}
		obj2.put("products", array);
		

		
		/*try {

			FileWriter file = new FileWriter("c:\\test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}*/

		System.out.print(obj2.toJSONString());

	}

}