package co.uniqueid.client.entity.edit;

import co.uniqueid.client.GWTEntryPoint;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class AddButton extends Button {

	public AddButton() {

		this.setText("Add New ID");

		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new EditEntity(new JSONObject()));
			}
		});
	}

}
