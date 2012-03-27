package co.uniqueid.client.founded;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class FoundedPhoto extends HTML {

	public FoundedPhoto(final JSONObject unoUserJson) {

		this(ConvertJson.getStringValue(unoUserJson, "entityName"), ConvertJson
				.getStringValue(unoUserJson, "image"), ConvertJson
				.getStringValue(unoUserJson, "facebookLogin"));
	}

	public FoundedPhoto(final String name, final String image,
			final String facebookID) {

		if (image != null) {

			this.setHTML("<a href='http://uniqueid.co?search="
					+ facebookID + "' target='_blank'><img src='" + image
					+ "' border=0 width='60px' height='60px' title='" + name
					+ "'></a>");
		}
	}
}
