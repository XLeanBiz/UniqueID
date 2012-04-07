package co.uniqueid.client.groups.contacts.addContact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class IconAddContact extends HTML {

	public IconAddContact(final String uniqueID, final String groupID) {

		this.setHTML("<a href=#><img src='images/add.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddContactPanel popup = new AddContactPanel(uniqueID, groupID);
				popup.show();
			}
		});

	}

}
