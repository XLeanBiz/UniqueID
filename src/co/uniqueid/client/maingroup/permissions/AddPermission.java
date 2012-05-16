package co.uniqueid.client.maingroup.permissions;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.GetUniqueID;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddPermission {

	public static void add(final String uniqueID, final String permissionName) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.addPermission(uniqueID, permissionName,
				new AsyncCallback<Void>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(Void results) {

						GetUniqueID.getFromID(uniqueID);
					}
				});

	}
}
