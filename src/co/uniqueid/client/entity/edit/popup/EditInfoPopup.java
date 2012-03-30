package co.uniqueid.client.entity.edit.popup;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditInfoPopup extends PopupPanel {

	public static TextBox info = new TextBox();

	public EditInfoPopup(final JSONObject unoUserJson, final String infoKey,
			final String infoName) {

		this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new HTML("Enter the " + infoName + ":"));

		vp.setSpacing(10);
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		info.setValue(null);
		info.setWidth("200px");
		vp.add(info);

		vp.add(new ButtonSaveInfo(unoUserJson, infoKey, this));

		this.setWidget(vp);

	}
}
