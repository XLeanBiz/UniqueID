package co.uniqueid.client.groups;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class GroupLink extends HTML {

	public GroupLink(final JSONObject groupJson) {

		String groupName = ConvertJson.getStringValue(groupJson, "Group");

		this.setHTML("<a href=#>" + groupName + "</a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});

	}

}
