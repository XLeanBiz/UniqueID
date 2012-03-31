package co.uniqueid.client.links;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.popup.EditInfoPopup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class BlogIcon {

	public static HTML getIcon(final JSONObject unoUserJson,
			final String imageSize, boolean crossedImage) {

		HTML icon = null;

		String blogURL = ConvertJson.getStringValue(unoUserJson, "blogURL");

		if (blogURL != null && !"".equals(blogURL)) {

			icon = new HTML(
					"<a href='"
							+ blogURL
							+ "' target='_blank'><img src='images/BlogIcon.jpg' border=0 width='"
							+ imageSize + "px' height='" + imageSize
							+ "px' title='Blog'></a>");
		} else {

			if (crossedImage) {

				icon = new HTML(
						"<img src='images/BlogIconCrossed.jpg' border=0 width='"
								+ imageSize + "px' height='" + imageSize
								+ "px' title='Blog'></a>");
				
				icon.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {

						EditInfoPopup popup = new EditInfoPopup(unoUserJson,
								"blogURL", "Blog URL");
						popup.show();
					}
				});
			}
		}

		return icon;
	}
}
