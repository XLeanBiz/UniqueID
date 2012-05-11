package co.uniqueid.client.entity.slideshow;

import java.util.ArrayList;
import java.util.List;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;

public class Slideshow {

	public static final Image image = new Image();

	public static final List<String> imageURLs = new ArrayList<String>();

	public Slideshow() {

		image.setSize("200px", "200px");

		Timer timer = new Timer() {
			int index = 0;

			public void run() {

				if ((imageURLs.size()) == index) {
					index = 0;
				}

				image.setUrl(imageURLs.get(index));
				index++;

			}
		};
		timer.scheduleRepeating(2000);

	}

	public static void addImageURL(final JSONObject entityJson) {

		String entityImage = ConvertJson.convertToString(entityJson
				.get("image"));

		imageURLs.add(entityImage);
	}

}
