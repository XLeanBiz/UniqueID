package co.uniqueid.server;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.client.UniqueIDService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UniqueIDServiceImpl extends RemoteServiceServlet implements
		UniqueIDService {

	private static final long serialVersionUID = -8355612980477933670L;

	private static String searchUniqueIDUrl = "http://api.unoidme.appspot.com/SearchUniqueIDService";

	private static String getUniqueIDUrl = "http://api.unoidme.appspot.com/GetUniqueIDService";
	
	private static String addFoundedUrl = "http://api.unoidme.appspot.com/AddFoundedService";

	public String getUnoUser(final String uniqueID) {

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

	public String saveUnoUser(String unoUserJsonString) {

		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(unoUserJsonString);
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		unoUserJsonString = SaveUniqueID.save(json);

		return unoUserJsonString;
	}
	
	public String addFounded(final String uniqueID, final String foundedID) {

		String parameters = "UniqueID=" + uniqueID + "&FoundedID="
				+ foundedID;

		final String jsonString = URLUtilities.fetchURLPost(addFoundedUrl,
				parameters);

		return jsonString;
	}

}
