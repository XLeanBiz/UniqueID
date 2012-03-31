package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.popup.EditInfoPopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class GithubIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String githubLogin = ConvertJson.getStringValue(unoUserJson,
				"githubLogin");

		if (githubLogin != null && !"".equals(githubLogin)) {

			String url = githubLogin;
			if (!githubLogin.startsWith("http://")) {

				url = "http://www.github.com/" + githubLogin;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/github-icon.png' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px' title='Github'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/github-iconCrossed.png' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px' title='Github'></a>");
				
				icon.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						EditInfoPopup popup = new EditInfoPopup(unoUserJson,
								"githubLogin", "<a href='http://github.com' target='_blank'>Github</a> ID");
						popup.show();
					}
				});
			}
		}

		return icon;
	}
}
