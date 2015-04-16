package edu.cmu.oneshop;

import java.io.IOException;
import java.net.URL;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

public class UploadServlet extends HttpServlet {

	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        /*Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("myFile");

        if (blobKeys == null || blobKeys.isEmpty()) {
            res.sendRedirect("/");
        } else {
            res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
        }*/
		
		/*URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
		// Fetch the image at the location given by the url query string parameter
		HTTPResponse fetchResponse = fetchService.fetch(new URL(req.getParameter("imageurl")));
		
		String fetchResponseContentType = null;
		
		for (HTTPHeader header : fetchResponse.getHeaders()) {
            // For each request header, check whether the name equals
            // "Content-Type"; if so, store the value of this header
            // in a member variable
            if (header.getName().equalsIgnoreCase("content-type")) {
            	fetchResponseContentType = header.getValue();
                break;
            }
        }*/
		
		//if(fetchResponseContentType != null){
			
			Product product = new Product();
	        product.setDescription(req.getParameter("description"));
	        product.setMajor(Integer.parseInt(req.getParameter("major")));
	        product.setMinor(Integer.parseInt(req.getParameter("minor")));
	        product.setPrice(Double.parseDouble(req.getParameter("price")));
			product.setImage(req.getParameter("imageurl"));
			product.setName(req.getParameter("name"));
			
			
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			try {
                // Store the image in App Engine's datastore
                pm.makePersistent(product);
            } finally {
                pm.close();
            }
			
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
	        view.forward(req, resp);
		//}
        
        
        
        
        
    }
}
