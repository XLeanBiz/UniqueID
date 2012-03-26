package co.uniqueid.client.founded;

import co.uniqueid.client.founded.add.IconAdd;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FoundedPanel extends VerticalPanel {

	public static HorizontalPanel hpFounded = new HorizontalPanel();

	public FoundedPanel(final JSONObject unoUserJson) {

		this.setWidth("100%");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HorizontalPanel hpLabel = new HorizontalPanel();

		hpLabel.setWidth("150px");

		HTML htmlFounded = new HTML("Founded:");
		hpLabel.add(htmlFounded);

		hpLabel.add(new IconAdd(unoUserJson));

		this.add(hpLabel);

		this.add(hpFounded);

	}
}
