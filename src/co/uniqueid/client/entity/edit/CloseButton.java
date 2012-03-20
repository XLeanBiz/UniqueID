package co.uniqueid.client.entity.edit;

import co.uniqueid.client.GWTEntryPoint;
import co.uniqueid.client.entity.EntityPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class CloseButton extends HTML {

	public CloseButton(final JSONObject unoUserJson) {

		this.setHTML("<a href=#><img src='images/close.jpg' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new EntityPanel(unoUserJson));
			}
		});
	}
}
