package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class LinkedinIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String linkedinID = ConvertJson.getStringValue(unoUserJson,
				"linkedinID");

		if (linkedinID != null) {

			String url = linkedinID;
			if (!linkedinID.startsWith("http://")) {

				url = "http://www.linkedin.com/in/" + linkedinID;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/LinkedinIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");
		} else {

			if (crossedImage) {
				icon = new HTML(
						"<img src='images/LinkedinIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'>");
			}
		}

		return icon;
	}
}
