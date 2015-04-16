package edu.cmu.oneshop;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ServeModel api = new ServeModel();
		int minor = Integer.parseInt(req.getParameter("minor"));
		System.out.println(minor);

		List<Product> products = api.getProduct(minor);
		System.out.println("I got the products");
		if (products.size() > 0) {
			resp.setContentType("text/xml;charset=ISO-8859-1");
			System.out.println("this is the:" + req.getParameter("type"));

			if (req.getParameter("type").equals("json")) {
				resp.getOutputStream().write(
						api.ListProductsToJSON(products).getBytes());
			} else if (req.getParameter("type").equals("xml")) {
				resp.getOutputStream().write(
						api.ListProductsToXML(products).getBytes());
			}

		} else {
			resp.setContentType("text/xml;charset=ISO-8859-1");
			resp.getOutputStream().write("I'm here".getBytes());

		}

	}

}
