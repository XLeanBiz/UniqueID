package co.uniqueid.client.groups.addGroup;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.GetUniqueID;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddGroup {

	public static void save(final String uniqueID, final String groupName) {

		final UniqueIDServiceAsync unoIDService = GWT
				.create(UniqueIDService.class);

		unoIDService.addGroup(uniqueID, groupName, new AsyncCallback<Void>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(Void results) {

				GetUniqueID.getFromID(uniqueID);
			}
		});

	}
}
