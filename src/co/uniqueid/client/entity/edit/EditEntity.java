package co.uniqueid.client.entity.edit;

import co.uniqueid.authentication.client.utilities.ConvertJson;
import co.uniqueid.client.Utilities.FormField;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditEntity extends VerticalPanel {

	public static TextBox facebookLogin = new TextBox();

	public static TextBox name = new TextBox();

	public static TextBox email = new TextBox();

	public static TextBox githubLogin = new TextBox();

	public static TextBox imageURL = new TextBox();

	public static TextBox twitterID = new TextBox();

	public static TextBox linkedinID = new TextBox();

	public static TextBox blogURL = new TextBox();

	public static TextBox aboutmeURL = new TextBox();

	public EditEntity(JSONObject unoUser) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.add(new CloseButton(unoUser));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.add(new Label("Please, add the information you want to be public:"));

		String firstNameValue = ConvertJson.convertToString(unoUser
				.get("entityName"));
		name.setValue(firstNameValue);
		this.add(FormField.getFormField("<font color=red>*</font> Name", name));

		String emailValue = ConvertJson.convertToString(unoUser.get("email"));
		email.setValue(emailValue);
		this.add(FormField.getFormField("Email", email));

		String imageURLValue = ConvertJson
				.convertToString(unoUser.get("image"));
		imageURL.setValue(imageURLValue);
		this.add(FormField.getFormField("Image URL", imageURL));
		imageURL.setWidth("400px");

		String facebookLoginValue = ConvertJson.convertToString(unoUser
				.get("facebookLogin"));
		facebookLogin.setValue(facebookLoginValue);
		this.add(FormField.getFormField("Facebook ID", facebookLogin));

		String twitterIDValue = ConvertJson.convertToString(unoUser
				.get("twitterID"));
		twitterID.setValue(twitterIDValue);
		this.add(FormField.getFormField("Twitter ID", twitterID));

		String linkedinIDValue = ConvertJson.convertToString(unoUser
				.get("linkedinID"));
		linkedinID.setValue(linkedinIDValue);
		this.add(FormField.getFormField("LinkedIn ID", linkedinID));

		String aboutmeURLValue = ConvertJson.convertToString(unoUser
				.get("aboutmeURL"));
		aboutmeURL.setValue(aboutmeURLValue);
		this.add(FormField.getFormField("About Me URL", aboutmeURL));

		String blogURLValue = ConvertJson.convertToString(unoUser
				.get("blogURL"));
		blogURL.setValue(blogURLValue);
		this.add(FormField.getFormField("Blog URL", blogURL));

		String githubLoginValue = ConvertJson.convertToString(unoUser
				.get("githubLogin"));
		githubLogin.setValue(githubLoginValue);
		this.add(FormField.getFormField("Github Login", githubLogin));

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSave(unoUser));
	}

}
