package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class TwitterIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String twitterID = ConvertJson.getStringValue(unoUserJson, "twitterID");

		if (twitterID != null && !"".equals(twitterID)) {

			String url = twitterID;
			if (!twitterID.startsWith("http://")) {

				url = "http://www.twitter.com/" + twitterID;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/TwitterIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/TwitterIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'></a>");
			}
		}

		return icon;
	}
}
