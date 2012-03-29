package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class FacebookIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String facebook = ConvertJson.getStringValue(unoUserJson,
				"facebookLogin");

		if (facebook != null) {

			String url = facebook;
			if (!facebook.startsWith("http://")) {

				url = "http://www.facebook.com/" + facebook;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/facebookIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/facebookIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'></a>");
			}
		}

		return icon;
	}
}
