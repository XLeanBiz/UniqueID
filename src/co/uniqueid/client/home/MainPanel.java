package co.uniqueid.client.home;

import co.uniqueid.client.entity.EntityPanel;
import co.uniqueid.client.founded.FoundedPanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPanel extends VerticalPanel {

	public static VerticalPanel vpMain = new VerticalPanel();

	public static void InitializeEntity(JSONObject entityJsonObject) {

		vpMain.clear();
		vpMain.add(new EntityPanel(entityJsonObject));
		
		vpMain.add(new FoundedPanel(entityJsonObject));
	}
}
