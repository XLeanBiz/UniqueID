package co.uniqueid.client.contacts;

import java.util.ArrayList;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.contacts.add.IconAddContact;
import co.uniqueid.client.entity.page.EntityPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactsPanel extends VerticalPanel {

	public static VerticalPanel vpContacts = new VerticalPanel();

	public ContactsPanel(final JSONObject entityJsonObject) {

		String uniqueID = ConvertJson.convertToString(entityJsonObject
				.get("ID"));

		HorizontalPanel hpLabel = new HorizontalPanel();

		hpLabel.setWidth("150px");

		HTML htmlFounded = new HTML(
				"<a href=#><font size=3 color=black><b>Contacts:</b></font></a>");
		hpLabel.add(htmlFounded);
		htmlFounded.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.vpMain.clear();
				InitializeUniqueIDAppllication.vpMain.add(new EntityPage(
						entityJsonObject));
			}
		});

		hpLabel.add(new IconAddContact(uniqueID));

		this.add(hpLabel);

		vpContacts.clear();
		this.add(vpContacts);

		listContacts(entityJsonObject);

	}

	private static void listContacts(JSONObject entityJsonObject) {

		ArrayList<String> contactsArray = convertContactsToArray(entityJsonObject);

		int j = 0;
		HorizontalPanel hp = new HorizontalPanel();
		for (String contactUniqueID : contactsArray) {

			if (j % 3 == 0) {

				hp = new HorizontalPanel();

				hp.setWidth("600px");

				vpContacts.add(hp);
			}

			hp.add(new ContactsList(contactUniqueID));

			j++;
		}
	}

	private static ArrayList<String> convertContactsToArray(JSONObject obj) {

		ArrayList<String> contactsArray = new ArrayList<String>();

		if (obj.get("Contacts") != null) {

			JSONArray contacts = obj.get("Contacts").isArray();

			for (int i = (contacts.size()-1); i >=0 ; i--) {

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
