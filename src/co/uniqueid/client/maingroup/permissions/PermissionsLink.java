package co.uniqueid.client.maingroup.permissions;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class PermissionsLink extends HTML {

	public PermissionsLink(final JSONObject entityJsonObject) {

		this.setHTML("<a href=#>Permissions</a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				PermissionsPanel popup = new PermissionsPanel(entityJsonObject);
				popup.show();
			}
		});

	}
}
