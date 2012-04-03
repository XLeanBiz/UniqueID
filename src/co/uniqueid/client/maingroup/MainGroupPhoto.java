package co.uniqueid.client.maingroup;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.GetUniqueID;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class MainGroupPhoto extends HTML {

	public MainGroupPhoto(final JSONObject unoUserJson, String imageHeight) {

		String image = ConvertJson.getStringValue(unoUserJson, "image");

		if (image != null && !"".equals(image)) {

			this.setHTML("<a href='#'><img src='" + image
					+ "' border=0  height='" + imageHeight + "px' title='"
					+ ConvertJson.getStringValue(unoUserJson, "entityName")
					+ "'></a>");
		} else {

			this.setHTML("<a href='#'>"
					+ ConvertJson.getStringValue(unoUserJson, "entityName")
					+ "</a>");
		}

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GetUniqueID.get(unoUserJson);
			}
		});
	}
}
