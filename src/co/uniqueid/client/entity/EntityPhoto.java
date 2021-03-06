package co.uniqueid.client.entity;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.edit.EditEntity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EntityPhoto extends VerticalPanel {

	public EntityPhoto(final JSONObject unoUserJson) {

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		ClickHandler click = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.vpMain.clear();
				InitializeUniqueIDAppllication.vpMain.add(new EditEntity(
						unoUserJson));
			}
		};

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null && !"".equals(imageURL)) {

			Image image = new Image(imageURL);
			image.setWidth("100px");
			image.addClickHandler(click);
			this.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href=#>"
				+ ConvertJson.getStringValue(unoUserJson, "entityName")
				+ "</a></font>");
		name.setWidth("100px");
		name.addClickHandler(click);
		this.add(name);
	}
}
