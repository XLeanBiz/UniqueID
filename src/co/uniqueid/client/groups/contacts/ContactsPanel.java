package co.uniqueid.client.groups.contacts;

import java.util.ArrayList;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactsPanel extends VerticalPanel {

	public ContactsPanel(final JSONObject entityJsonObject) {

		ArrayList<String> contactsArray = convertContactsToArray(entityJsonObject);

		int j = 0;
		HorizontalPanel hp = new HorizontalPanel();
		for (String contactUniqueID : contactsArray) {

			if (j % 4 == 0) {

				hp = new HorizontalPanel();

				hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

				Label space = new Label(" ");
				space.setWidth("40px");
				hp.add(space);

				this.add(hp);
			}

			hp.add(new ContactsList(contactUniqueID));

			Label space = new Label(" ");
			space.setWidth("40px");
			hp.add(space);

			j++;
		}
	}

	private static ArrayList<String> convertContactsToArray(JSONObject obj) {

		ArrayList<String> contactsArray = new ArrayList<String>();

		if (obj.get("Contacts") != null) {

			JSONArray contacts = obj.get("Contacts").isArray();

			for (int i = (contacts.size() - 1); i >= 0; i--) {

				String contactString = contacts.get(i).toString();

				contactsArray.add(convertContactToUniqueID(contactString));
			}
		}

		return contactsArray;
	}

	public static String convertContactToUniqueID(String jsonEntity) {

		jsonEntity = jsonEntity.replace("\"UniqueID(\\\"", "");
		jsonEntity = jsonEntity.replace("\\\")\"", "");

		return jsonEntity;
	}
}
