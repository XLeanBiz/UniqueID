package co.uniqueid.client.groups.contacts;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.GetUniqueID;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ContactPhoto extends HorizontalPanel {

	public ContactPhoto(final JSONObject unoUserJson) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GetUniqueID.get(unoUserJson);
			}
		};

		String entityName = ConvertJson.getStringValue(unoUserJson,
				"entityName");

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='35px' height='35px' title='"
					+ entityName + "'></a>");
			image.addClickHandler(clickHandler);
			this.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>"
				+ entityName + "</a></font>");
		name.addClickHandler(clickHandler);
		this.add(name);
	}
}
