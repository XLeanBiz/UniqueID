package co.uniqueid.client;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.home.Header;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		String uniqueIDJson = EncryptText
				.decrypt(Cookies.getCookie("UniqueID"));

		if (uniqueIDJson == null || uniqueIDJson.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				InitializeUniqueIDAppllication
						.VerifyFacebookLogin(authenticationCode);
			} else {

				final String ID = Location.getParameter("ID");
				final String search = Location.getParameter("search");
				final String field = Location.getParameter("field");

				InitializeUniqueIDAppllication.init(ID, search, field);
			}

		} else {

			JSONObject obj = (JSONObject) JSONParser.parseStrict(uniqueIDJson);

			UniqueIDGlobalVariables.uniqueID = obj;

			RootPanel.get().add(new Header());

			String uniqueID = ConvertJson.convertToString(obj.get("ID"));

			InitializeUniqueIDAppllication.init(uniqueID);
		}

	}
}
