package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.popup.EditInfoPopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class LinkedinIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String linkedinID = ConvertJson.getStringValue(unoUserJson,
				"linkedinID");

		if (linkedinID != null && !"".equals(linkedinID)) {

			String url = linkedinID;
			if (!linkedinID.startsWith("http://")) {

				url = "http://www.linkedin.com/in/" + linkedinID;
			}

			icon = new HTML(
					"<a href='"
							+ url
							+ "' target='_blank'><img src='images/LinkedinIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px' title='LinkedIn'></a>");
		} else {

			if (crossedImage) {
				icon = new HTML(
						"<a href=#><img src='images/LinkedinIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px' title='LinkedIn'></a>");

				icon.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						EditInfoPopup popup = new EditInfoPopup(unoUserJson,
								"linkedinID", "<a href='http://linkedin.com' target='_blank'>LinkedIn</a> ID");
						popup.show();
					}
				});
			}
		}

		return icon;
	}
}
