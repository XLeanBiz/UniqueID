package co.uniqueid.client;

import co.uniqueid.client.Utilities.LoadingPanel;
import co.uniqueid.client.home.Home;
import co.uniqueid.client.home.MainPanel;
import co.uniqueid.client.home.SearchField;

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

		MainPanel.vpMain.clear();
		MainPanel.vpMain.add(new LoadingPanel());
		RootPanel.get().add(MainPanel.vpMain);

		final String search = Location.getParameter("search");
		final String field = Location.getParameter("field");

		if (search != null) {

			SearchField.doSearch(search, field);

		} else {

			MainPanel.vpMain.clear();
			MainPanel.vpMain.add(new Home());
		}
	}
}
