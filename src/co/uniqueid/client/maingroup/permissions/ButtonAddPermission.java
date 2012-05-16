package co.uniqueid.client.maingroup.permissions;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ButtonAddPermission extends Button {

	public ButtonAddPermission(final JSONObject entityJsonObject,
			final PopupPanel popup) {

		this.setText("Add Permission");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String uniqueID = ConvertJson.convertToString(entityJsonObject
						.get("ID"));

				String permissionName = PermissionsPanel.permissionName
						.getValue();

				if (permissionName != null && !"".equals(permissionName)) {

					AddPermission.add(uniqueID, permissionName);
				}

				popup.hide();
			}
		});

	}

}
