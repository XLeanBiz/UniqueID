package co.uniqueid.client.home.events;

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

public class EventImage extends VerticalPanel {

	public EventImage(final JSONObject eventJson, final String groupName) {

		this.setSpacing(5);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		final String eventUniqueID = ConvertJson
				.getStringValue(eventJson, "ID");

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName() + "#" + eventUniqueID);

				String parameter = "?ID=" + eventUniqueID;

				if (groupName != null) {

					parameter += "&group=" + groupName;
				}

				Location.assign(GWT.getHostPageBaseURL() + parameter);
			}
		};

		String imageURL = ConvertJson.getStringValue(eventJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='90px'></a>");
			image.addClickHandler(clickHandler);
			this.add(image);
		}

		String eventName = ConvertJson.getStringValue(eventJson, "entityName");

		if (groupName != null) {
			
			eventName += "<br>" + groupName;
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>" + eventName
				+ "</a></font>");
		name.setWidth("150px");
		name.addClickHandler(clickHandler);
		this.add(name);
	}
}
