package co.uniqueid.client.entity.edit;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveUniqueID {

	public static void save(final JSONObject unoUserJson) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.saveUniqueID(unoUserJson.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						JSONObject obj = (JSONObject) JSONParser
								.parseStrict(unoUserJson);

						Location.assign(GWT.getHostPageBaseURL() + "?search="
								+ ConvertJson.getStringValue(obj, "ID")
								+ "&field=ID");

					}
				});

	}
}
