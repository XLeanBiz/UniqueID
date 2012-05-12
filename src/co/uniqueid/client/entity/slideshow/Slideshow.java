package co.uniqueid.client.entity.slideshow;

import java.util.ArrayList;
import java.util.List;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;

public class Slideshow {

	public static final AbsolutePanel panelImage = new AbsolutePanel();

	public static final List<JSONObject> entities = new ArrayList<JSONObject>();

	public Slideshow() {

		panelImage.setSize("200px", "200px");

		final Image image = new Image();
		image.setSize("200px", "200px");
		panelImage.add(image, 0, 0);

		final HTML name = new HTML();
		panelImage.add(name, 10, 150);

		Timer timer = new Timer() {
			int index = 0;

			public void run() {

				if ((entities.size()) == index) {
					index = 0;
				}

				String entityImage = ConvertJson.convertToString(entities.get(
						index).get("image"));

				String entityName = ConvertJson.convertToString(entities.get(
						index).get("entityName"));

				String twitterID = ConvertJson.convertToString(entities.get(
						index).get("twitterID"));

				String nameShow = "<br>" + entityName;
				if (twitterID != null && twitterID.length() > 0) {

					nameShow = "@" + twitterID + "<br>" + entityName;
				}

				if (entityImage == null || entityImage.length() == 0) {
					image.setVisible(false);
				} else {

					image.setVisible(true);
					image.setUrl(entityImage);
				}

				name.setHTML("<b><font style='background:white'>" + nameShow
						+ "</b>");

				index++;

			}
		};
		timer.scheduleRepeating(2000);

	}

	public static void addEntity(final JSONObject entityJson) {

		entities.add(entityJson);
	}

}
