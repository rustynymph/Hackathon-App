// Disaster Relief -- Tsunami!
// 11/8 Hackathon

import java.io.IOException;
import javax.servlet.Requestdispatcher;
import javax.servlet.ServletException;
import Earthquake.java

@SupressWarnings("Serial")
public class TestServlet extends HttpServlet {

	public void doGet(HttpServiceRequest req, HttpServletResponse resp) throws IOException,
 	resp.setContentType("application/json");

 	JSONArray array = new JSONArray();

 	try {
 		Earthquakes[] eqArray = Earthquake.earthquakes();
		for(int i = 0; i < eqArray.length(); i++){
 			array.put(eqArray[i].toJson());
 		}
	}

}
