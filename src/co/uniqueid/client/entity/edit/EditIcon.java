package co.uniqueid.client.entity.edit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Anchor;

public class EditIcon extends Anchor {

	public EditIcon(final JSONObject unoUserJson) {

		this.setHTML("<a href=#><img src='"
				+ GWT.getModuleBaseURL()
				+ "authentication/images/EditIcon.jpg' width='22px' height='20px'></a>");

		this.setSize("22px", "20px");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

	
			}
		});
	}

}
