package co.uniqueid.client.groups;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.entity.page.EntityPage;
import co.uniqueid.client.groups.contacts.ContactsPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListGroups {

	public static void list(final String uniqueID) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listGroups(uniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray jsonArray = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				for (int i = 0; i < jsonArray.size(); i++) {

					JSONObject jsonGroup = (JSONObject) jsonArray.get(i);

					GroupsPanel.vpGroups.add(new GroupLink(jsonGroup));

					VerticalPanel vpContacts = new VerticalPanel();
					vpContacts.add(new ContactsPanel(jsonGroup));

					GroupsPanel.vpGroups.add(vpContacts);
					
					Label space = new Label(" ");
					space.setHeight("30px");
					GroupsPanel.vpGroups.add(space);
				}
			}
		});
	}

}
