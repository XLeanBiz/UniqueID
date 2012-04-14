package co.uniqueid.client.entity.page;

import co.uniqueid.client.groups.contacts.addContact.AddContact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class IconAddContact extends HTML {

	public IconAddContact(final String uniqueID, final String groupID,
			final String contactID) {

		this.setHTML("<a href=#><img src='images/add.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddContact.save(uniqueID, groupID, contactID);
			}
		});

	}

}
