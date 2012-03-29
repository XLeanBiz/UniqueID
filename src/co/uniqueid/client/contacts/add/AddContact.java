package co.uniqueid.client.contacts.add;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddContact {

	public static void save(final String uniqueID, final String contactID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.addContact(uniqueID, contactID, new AsyncCallback<Void>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(Void results) {

				Location.assign(GWT.getHostPageBaseURL() + "?search="
						+ uniqueID + "&field=ID");

			}
		});

	}
}
