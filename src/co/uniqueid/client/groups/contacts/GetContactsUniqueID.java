package co.uniqueid.client.groups.contacts;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.edit.DeleteContactIcon;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class GetContactsUniqueID {

	public static void getFromID(final String contactUniqueID,
			final HorizontalPanel hpPhoto) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.getUniqueID(contactUniqueID,
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(final String jsonResults) {

						JSONObject obj = (JSONObject) JSONParser
								.parseStrict(jsonResults);

						hpPhoto.clear();
						hpPhoto.add(new ContactPhoto(obj));

						hpPhoto.add(new DeleteContactIcon(obj, obj));
					}
				});
	}

}
