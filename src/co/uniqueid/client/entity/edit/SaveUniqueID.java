package co.uniqueid.client.entity.edit;

import co.uniqueid.authentication.client.uniqueid.UniqueIDService;
import co.uniqueid.authentication.client.uniqueid.UniqueIDServiceAsync;
import co.uniqueid.client.GWTEntryPoint;
import co.uniqueid.client.entity.EntityPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveUniqueID {

	public static void save(final String unoUserJsonString) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.saveUnoUser(unoUserJsonString, new AsyncCallback<Void>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(Void results) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(unoUserJsonString);

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new EntityPanel(obj));
			}
		});

	}
}
