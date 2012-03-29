package co.uniqueid.client;

import com.google.gwt.core.client.EntryPoint;
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
		
		RootPanel.get().add(InitializeUniqueIDAppllication.vpMain);

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

	}
}
