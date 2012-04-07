package co.uniqueid.client.groups.contacts.addContact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ButtonAddContact extends Button {

	public ButtonAddContact(final String uniqueID, final String groupID,
			final PopupPanel popup) {

		this.setText("Add");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String contactID = AddContactPanel.uniqueIDContact.getValue();

				if (contactID != null && !"".equals(contactID)) {

					AddContact.save(uniqueID, groupID, contactID);
				}

				popup.hide();
			}
		});

	}

}
