package co.uniqueid.client.groups.contacts;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ContactsList extends HorizontalPanel {

	public ContactsList(final String contactUniqueID) {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HorizontalPanel hpPhoto = new HorizontalPanel();

		this.add(hpPhoto);

		GetContactsUniqueID.getFromID(contactUniqueID, hpPhoto);

	}

}
