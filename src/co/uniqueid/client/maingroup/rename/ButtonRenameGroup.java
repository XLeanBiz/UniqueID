package co.uniqueid.client.maingroup.rename;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;

public class ButtonRenameGroup extends Button {

	public ButtonRenameGroup(final String uniqueID, final PopupPanel popup) {

		this.setText("Rename");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String groupName = RenameGroupPanel.groupName.getValue();

				if (groupName != null && !"".equals(groupName)) {

					RenameGroup.rename(uniqueID, groupName);
				}

				popup.hide();
			}
		});

	}

}
