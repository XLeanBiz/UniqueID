package co.uniqueid.client.groups.add;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddGroupPanel extends PopupPanel {

	public static TextBox groupName = new TextBox();

	public AddGroupPanel(final String uniqueID) {

		this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Enter the Name of the Group:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		groupName.setValue(null);
		groupName.setWidth("200px");
		vp.add(groupName);

		vp.add(new ButtonAddGroup(uniqueID, this));

		this.setWidget(vp);

	}
}
