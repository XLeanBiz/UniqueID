package co.uniqueid.client.founded.add;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddFounded {

	public static void save(final String uniqueID, final String foundedID) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.addFounded(uniqueID, foundedID, new AsyncCallback<Void>() {

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
