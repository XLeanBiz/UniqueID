package co.uniqueid.client.entity.page;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.links.AboutMeIcon;
import co.uniqueid.client.links.BlogIcon;
import co.uniqueid.client.links.EmailIcon;
import co.uniqueid.client.links.FacebookIcon;
import co.uniqueid.client.links.LinkedinIcon;
import co.uniqueid.client.links.TwitterIcon;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EntityPage extends VerticalPanel {

	public static FlexTable gridFounded = new FlexTable();

	public static FlexTable gridContacts = new FlexTable();

	public EntityPage(final JSONObject unoUserJson) {

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

			gridFounded.setHTML(0, 0,
					"<font size=3 color=red><b>Founded:</b></font>");
			gridFounded.getColumnFormatter().setWidth(1, "250px");

			add(gridFounded);
		}

		if (unoUserJson.get("Contacts") != null) {

			ListContacts.list(uniqueID);

			gridContacts.setHTML(0, 0,
					"<font size=3 color=red><b>Contacts:</b></font>");
			gridContacts.getColumnFormatter().setWidth(1, "250px");
			add(gridContacts);
		}
	}

	public static HorizontalPanel getEntityName(final JSONObject unoUserJson,
			final String imageSize) {

		HorizontalPanel hpName = new HorizontalPanel();

		hpName.setSpacing(5);
		hpName.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.init(ConvertJson.getStringValue(
						unoUserJson, "ID"));
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
		hpContacts.setSpacing(10);
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
}
