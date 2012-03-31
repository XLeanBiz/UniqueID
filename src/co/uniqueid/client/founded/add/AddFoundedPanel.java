package co.uniqueid.client.founded.add;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddFoundedPanel extends PopupPanel {

	public static TextBox uniqueIDFounded = new TextBox();

	public AddFoundedPanel(final String uniqueID) {

		this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Enter the Founded Name or Unique ID:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		uniqueIDFounded.setValue(null);
		uniqueIDFounded.setWidth("200px");
		vp.add(uniqueIDFounded);

		vp.add(new ButtonAddFounded(uniqueID, this));

		this.setWidget(vp);

	}
}
