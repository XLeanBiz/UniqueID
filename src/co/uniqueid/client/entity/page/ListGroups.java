package co.uniqueid.client.entity.page;

import co.uniqueid.client.UniqueIDService;
import co.uniqueid.client.UniqueIDServiceAsync;
import co.uniqueid.client.Utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class ListGroups {

	public static void list(final String entityUniqueID, final String group) {

		final UniqueIDServiceAsync uniqueIDService = GWT
				.create(UniqueIDService.class);

		uniqueIDService.listGroups(entityUniqueID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONArray jsonArray = (JSONArray) JSONParser
						.parseStrict(jsonResults);

				for (int i = 0; i < jsonArray.size(); i++) {

					JSONObject jsonGroup = (JSONObject) jsonArray.get(i);

					String groupID = ConvertJson
							.getStringValue(jsonGroup, "ID");

					String groupName = ConvertJson.getStringValue(jsonGroup,
							"Group");

					if (group != null) {

						if (groupID.equals(group) || groupName.equals(group)) {

							showGroup(entityUniqueID, groupID, groupName);
						}

					} else {

						showGroup(entityUniqueID, groupID, groupName);
					}

				}
			}
		});
	}

	private static void showGroup(final String entityUniqueID, final String groupID, final String groupName) {

		Label space = new Label(" ");
		space.setHeight("30px");
		EntityPage.vpGroups.add(space);

		EntityPage.vpGroups.add(new GroupName(entityUniqueID, groupName));

		FlexTable gridContacts = new FlexTable();
		gridContacts.getColumnFormatter().setWidth(0, "50px");
		gridContacts.getColumnFormatter().setWidth(1, "220px");
		gridContacts.getColumnFormatter().setWidth(3, "30px");

		EntityPage.vpGroups.add(gridContacts);

		new ListContacts(groupID, gridContacts);
	}

}
