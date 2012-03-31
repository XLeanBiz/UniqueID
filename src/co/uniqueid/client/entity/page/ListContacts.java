package co.uniqueid.client.entity.page;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListContacts {

	public static void list(final String uniqueID) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listContacts(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray jsonArray = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				int j = 1;
				for (int i = (jsonArray.size() - 1); i >= 0; i--) {

					JSONObject contactJson = (JSONObject) jsonArray.get(i);

					EntityPage.gridContacts.setWidget(j, 1,
							EntityPage.getEntityName(contactJson, "30"));

					EntityPage.gridContacts.setWidget(j, 2,
							EntityPage.getIconsPanel(contactJson));

					EntityPage.gridContacts.setWidget(j, 4,
							EntityPage.getFoundedImages(contactJson));

					j++;
				}
			}
		});
	}

}
