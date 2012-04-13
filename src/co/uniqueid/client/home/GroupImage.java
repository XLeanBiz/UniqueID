package co.uniqueid.client.home;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.Utilities.UseTracking;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GroupImage extends VerticalPanel {

	public GroupImage(final JSONObject unoUserJson) {

		this.setSpacing(5);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		final String groupUniqueID = ConvertJson.getStringValue(unoUserJson,
				"ID");

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName() + "#" + groupUniqueID);

				Location.assign(GWT.getHostPageBaseURL() + "?ID="
						+ groupUniqueID);
			}
		};

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='90px'></a>");
			image.addClickHandler(clickHandler);
			this.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>"
				+ ConvertJson.getStringValue(unoUserJson, "entityName")
				+ "</a></font>");
		name.setWidth("150px");
		name.addClickHandler(clickHandler);
		this.add(name);
	}
}
