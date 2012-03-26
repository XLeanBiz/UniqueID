package co.uniqueid.client.founded.add;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddFoundedPanel extends PopupPanel {

	public AddFoundedPanel(final JSONObject unoUserJson) {

		this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();

		vp.add(new Label("Enter the Founded Unique ID:"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		TextBox uniqueIDFounded = new TextBox();
		uniqueIDFounded.setWidth("200px");
		vp.add(uniqueIDFounded);

		vp.add(new ButtonAdd(unoUserJson));

		this.setWidget(vp);

	}
}
