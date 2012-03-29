package co.uniqueid.client.contacts.add;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddContactPanel extends PopupPanel {

	public static TextBox uniqueIDContact = new TextBox();

	public AddContactPanel(final String uniqueID) {

		this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Enter the Contact Unique ID:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		uniqueIDContact.setValue(null);
		uniqueIDContact.setWidth("200px");
		vp.add(uniqueIDContact);

		vp.add(new ButtonAddContact(uniqueID, this));

		this.setWidget(vp);

	}
}
