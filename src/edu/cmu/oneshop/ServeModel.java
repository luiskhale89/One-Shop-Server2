package edu.cmu.oneshop;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ServeModel {
	
	public List<Product> getProduct(int minor) {
		
		System.out.println("Enter the GetProducts");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		// Search for any Product object with the passed-in minor;

		Query query = pm.newQuery(Product.class, "minor == minorParam");
		query.declareParameters("int minorParam");
		System.out.println("Creates the query object");
		try {
			List<Product> results = (List<Product>) query.execute(minor);
			System.out.println("Creates the query object");
			if (results.size() > 0) {
				System.out.println("returned something");
				return results;
			}

		} finally {

			query.closeAll();
			pm.close();
		}
		return null;

	}

	public String ListProductsToXML(List<Product> products) {
		Iterator<Product> ite = products.iterator();
		StringBuffer xml = new StringBuffer();
		/*
		 * xml.append("<xml version=\"1.0\" encoding=\"ISO-8859-1\">");
		 * xml.append("<@ page contentType=\"text/xml;charset=ISO-8859-1\">");
		 * xml.append("<rsp stat=\"ok\">");
		 */
		xml.append("<products total =\"" + products.size() +"\""+ ">");
		while (ite.hasNext()) {
			Product temp = ite.next();
			xml.append("<product");
			xml.append(" id=\"" + temp.getId()+"\"");
			xml.append(" name=\"" + temp.getName()+"\"");
			xml.append(" image=\"" + temp.getImage()+"\"");
			xml.append(" description=\"" + temp.getDescription()+"\"");
			xml.append(" minor=\"" + temp.getMinor()+"\"");
			xml.append(" major=\"" + temp.getMajor()+"\"");
			xml.append(" price=\"" + temp.getPrice()+"\"");
			xml.append(" />");
		}
		xml.append("</products>");

		return xml.toString();

	}
	
	public String ListProductsToJSON(List<Product> products){
		Iterator<Product> ite = products.iterator();
		JSONObject obj2 = new JSONObject();
		JSONArray array = new JSONArray();
		while(ite.hasNext()){
			JSONObject obj = new JSONObject();
			Product temp = ite.next();
			obj.put("id",temp.getId());
			obj.put("name",temp.getName());
			obj.put("image", temp.getImage());
			obj.put("description", temp.getDescription());
			obj.put("minor", temp.getMinor());
			obj.put("major", temp.getMajor());
			obj.put("price",temp.getPrice());
			array.add(obj);
		}
		
		obj2.put("products",array);
		System.out.println(obj2.toJSONString());
		return obj2.toJSONString();
		
	}


}
