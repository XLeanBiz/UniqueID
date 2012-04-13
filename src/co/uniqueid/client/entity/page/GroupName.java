package co.uniqueid.client.entity.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class GroupName extends HorizontalPanel {

	public GroupName(final String entityUniqueID, final String groupName) {

		this.setSpacing(15);

		HTML html = new HTML("<font size=3><b><a href=#>" + groupName
				+ "</a></b></font>");

		html.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Location.assign(GWT.getHostPageBaseURL() + "?ID="
						+ entityUniqueID + "&group=" + groupName);
			}
		});

		this.add(html);

	}

}
