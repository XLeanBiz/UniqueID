package co.uniqueid.client.groups.addGroup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ButtonAddGroup extends Button {

	public ButtonAddGroup(final String uniqueID, final PopupPanel popup) {

		this.setText("Add");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String group = AddGroupPanel.groupName.getValue();

				if (group != null && !"".equals(group)) {

					AddGroup.save(uniqueID, group);
				}

				popup.hide();
			}
		});

	}

}
