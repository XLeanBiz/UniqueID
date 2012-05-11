package co.uniqueid.client.entity.page;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.GetUniqueID;
import co.uniqueid.client.links.AboutMeIcon;
import co.uniqueid.client.links.BlogIcon;
import co.uniqueid.client.links.EmailIcon;
import co.uniqueid.client.links.FacebookIcon;
import co.uniqueid.client.links.LinkedinIcon;
import co.uniqueid.client.links.TwitterIcon;
import co.uniqueid.client.maingroup.MainGroupPhoto;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class EntityContactsPanel extends HorizontalPanel {

	public EntityContactsPanel(final JSONObject entityJson) {

		setSpacing(20);
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		add(getEntityName(entityJson, "70"));
		add(getIconsPanel(entityJson));
	}

	public static HorizontalPanel getEntityName(final JSONObject entityJson,
			final String imageSize) {

		HorizontalPanel hpName = new HorizontalPanel();

		hpName.setSpacing(5);
		hpName.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GetUniqueID.get(entityJson);
			}
		};

		String entityName = ConvertJson
				.getStringValue(entityJson, "entityName");

		String imageURL = ConvertJson.getStringValue(entityJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='" + imageSize + "px' height='"
					+ imageSize + "px' title='" + entityName + "'></a>");
			image.addClickHandler(clickHandler);
			hpName.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>"
				+ entityName + "</a></font>");
		name.addClickHandler(clickHandler);
		hpName.add(name);

		return hpName;
	}

	public static HorizontalPanel getIconsPanel(final JSONObject unoUserJson) {

		HorizontalPanel hpContacts = new HorizontalPanel();

		hpContacts.setSpacing(5);

		hpContacts.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		addIcon(FacebookIcon.getIcon(unoUserJson, "20", false), hpContacts);

		addIcon(TwitterIcon.getIcon(unoUserJson, "20", false), hpContacts);

		addIcon(LinkedinIcon.getIcon(unoUserJson, "20", false), hpContacts);

		addIcon(AboutMeIcon.getIcon(unoUserJson, "20", false), hpContacts);

		addIcon(EmailIcon.getIcon(unoUserJson, "20", false), hpContacts);

		addIcon(BlogIcon.getIcon(unoUserJson, "20", false), hpContacts);

		return hpContacts;
	}

	private static void addIcon(HTML icon, HorizontalPanel hp) {

		if (icon != null) {

			hp.add(icon);
		}
	}

	public static HorizontalPanel getFoundedImages(final JSONObject contactJson) {

		HorizontalPanel hpFounded = new HorizontalPanel();

		hpFounded.setSpacing(5);

		hpFounded.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		JSONArray arrayFounded = (JSONArray) contactJson.get("FoundedEntities");

		if (arrayFounded != null) {

			for (int i = 0; i < arrayFounded.size(); i++) {

				JSONObject founded = (JSONObject) arrayFounded.get(i);

				HTML foundedPhoto = new MainGroupPhoto(founded, "30");

				hpFounded.add(foundedPhoto);
			}
		}
		return hpFounded;
	}
}
