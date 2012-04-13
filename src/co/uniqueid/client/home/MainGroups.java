package co.uniqueid.client.home;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainGroups extends VerticalPanel {

	public MainGroups() {

		this.setSpacing(5);

		HTML html = new HTML("<b>EVENTS:</b>");
		this.add(html);

		this.add(listGroups());
	}

	private static VerticalPanel listGroups() {

		VerticalPanel vpMainGroups = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(40);
		vpMainGroups.add(hp);

		VerticalPanel vpGroup1 = new VerticalPanel();
		hp.add(vpGroup1);
		GetMainGroups.getFromID("CustDevDay_1332642931554", vpGroup1);

		VerticalPanel vpGroup2 = new VerticalPanel();
		hp.add(vpGroup2);
		GetMainGroups.getFromID(
				"AlchemistSeriesCustomerDevelopment_1332897337108", vpGroup2);

		VerticalPanel vpGroup3 = new VerticalPanel();
		hp.add(vpGroup3);
		GetMainGroups
				.getFromID("AnsirInnovationCenter_1333132928482", vpGroup3);

		return vpMainGroups;
	}

}
