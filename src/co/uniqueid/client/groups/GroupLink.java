package co.uniqueid.client.groups;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.groups.contacts.addContact.IconAddContact;
import co.uniqueid.client.maingroup.EditIcon;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class GroupLink extends HorizontalPanel {

	public GroupLink(final JSONObject groupJson) {

		String groupID = ConvertJson.convertToString(groupJson.get("ID"));

		String uniqueID = ConvertJson
				.convertToString(groupJson.get("UniqueID"));

		this.setSpacing(15);

		String groupName = ConvertJson.getStringValue(groupJson, "Group");

		HTML html = new HTML(groupName);

		this.add(html);

		this.add(new IconAddContact(uniqueID, groupID));

		this.add(new EditIcon(groupJson));

	}

}
