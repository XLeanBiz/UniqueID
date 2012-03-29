package co.uniqueid.client.home;

import co.uniqueid.client.entity.GetUniqueID;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SearchField extends HorizontalPanel {

	private TextBox search = new TextBox();

	public SearchField() {

		this.setSpacing(5);

		search.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {

					Location.assign(GWT.getHostPageBaseURL() + "?search="
							+ search.getValue());
				}
			}
		});
		this.add(search);

		this.add(buttonSearch());
	}

	public Button buttonSearch() {

		Button save = new Button("Search");

		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Location.assign(GWT.getHostPageBaseURL() + "?search="
						+ search.getValue());
			}
		});

		return save;
	}

	public static void doSearch(final String search, String field) {

		if (field == null) {

			GetUniqueID.getFromField("ID", search);

		} else if (field.contains("facebook")) {

			GetUniqueID.getFromField("facebookLogin", search);

		} else if ("ID".equals(field)) {

			GetUniqueID.getFromID(search);
		}
	}
}
