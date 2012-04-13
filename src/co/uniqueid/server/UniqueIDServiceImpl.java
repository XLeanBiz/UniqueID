package co.uniqueid.server;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.client.UniqueIDService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UniqueIDServiceImpl extends RemoteServiceServlet implements
		UniqueIDService {

	private static final long serialVersionUID = -8355612980477933670L;

	private static String searchUniqueIDUrl = "https://api.unoidme.appspot.com/SearchUniqueIDService";

	private static String getUniqueIDUrl = "https://api.unoidme.appspot.com/GetUniqueIDService";

	private static String addFoundedUrl = "https://api.unoidme.appspot.com/AddFoundedService";

	private static String addContactUrl = "https://api.unoidme.appspot.com/AddContactToGroupService";

	private static String addGroupUrl = "https://api.unoidme.appspot.com/AddGroupService";

	private static String listFoundedUrl = "https://api.unoidme.appspot.com/ListFoundedService";

	private static String listContactsUrl = "https://api.unoidme.appspot.com/ListContactsFromGroupService";

	private static String listGroupsUrl = "https://api.unoidme.appspot.com/ListGroupsService";

	private static String renameGroupUrl = "https://api.unoidme.appspot.com/RenameMainGroupService";

	public String getUniqueID(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters);

		return jsonString;
	}

	public String getUniqueIDByField(final String fieldName,
			final String fieldValue) {

		String parameters = "fieldName=" + fieldName + "&fieldValue="
				+ fieldValue;

		final String jsonString = URLUtilities.fetchURLPost(searchUniqueIDUrl,
				parameters);

		return jsonString;
	}

	public String saveUniqueID(String unoUserJsonString) {

		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(unoUserJsonString);
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		unoUserJsonString = SaveUniqueID.save(json);

		return unoUserJsonString;
	}

	public void addFounded(final String uniqueID, final String foundedID) {

		String parameters = "UniqueID=" + uniqueID + "&FoundedID=" + foundedID;

		URLUtilities.fetchURLPost(addFoundedUrl, parameters);
	}

	public void addContact(final String groupID, final String contactID) {

		String parameters = "groupID=" + groupID + "&ContactID=" + contactID;

		URLUtilities.fetchURLPost(addContactUrl, parameters);
	}

	public void addGroup(final String uniqueID, final String groupName) {

		String parameters = "UniqueID=" + uniqueID + "&Group=" + groupName;

		URLUtilities.fetchURLPost(addGroupUrl, parameters);
	}

	public String listFounded(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(listFoundedUrl,
				parameters);

		return jsonString;
	}

	public String listContacts(final String groupID) {

		String parameters = "groupID=" + groupID;

		final String jsonString = URLUtilities.fetchURLPost(listContactsUrl,
				parameters);

		return jsonString;
	}

	public String listGroups(final String uniqueID) {

		String parameters = "UniqueID=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(listGroupsUrl,
				parameters);

		return jsonString;
	}

	public void renameMainGroup(final String uniqueID, final String groupName) {

		String parameters = "UniqueID=" + uniqueID + "&MainGroupName="
				+ groupName;

		URLUtilities.fetchURLPost(renameGroupUrl, parameters);

	}
}
