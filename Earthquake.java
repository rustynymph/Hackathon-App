import java.util.Random;
import java.lang.String;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class Earthquake extends Data {
	public static Earthquake[] earthquakes() {
		Earthquake[] earthquakes = new Earthquake[10];
		for (int i = 0; i < earthquakes.length; i++) {
			Random r = new Random();
			earthquakes[i] = Data.earthquake[r.nextInt(Data.earthquake.length)];
		}
		return earthquakes;
	}
	
	double x,y,magnitude;
	
	public Earthquake(double x, double y, double magnitude) {
		this.x = x;
		this.y = y;
		this.magnitude = magnitude;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		JSONObject coordinates = new JSONObject();

                int index = new Random().nextInt(msg.length);
                String randMsg = (msg[index]);

		try {
			coordinates.put("x", this.x);
			coordinates.put("y",this.y);
			json.put("coordinates",coordinates);
			json.put("magnitude",magnitude);
                        if (magnitude > 6) json.put("msg", randMsg);
		} catch (JSONException e) {
			
		}
		return json;
	}
}
