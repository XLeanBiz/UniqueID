package co.uniqueid.client.maingroup.permissions;

import co.uniqueid.client.maingroup.rename.CloseButton;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PermissionsPanel extends PopupPanel {

	public static TextBox permissionName = new TextBox();

	public PermissionsPanel(final JSONObject entityJsonObject) {

	//	this.center();
		this.setAutoHideEnabled(true);

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(30);
		vp.setWidth("300px");

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(new CloseButton(this));

		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		vp.add(new Label("Permissions to Edit this information:"));

		vp.add(listPermissions(entityJsonObject));

		permissionName.setValue(null);
		permissionName.setWidth("200px");
		vp.add(permissionName);

		vp.add(new ButtonAddPermission(entityJsonObject, this));

		this.setWidget(vp);

	}

	private VerticalPanel listPermissions(final JSONObject entityJsonObject) {

		VerticalPanel vp = new VerticalPanel();

		JSONArray jsonArray = (JSONArray) entityJsonObject.get("Permissions");

		if (jsonArray != null) {

			for (int i = 0; i < jsonArray.size(); i++) {

				JSONString contactJson = (JSONString) jsonArray.get(i);

				// String entityName = ConvertJson.getStringValue(contactJson,
				// "entityName");

				HTML permission = new HTML(contactJson.stringValue());

				vp.add(permission);
			}
		}

		return vp;
	}
}
