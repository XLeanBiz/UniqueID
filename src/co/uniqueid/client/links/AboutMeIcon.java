package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.popup.EditInfoPopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
							+ "px' title='About Me'></a>");
			
			icon.setWidth("25px");

		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/aboutmeCrossed.png' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px' title='About Me'></a>");
				
				icon.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						EditInfoPopup popup = new EditInfoPopup(unoUserJson,
								"aboutmeURL", "URL about you");
						popup.show();
					}
				});
			}
		}

		return icon;
	}
}
