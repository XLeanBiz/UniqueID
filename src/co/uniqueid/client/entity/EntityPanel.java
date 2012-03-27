package co.uniqueid.client.entity;

import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;

public class EntityPanel extends AbsolutePanel {

	public EntityPanel(final JSONObject unoUserJson) {

		this.setSize("600px", "380px");

		EntityPhoto image = new EntityPhoto(unoUserJson);
		add(image, 179, 143);

		String facebook = ConvertJson.getStringValue(unoUserJson,
				"facebookLogin");
		HTML image_1 = new HTML();
		if (facebook != null) {
			image_1.setHTML("<a href='http://www.facebook.com/"
					+ facebook
					+ "' target='_blank'><img src='images/facebookIcon.jpg' border=0 width='35px' height='35px'></a>");
		} else {
			image_1.setHTML("<img src='images/facebookIconCrossed.jpg' border=0 width='35px' height='35px'>");
		}
		add(image_1, 138, 40);

		String twitterID = ConvertJson.getStringValue(unoUserJson, "twitterID");
		HTML image_2 = new HTML();
		if (twitterID != null) {
			image_2.setHTML("<a href='http://www.twitter.com/"
					+ twitterID
					+ "' target='_blank'><img src='images/TwitterIcon.jpg' border=0 width='35px' height='35px'></a>");
		} else {
			image_2.setHTML("<img src='images/TwitterIconCrossed.jpg' border=0 width='35px' height='35px'>");
		}
		add(image_2, 277, 40);

		String linkedinID = ConvertJson.getStringValue(unoUserJson,
				"linkedinID");
		HTML image_3 = new HTML();
		if (linkedinID != null) {
			image_3.setHTML("<a href='http://www.linkedin.com/in/"
					+ linkedinID
					+ "' target='_blank'><img src='images/LinkedinIcon.jpg' border=0 width='35px' height='35px'></a>");
		} else {
			image_3.setHTML("<img src='images/LinkedinIconCrossed.jpg' border=0 width='35px' height='35px'>");
		}
		add(image_3, 347, 157);

		String aboutme = ConvertJson.getStringValue(unoUserJson, "aboutmeURL");
		HTML image_4 = new HTML();
		if (aboutme != null) {
			image_4.setHTML("<a href='"
					+ aboutme
					+ "' target='_blank'><img src='images/aboutme.png' border=0 width='35px' height='35px'></a>");

		} else {
			image_4.setHTML("<img src='images/aboutmeCrossed.png' border=0 width='35px' height='35px'>");
		}
		add(image_4, 57, 157);

	/*	String githubLogin = ConvertJson.getStringValue(unoUserJson,
				"githubLogin");
		HTML image_5 = new HTML();
		if (githubLogin != null) {
			image_5.setHTML("<a href='http://www.github.com/"
					+ githubLogin
					+ "' target='_blank'><img src='images/github-icon.png' border=0 width='48px' height='48px'></a>");
		} else {
			image_5.setHTML("<img src='images/github-iconCrossed.png' border=0 width='48px' height='48px'>");
		}
		add(image_5, 172, 332);*/
		
		String email = ConvertJson.getStringValue(unoUserJson,
				"email");
		HTML image_5 = new HTML();
		if (email != null) {
			image_5.setHTML("<a href=\"mailto:"
					+ email
					+ "\"><img src='images/email.jpg' border=0 width='40px' height='30px'></a>");
		} else {
			image_5.setHTML("<img src='images/emailCrossed.jpg' border=0 width='40px' height='30px'>");
		}
		add(image_5, 92, 292);

		String blogURL = ConvertJson.getStringValue(unoUserJson, "blogURL");
		HTML image_6 = new HTML();
		if (blogURL != null) {
			image_6.setHTML("<a href='"
					+ ConvertJson.getStringValue(unoUserJson, "blogURL")
					+ "' target='_blank'><img src='images/BlogIcon.jpg' border=0 width='45px' height='40px'></a>");
		} else {
			image_6.setHTML("<img src='images/BlogIconCrossed.jpg' border=0 width='45px' height='40px'>");
		}
		add(image_6, 310, 292);
		
	}
}
