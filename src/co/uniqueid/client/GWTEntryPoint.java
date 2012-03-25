package co.uniqueid.client;

import co.uniqueid.client.Utilities.LoadingPanel;
import co.uniqueid.client.home.Home;
import co.uniqueid.client.home.SearchField;

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

		vpMain.clear();
		vpMain.add(new LoadingPanel());
		RootPanel.get().add(vpMain);

		final String search = Location.getParameter("search");
		final String field = Location.getParameter("field");

		if (search != null) {

			SearchField.doSearch(search, field);

		} else {

			vpMain.clear();
			vpMain.add(new Home());
		}
	}
}
