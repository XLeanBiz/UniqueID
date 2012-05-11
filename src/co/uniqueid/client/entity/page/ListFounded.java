package co.uniqueid.client.entity.page;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.slideshow.Slideshow;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListFounded {

	public static void list(final String uniqueID) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listFounded(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray jsonArray = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				for (int i = 0; i < jsonArray.size(); i++) {

					JSONObject contactJson = (JSONObject) jsonArray.get(i);
					
					Slideshow.addImageURL(contactJson);

					EntityPage.gridFounded.setWidget(i + 1, 1,
							EntityContactsPanel
									.getEntityName(contactJson, "30"));

					EntityPage.gridFounded.setWidget(i + 1, 2,
							EntityContactsPanel.getIconsPanel(contactJson));

					EntityPage.gridFounded.setWidget(i + 1, 4,
							EntityContactsPanel.getFoundedImages(contactJson));
				}
			}
		});
	}

}
