package co.uniqueid.client.groups;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.groups.contacts.addContact.IconAddContact;
import co.uniqueid.client.maingroup.EditIcon;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class GroupLink extends HorizontalPanel {

	public GroupLink(final JSONObject groupJson) {

		final String groupID = ConvertJson.convertToString(groupJson.get("ID"));

		final String uniqueID = ConvertJson.convertToString(groupJson
				.get("UniqueID"));

		this.setSpacing(15);

		final String groupName = ConvertJson.getStringValue(groupJson, "Group");

		HTML html = new HTML("<a href=#>" + groupName + "</a>");
		html.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Location.assign(GWT.getHostPageBaseURL() + "?ID=" + uniqueID
						+ "&group=" + groupName);
			}
		});

		this.add(html);

		this.add(new IconAddContact(uniqueID, groupID));

		this.add(new EditIcon(groupJson));

	}

}
