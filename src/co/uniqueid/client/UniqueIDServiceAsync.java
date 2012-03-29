package co.uniqueid.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UniqueIDServiceAsync {

	void getUniqueID(String unoUserID, AsyncCallback<String> callback);

	void saveUniqueID(String unoUserJsonString, AsyncCallback<String> callback);

	void getUniqueIDByField(String fieldName, String fieldValue,
			AsyncCallback<String> callback);

	void addFounded(String uniqueID, String foundedID,
			AsyncCallback<Void> callback);

	void addContact(String uniqueID, String contactID,
			AsyncCallback<Void> callback);

	void listFounded(String uniqueID, AsyncCallback<String> callback);

	void listContacts(String uniqueID, AsyncCallback<String> callback);
}
