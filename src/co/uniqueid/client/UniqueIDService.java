package co.uniqueid.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("uniqueID")
public interface UniqueIDService extends RemoteService {

	String getUniqueID(final String unoUserID);

	String getUniqueIDByField(final String fieldName, final String fieldValue);

	String saveUniqueID(final String unoUserJsonString);
	
	void addFounded(final String uniqueID, final String foundedID);
	
	void addContact(final String groupID, final String contactID);
	
	void addGroup(final String uniqueID, final String groupName);
	
	String listFounded(final String uniqueID);
	
	String listContacts(final String groupID);
	
	String listGroups(final String uniqueID);
	
	void renameMainGroup(final String uniqueID, final String groupName);
}
