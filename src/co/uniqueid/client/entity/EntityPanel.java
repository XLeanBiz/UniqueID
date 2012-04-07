package co.uniqueid.client.entity;

import co.uniqueid.client.links.AboutMeIcon;
import co.uniqueid.client.links.BlogIcon;
import co.uniqueid.client.links.EmailIcon;
import co.uniqueid.client.links.FacebookIcon;
import co.uniqueid.client.links.LinkedinIcon;
import co.uniqueid.client.links.TwitterIcon;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class EntityPanel extends AbsolutePanel {

	public EntityPanel(final JSONObject unoUserJson) {

		this.setSize("650px", "340px");

		EntityPhoto image = new EntityPhoto(unoUserJson);
		add(image, 179, 143);

		add(FacebookIcon.getIcon(unoUserJson, "35", true), 138, 40);

		add(TwitterIcon.getIcon(unoUserJson, "35", true), 277, 40);

		add(LinkedinIcon.getIcon(unoUserJson, "35", true), 347, 157);

		add(AboutMeIcon.getIcon(unoUserJson, "35", true), 57, 157);

		add(EmailIcon.getIcon(unoUserJson, "35", true), 92, 292);

		add(BlogIcon.getIcon(unoUserJson, "35", true), 310, 292);

	}
}
