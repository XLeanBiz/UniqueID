package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class BlogIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String blogURL = ConvertJson.getStringValue(unoUserJson, "blogURL");

		if (blogURL != null) {

			icon = new HTML(
					"<a href='"
							+ blogURL
							+ "' target='_blank'><img src='images/BlogIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/BlogIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'></a>");
			}
		}

		return icon;
	}
}
