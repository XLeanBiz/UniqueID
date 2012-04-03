package co.uniqueid.client.groups.add;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class IconAddGroup extends HTML {

	public IconAddGroup(final String uniqueID) {

		this.setHTML("<a href=#><img src='images/add.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddGroupPanel popup = new AddGroupPanel(uniqueID);
				popup.show();
			}
		});

	}

}
