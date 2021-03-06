package co.uniqueid.client.maingroup.add;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class IconAddFounded extends HTML {

	public IconAddFounded(final String uniqueID) {

		this.setHTML("<a href=#><img src='images/add.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddFoundedPanel popup = new AddFoundedPanel(uniqueID);
				popup.show();
			}
		});

	}

}
