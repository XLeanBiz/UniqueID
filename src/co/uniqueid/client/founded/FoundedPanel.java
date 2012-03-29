package co.uniqueid.client.founded;

import java.util.ArrayList;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.founded.add.IconAddFounded;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FoundedPanel extends VerticalPanel {

	public static HorizontalPanel hpFounded = new HorizontalPanel();

	public FoundedPanel(final JSONObject entityJsonObject) {

		String uniqueID = ConvertJson.convertToString(entityJsonObject
				.get("ID"));

		this.setWidth("100%");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		HorizontalPanel hpLabel = new HorizontalPanel();

		hpLabel.setWidth("150px");

		HTML htmlFounded = new HTML("<font size=3 color=black><b>Founded:</b></font>");
		hpLabel.add(htmlFounded);

		hpLabel.add(new IconAddFounded(uniqueID));

		this.add(hpLabel);

		hpFounded.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hpFounded.clear();
		this.add(hpFounded);

		listFounded(entityJsonObject);

	}

	private static void listFounded(JSONObject entityJsonObject) {

		ArrayList<String> foundedArray = convertFoundedToArray(entityJsonObject);

		for (String foundedUniqueID : foundedArray) {

			hpFounded.add(new FoundedList(foundedUniqueID));
		}
	}

	private static ArrayList<String> convertFoundedToArray(JSONObject obj) {

		ArrayList<String> foudedArray = new ArrayList<String>();

		if (obj.get("Founded") != null) {

			JSONArray foundeds = obj.get("Founded").isArray();

			for (int i = 0; i < foundeds.size(); i++) {

				String foundedString = foundeds.get(i).toString();

				foudedArray.add(convertFoundedToUniqueID(foundedString));
			}
		}

		return foudedArray;
	}

	public static String convertFoundedToUniqueID(String jsonEntity) {

		jsonEntity = jsonEntity.replace("\"UniqueID(\\\"", "");
		jsonEntity = jsonEntity.replace("\\\")\"", "");

		return jsonEntity;
	}
}
