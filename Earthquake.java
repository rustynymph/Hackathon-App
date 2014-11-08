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

                index = new Random().nextInt(postQuakeMssg.length);
                String randOutcome = (postQuakeMssg[index]);

		try {
			coordinates.put("x", this.x);
			coordinates.put("y",this.y);
			json.put("coordinates",coordinates);
			json.put("magnitude",magnitude);
                        if (magnitude > 6) {
                            json.put("msg", randMsg);
                            json.put("outcome", randOutcome);
                        }else json.put("msg", "Whew! That wasn't so bad. The earthquake shook stuff up, but damage wasn't severe. What about aftershocks?");

                        if ((magnitude < 5.5) && (magnitude > 2)) json.put("msg", "Oh no! The earthquake wasn't too bad, but the aftershocks caused a tsunami which has taken out part of the coastline. Will you help with the cleanup effort?");

		} catch (JSONException e) {

		}
		return json;
	}
}
