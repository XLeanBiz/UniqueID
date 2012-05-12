package co.uniqueid.client.home.events;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GetMainEvents {

	public static void getFromID(final String eventUniqueID,
			final String groupName, final VerticalPanel hpPhoto) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.getUniqueID(eventUniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				if (jsonResults != null) {

					JSONObject obj = (JSONObject) JSONParser
							.parseStrict(jsonResults);

					hpPhoto.clear();
					hpPhoto.add(new EventImage(obj, groupName));
				}
			}
		});
	}

}
