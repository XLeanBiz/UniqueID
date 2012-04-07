package co.uniqueid.client.groups;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.page.EntityPage;
import co.uniqueid.client.groups.addGroup.IconAddGroup;
import co.uniqueid.client.maingroup.EditIcon;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GroupsPanel extends VerticalPanel {

	public static VerticalPanel vpGroups = new VerticalPanel();

	public GroupsPanel(final JSONObject entityJsonObject) {

		String uniqueID = ConvertJson.convertToString(entityJsonObject
				.get("ID"));

		HorizontalPanel hpLabel = new HorizontalPanel();

		hpLabel.setSpacing(10);

		HTML htmlFounded = new HTML(
				"<a href=#><font size=3 color=black><b>Groups:</b></font></a>");
		hpLabel.add(htmlFounded);
		htmlFounded.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.vpMain.clear();
				InitializeUniqueIDAppllication.vpMain.add(new EntityPage(
						entityJsonObject, null));
			}
		});

		hpLabel.add(new IconAddGroup(uniqueID));

		hpLabel.add(new EditIcon(entityJsonObject));

		this.add(hpLabel);

		vpGroups.clear();
		this.add(vpGroups);

		ListGroups.list(uniqueID);

	}

}
