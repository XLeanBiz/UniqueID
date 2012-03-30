package co.uniqueid.client.entity.edit.popup;

import co.uniqueid.client.entity.edit.SaveUniqueID;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ButtonSaveInfo extends Button {

	public ButtonSaveInfo(final JSONObject unoUserJson,
			final String informationKey, final PopupPanel popup) {

		this.setText("Save");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String infoValue = EditInfoPopup.info.getValue();

				if (infoValue != null && !"".equals(infoValue)) {

					unoUserJson.put(informationKey, new JSONString(infoValue));

					SaveUniqueID.save(unoUserJson);
				}

				popup.hide();
			}
		});

	}

}
