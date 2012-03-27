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

		vp.add(new Label("Enter the Founded Unique ID:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		uniqueIDFounded.setWidth("200px");
		vp.add(uniqueIDFounded);

		vp.add(new ButtonAdd(uniqueID));

		this.setWidget(vp);

	}
}
