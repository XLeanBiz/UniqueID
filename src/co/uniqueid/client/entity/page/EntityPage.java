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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EntityPage extends VerticalPanel {

	public static FlexTable gridFounded = new FlexTable();

	public static VerticalPanel vpGroups = new VerticalPanel();

	public EntityPage(final JSONObject unoUserJson, final String group) {

		String uniqueID = ConvertJson.convertToString(unoUserJson.get("ID"));

		HorizontalPanel hpEntity = new HorizontalPanel();
		hpEntity.setSpacing(20);
		hpEntity.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		hpEntity.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		add(hpEntity);
		hpEntity.add(getEntityName(unoUserJson, "70"));
		hpEntity.add(getIconsPanel(unoUserJson));

		if (unoUserJson.get("Founded") != null) {

			ListFounded.list(uniqueID);

			String mainGroupName = ConvertJson.convertToString(unoUserJson
					.get("MainGroupName"));

			if (mainGroupName == null || "".equals(mainGroupName)) {
				mainGroupName = "Founded";
			}

			gridFounded.clear();
			gridFounded.setHTML(0, 0, "<font size=3 color=red><b>"
					+ mainGroupName + ":</b></font>");
			gridFounded.getColumnFormatter().setWidth(1, "250px");
			gridFounded.getColumnFormatter().setWidth(3, "30px");

			add(gridFounded);
		}

		vpGroups.clear();
		this.add(vpGroups);

		ListGroups.list(uniqueID, group);
	}

	public static HorizontalPanel getEntityName(final JSONObject unoUserJson,
			final String imageSize) {

		HorizontalPanel hpName = new HorizontalPanel();

		hpName.setSpacing(5);
		hpName.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GetUniqueID.get(unoUserJson);
			}
		};

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='" + imageSize + "px' height='"
					+ imageSize + "px'></a>");
			image.addClickHandler(clickHandler);
			hpName.add(image);
		}

		HTML name = new HTML("<font size=2 color=blue><a href='#'>"
				+ ConvertJson.getStringValue(unoUserJson, "entityName")
				+ "</a></font>");
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
