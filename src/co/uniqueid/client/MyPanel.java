package co.uniqueid.client;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;

public class MyPanel extends AbsolutePanel {

	public MyPanel(final JSONObject unoUserJson) {

		this.setSize("700px", "700px");

		MyPhoto image = new MyPhoto(unoUserJson);
		add(image, 259, 183);

		HTML image_1 = new HTML(
				"<a href='http://www.facebook.com/"
						+ ConvertJson.getStringValue(unoUserJson,
								"facebookLogin")
						+ "' target='_blank'><img src='images/facebookIcon.jpg' border=0 width='35px' height='35px'></a>");
		add(image_1, 218, 80);

		HTML image_2 = new HTML(
				"<a href='http://www.twitter.com/"
						+ ConvertJson.getStringValue(unoUserJson, "twitterID")
						+ "' target='_blank'><img src='images/TwitterIcon.jpg' border=0 width='35px' height='35px'></a>");
		add(image_2, 357, 80);

		HTML image_3 = new HTML(
				"<a href='http://www.linkedin.com/"
						+ ConvertJson.getStringValue(unoUserJson, "linkedinID")
						+ "' target='_blank'><img src='images/LinkedinIcon.jpg' border=0 width='35px' height='35px'></a>");
		add(image_3, 427, 197);

		HTML image_4 = new HTML(
				"<a href='"
						+ ConvertJson.getStringValue(unoUserJson, "aboutMeURL")
						+ "' target='_blank'><img src='images/aboutme.png' border=0 width='35px' height='35px'></a>");
		add(image_4, 137, 197);

		HTML image_5 = new HTML(
				"<ahref='http://www.github.com/"
						+ ConvertJson
								.getStringValue(unoUserJson, "githubLogin")
						+ "' target='_blank'><img src='images/github-icon.png' border=0 width='48px' height='48px'></a>");
		add(image_5, 172, 332);

		HTML image_6 = new HTML(
				"<a href='"
						+ ConvertJson.getStringValue(unoUserJson, "blogURL")
						+ "' target='_blank'><img src='images/BlogIcon.jpg' border=0 width='48px' height='48px'></a>");
		add(image_6, 390, 332);

	}
}
