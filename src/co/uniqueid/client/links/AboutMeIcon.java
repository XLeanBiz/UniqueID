package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class AboutMeIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String aboutme = ConvertJson.getStringValue(unoUserJson, "aboutmeURL");

		if (aboutme != null && !"".equals(aboutme)) {

			String url = aboutme;
			if (!aboutme.startsWith("http://")) {

				url = "http://about.me/" + aboutme;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/aboutme.png' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");

		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/aboutmeCrossed.png' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'></a>");
			}
		}

		return icon;
	}
}
