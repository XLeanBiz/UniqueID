package co.uniqueid.client.groups;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.page.EntityPage;
import co.uniqueid.client.groups.add.IconAddGroup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GroupsPanel extends VerticalPanel {

	public static VerticalPanel vpGroups = new VerticalPanel();

	public GroupsPanel(final JSONObject entityJsonObject) {
		
		this.setSpacing(15);

		String uniqueID = ConvertJson.convertToString(entityJsonObject
				.get("ID"));

		HorizontalPanel hpLabel = new HorizontalPanel();

		hpLabel.setWidth("150px");

		HTML htmlFounded = new HTML(
				"<a href=#><font size=3 color=black><b>Groups:</b></font></a>");
		hpLabel.add(htmlFounded);
		htmlFounded.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.vpMain.clear();
				InitializeUniqueIDAppllication.vpMain.add(new EntityPage(
						entityJsonObject));
			}
		});

		hpLabel.add(new IconAddGroup(uniqueID));

		this.add(hpLabel);

		vpGroups.setSpacing(10);
		vpGroups.clear();
		this.add(vpGroups);

		ListGroups.list(uniqueID);

	}

}
