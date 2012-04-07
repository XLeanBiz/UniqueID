package co.uniqueid.client.groups.contacts.addContact;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddContactPanel extends PopupPanel {

	public static TextBox uniqueIDContact = new TextBox();

	public AddContactPanel(final String uniqueID, final String groupID) {

		//this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Enter the Contact Name or Unique ID:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		uniqueIDContact.setValue(null);
		uniqueIDContact.setWidth("200px");
		vp.add(uniqueIDContact);

		vp.add(new ButtonAddContact(uniqueID,groupID, this));

		this.setWidget(vp);

	}
}
