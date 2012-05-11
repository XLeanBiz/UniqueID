package co.uniqueid.client.entity.page;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.slideshow.Slideshow;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;

public class ListContacts {

	public ListContacts(final String groupID, final FlexTable gridContacts) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listContacts(groupID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray contacts = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				int j = 1;
				for (int i = (contacts.size() - 1); i >= 0; i--) {

					JSONObject contactJson = (JSONObject) contacts.get(i);

					Slideshow.addImageURL(contactJson);

					gridContacts.setWidget(j, 1, EntityContactsPanel
							.getEntityName(contactJson, "30"));

					gridContacts.setWidget(j, 2,
							EntityContactsPanel.getIconsPanel(contactJson));

					gridContacts.setWidget(j, 4,
							EntityContactsPanel.getFoundedImages(contactJson));

					j++;
				}
			}
		});
	}

}
