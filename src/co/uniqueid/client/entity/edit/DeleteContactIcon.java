package co.uniqueid.client.entity.edit;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class DeleteContactIcon extends HTML {

	public DeleteContactIcon(final JSONObject groupID, final JSONObject contactID) {

		this.setHTML("<a href=#><img src='images/close.gif' width='8' height='8' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

			}
		});
	}
}
