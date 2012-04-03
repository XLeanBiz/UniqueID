package co.uniqueid.client.maingroup;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.maingroup.rename.RenameGroupPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;

public class MainGroupLabel extends HTML {

	public MainGroupLabel(final JSONObject entityJsonObject) {

		final String uniqueID = ConvertJson.convertToString(entityJsonObject
				.get("ID"));

		String mainGroupName = ConvertJson.convertToString(entityJsonObject
				.get("MainGroupName"));

		if (mainGroupName == null || "".equals(mainGroupName)) {
			mainGroupName = "Founded";
		}

		this.setHTML("<font size=3 color=black><b><a href=#>" + mainGroupName
				+ ":</a></b></font>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				RenameGroupPanel popup = new RenameGroupPanel(uniqueID);
				popup.show();
			}
		});

	}
}
