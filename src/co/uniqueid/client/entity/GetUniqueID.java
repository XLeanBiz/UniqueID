package co.uniqueid.client.entity;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.uniqueid.UniqueIDService;
import co.uniqueid.authentication.client.uniqueid.UniqueIDServiceAsync;
import co.uniqueid.authentication.client.utilities.ConvertJson;
import co.uniqueid.client.GWTEntryPoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class GetUniqueID {

	public static void get(final String unoUser) {

		JSONObject obj = (JSONObject) JSONParser.parseStrict(unoUser);

		String unoUserID = ConvertJson.getStringValue(obj, "ID");

		getFromID(unoUserID);

	}

	public static void getFromID(final String unoUserID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUnoUser(unoUserID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				UniqueIDGlobalVariables.uniqueID = obj;
			}
		});
	}

	public static void getFromFacebookID(final String facebookID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUniqueIDByFacebookID(facebookID,
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(final String jsonResults) {

						JSONArray obj = (JSONArray) JSONParser
								.parseStrict(jsonResults);

						JSONObject userJsonObject = (JSONObject) obj.get(0);

						UniqueIDGlobalVariables.uniqueID = userJsonObject;

						GWTEntryPoint.vpMain.clear();
						GWTEntryPoint.vpMain.add(new EntityPanel(userJsonObject));
					}
				});

	}
}
