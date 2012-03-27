package co.uniqueid.client.founded.add;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonAdd extends Button {

	public ButtonAdd(final String uniqueID) {

		this.setText("Add");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String foundedID = AddFoundedPanel.uniqueIDFounded.getValue();

				if (foundedID != null && !"".equals(foundedID)) {

					AddFounded.save(uniqueID, foundedID);
				}
			}
		});

	}

}
