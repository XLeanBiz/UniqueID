package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.popup.EditInfoPopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class EmailIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String email = ConvertJson.getStringValue(unoUserJson, "email");

		if (email != null && !"".equals(email)) {

			icon = new HTML("<a href=\"mailto:" + email
					+ "\"><img src='images/email.jpg' border=0 width='"
					+ imageSize + "px' height='" + imageSize + "px' title='E-mail'></a>");
			
			icon.setWidth("25px");
			
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/emailCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px' title='E-mail'></a>");
				
				icon.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						EditInfoPopup popup = new EditInfoPopup(unoUserJson,
								"email", "E-mail");
						popup.show();
					}
				});
			}

		}

		return icon;
	}
}
