package co.uniqueid.client.entity.edit;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public class ButtonSave extends Button {

	public ButtonSave(final JSONObject unoUser) {

		this.setText("Save");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				if (EditEntity.name.getValue() != null
						&& !"".equals(EditEntity.name.getValue())) {

					setFieldValue(unoUser, EditEntity.email, "email");
					setFieldValue(unoUser, EditEntity.facebookLogin,
							"facebookLogin");
					setFieldValue(unoUser, EditEntity.name, "entityName");
					setFieldValue(unoUser, EditEntity.imageURL, "image");
					setFieldValue(unoUser, EditEntity.twitterID, "twitterID");
					setFieldValue(unoUser, EditEntity.linkedinID, "linkedinID");
					setFieldValue(unoUser, EditEntity.aboutmeURL, "aboutmeURL");
					setFieldValue(unoUser, EditEntity.blogURL, "blogURL");
					setFieldValue(unoUser, EditEntity.githubLogin,
							"githubLogin");

					SaveUniqueID.save(unoUser);
				} else {

					Window.alert("Please, enter the 'Name' field.");
				}

			}
		});

	}

	private void setFieldValue(JSONObject unoUSer, final TextBox field,
			final String fieldName) {

		String value = field.getValue();
		if (value != null && !("".equals(value))) {
			unoUSer.put(fieldName, new JSONString(field.getValue()));
		}
	}

}
