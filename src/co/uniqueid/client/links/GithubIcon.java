package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class GithubIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String githubLogin = ConvertJson.getStringValue(unoUserJson,
				"githubLogin");

		if (githubLogin != null) {

			String url = githubLogin;
			if (!githubLogin.startsWith("http://")) {

				url = "http://www.github.com/" + githubLogin;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/github-icon.png' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/github-iconCrossed.png' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px'></a>");
			}
		}

		return icon;
	}
}
