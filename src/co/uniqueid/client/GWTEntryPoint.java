package co.uniqueid.client;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.Utilities.UseTracking;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	// private static Logger logger = Logger.getLogger("UniqueID");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		new UseTracking(this.getClass().getName());

		String uniqueIDJson = EncryptText
				.decrypt(Cookies.getCookie("UniqueID"));

		// logger.log(Level.INFO, "uniqueIDJson=" + uniqueIDJson);

		String ID = Location.getParameter("ID");
		final String search = Location.getParameter("search");
		final String field = Location.getParameter("field");
		final String group = Location.getParameter("group");

		if (uniqueIDJson == null || uniqueIDJson.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				InitializeUniqueIDAppllication
						.VerifyFacebookLogin(authenticationCode);

			} else {

				InitializeUniqueIDAppllication.init(ID, group, search, field);
			}

		} else {

			JSONObject obj = (JSONObject) JSONParser.parseStrict(uniqueIDJson);

			UniqueIDGlobalVariables.uniqueID = obj;

			if (ID == null) {

				String uniqueIDMe = ConvertJson.convertToString(obj.get("ID"));
				ID = uniqueIDMe;
			}

			InitializeUniqueIDAppllication.init(ID, group);
		}
	}

}
