package co.uniqueid.client.entity;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.page.EntityPage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetUniqueID {

	public static void get(final String uniqueIDJsonString) {

		JSONObject obj = (JSONObject) JSONParser
				.parseStrict(uniqueIDJsonString);

		get(obj);
	}

	public static void get(final JSONObject uniqueIDJson) {

		String uniqueID = ConvertJson.getStringValue(uniqueIDJson, "ID");

		getFromID(uniqueID, null, false);

	}

	public static void getFromID(final String uniqueID) {

		getFromID(uniqueID, null, false);
	}

	public static void getFromID(final String uniqueID, final String group,
			final boolean list) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.getUniqueID(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				if (obj != null) {

					if (list) {

						InitializeUniqueIDAppllication.vpMain.clear();
						InitializeUniqueIDAppllication.vpMain
								.add(new EntityPage(obj, group));
					} else {

						InitializeUniqueIDAppllication.InitializeEntity(obj);
					}
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

								InitializeUniqueIDAppllication
										.InitializeEntity(userJsonObject);

							} else if (!"entityName".equals(fieldName)) {

								GetUniqueID.getFromField("entityName",
										fieldValue);

							} else if (!"facebookLogin".equals(fieldName)) {

								GetUniqueID.getFromField("facebookLogin",
										fieldValue);
							} else {

								GetUniqueID.getFromID(fieldValue);
							}
						}
					}
				});

	}

}
