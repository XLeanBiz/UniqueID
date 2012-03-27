package co.uniqueid.client.entity;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.home.MainPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetUniqueID {

	public static void get(final String unoUser) {

		JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);

		String unoUserID = ConvertJson.getStringValue(obj, "ID");

		getFromID(unoUserID);

	}

	public static void getFromID(final String unoUserID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUniqueID(unoUserID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				if (obj != null) {

					MainPanel.InitializeEntity(obj);
				}
			}
		});
	}

	public static void getFromField(final String fieldName,
			final String fieldValue) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUniqueIDByField(fieldName, fieldValue,
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(final String jsonResults) {

						if (jsonResults != null) {

							JSONArray obj = (JSONArray) JSONParser
									.parseStrict(jsonResults);

							JSONObject userJsonObject = (JSONObject) obj.get(0);

							if (userJsonObject != null) {

								MainPanel.InitializeEntity(userJsonObject);

							} else if (!"entityName".equals(fieldName)) {

								GetUniqueID.getFromField("entityName",
										fieldValue);
							} else {

								GetUniqueID.getFromID(fieldValue);
							}
						}
					}
				});

	}

}
