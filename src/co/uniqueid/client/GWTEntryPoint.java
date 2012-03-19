package co.uniqueid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	public static VerticalPanel vpMain = new VerticalPanel();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String search = Location.getParameter("search");

		if (search != null) {

			GetUniqueID.getFromFacebookID(search);
		}

		RootPanel.get().add(vpMain);
	}
}
