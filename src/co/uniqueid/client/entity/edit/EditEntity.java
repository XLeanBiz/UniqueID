package co.uniqueid.client.entity.edit;

import co.uniqueid.authentication.client.utilities.ConvertJson;
import co.uniqueid.client.Utilities.FormField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditEntity extends VerticalPanel {

	public static TextBox facebookLogin = new TextBox();

	public static TextBox firstName = new TextBox();

	public static TextBox lastName = new TextBox();

	public static TextBox email = new TextBox();

	public static TextBox githubLogin = new TextBox();

	public static TextBox imageURL = new TextBox();

	public static TextBox twitterID = new TextBox();

	public EditEntity(JSONObject unoUser, PopupEntity popup) {

		this.setSpacing(30);
		
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(PopupEntity.getCloseButton(popup));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		String emailValue = ConvertJson.convertToString(unoUser.get("email"));
		email.setValue(emailValue);
		this.add(FormField.getFormField("Email", email));

		String firstNameValue = ConvertJson.convertToString(unoUser
				.get("firstName"));
		firstName.setValue(firstNameValue);
		this.add(FormField.getFormField("First Name", firstName));

		String lastNameValue = ConvertJson.convertToString(unoUser
				.get("lastName"));
		lastName.setValue(lastNameValue);
		this.add(FormField.getFormField("Last Name", lastName));

		String facebookLoginValue = ConvertJson.convertToString(unoUser
				.get("facebookLogin"));
		facebookLogin.setValue(facebookLoginValue);
		this.add(FormField.getFormField("Facebook ID", facebookLogin));

		String imageURLValue = ConvertJson
				.convertToString(unoUser.get("image"));
		imageURL.setValue(imageURLValue);
		this.add(FormField.getFormField("Image URL", imageURL));
		imageURL.setWidth("400px");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(buttonSaveUnoUser(unoUser));
	}

	public Button buttonSaveUnoUser(final JSONObject unoUSer) {

		Button save = new Button("Save");

		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				unoUSer.put("email", new JSONString(email.getValue()));
				unoUSer.put("facebookLogin",
						new JSONString(facebookLogin.getValue()));
				unoUSer.put("firstName", new JSONString(firstName.getValue()));
				unoUSer.put("lastName", new JSONString(lastName.getValue()));
				unoUSer.put("image", new JSONString(imageURL.getValue()));

				SaveUniqueID.save(unoUSer.toString());

			}
		});

		return save;
	}

}
