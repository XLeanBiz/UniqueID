package co.uniqueid.client.founded.add;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class IconAdd extends HTML {

	public IconAdd(final JSONObject unoUserJson) {

		this.setHTML("<a href=#><img src='images/add.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddFoundedPanel popup = new AddFoundedPanel(unoUserJson);
				popup.show();
			}
		});

	}

}