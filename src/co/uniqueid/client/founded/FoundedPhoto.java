package co.uniqueid.client.founded;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class FoundedPhoto extends HTML {

	public FoundedPhoto(final JSONObject unoUserJson) {

		String image = ConvertJson.getStringValue(unoUserJson, "image");

		if (image != null) {

			this.setHTML("<a href='#'><img src='" + image
					+ "' border=0  height='60px' title='"
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

				InitializeUniqueIDAppllication.init(ConvertJson.getStringValue(
						unoUserJson, "ID"));
			}
		});
	}
}
