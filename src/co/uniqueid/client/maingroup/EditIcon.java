package co.uniqueid.client.maingroup;

import co.uniqueid.client.Utilities.UseTracking;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Anchor;

public class EditIcon extends Anchor {

	public EditIcon(final JSONObject entityJsonObject) {

		this.setHTML("<a href=#><img src='images/EditIcon.jpg' width='15px' height='15px' border=0></a>");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				new UseTracking("co.uniqueid.client.maingroup.EditIcon");

			}
		});
	}

}
