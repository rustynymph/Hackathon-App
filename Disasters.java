import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class Disasters extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("application/json");
		
		JSONArray array = new JSONArray();
		
		Earthquake[] eqArray = Earthquake.earthquakes();
		for(int i = 0; i < eqArray.length; i++){
			array.put(eqArray[i].toJson());
		}
		
		PrintWriter out = resp.getWriter();
		String jString = array.toString();
		out.println(jString);
		out.close();
	}
	
}