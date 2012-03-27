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
}
