package co.uniqueid.client.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainGroups extends VerticalPanel {

	public MainGroups() {

		this.setSpacing(5);

		HTML html = new HTML("<b>Main Groups:</b>");
		this.add(html);

		this.add(listGroups());
	}

	private static VerticalPanel listGroups() {

		VerticalPanel vpMainGroups = new VerticalPanel();

		vpMainGroups.setSpacing(15);

		Anchor group1 = new Anchor("Customer Development Day");
		group1.addClickHandler(getClickHandler("CustDevDay_1332642931554"));
		vpMainGroups.add(group1);

		Anchor group2 = new Anchor(
				"Alchemist Series: CustomerDevelopment & Metrics");
		group2.addClickHandler(getClickHandler("AlchemistSeriesCustomerDevelopment_1332897337108"));
		vpMainGroups.add(group2);

		return vpMainGroups;
	}

	private static ClickHandler getClickHandler(final String groupUniqueID) {

		return (new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Location.assign(GWT.getHostPageBaseURL() + "?ID="
						+ groupUniqueID);
			}
		});
	}

}
