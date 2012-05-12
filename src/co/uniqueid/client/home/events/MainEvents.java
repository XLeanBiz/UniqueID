package co.uniqueid.client.home.events;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainEvents extends VerticalPanel {

	public MainEvents() {

		this.setSpacing(5);

		HTML html = new HTML("<b>RECENT EVENTS:</b>");
		this.add(html);

		this.add(listGroups());
	}

	private static VerticalPanel listGroups() {

		VerticalPanel vpMainEvent = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(40);
		vpMainEvent.add(hp);

		VerticalPanel vpEvent1 = new VerticalPanel();
		hp.add(vpEvent1);
		GetMainEvents.getFromID("CustDevDay_1332642931554", null, vpEvent1);

		VerticalPanel vpEventIOBio = new VerticalPanel();
		hp.add(vpEventIOBio);
		GetMainEvents.getFromID("IoBio_1336784483609", null, vpEventIOBio);

		VerticalPanel vpEvent5 = new VerticalPanel();
		hp.add(vpEvent5);
		GetMainEvents.getFromID("HackersAndFounders_1334342737882", null,
				vpEvent5);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setSpacing(40);
		vpMainEvent.add(hp2);

		VerticalPanel vpEvent4 = new VerticalPanel();
		hp2.add(vpEvent4);
		GetMainEvents.getFromID("LeanStartupMachine_1333817778070", null,
				vpEvent4);

		VerticalPanel vpEvent3 = new VerticalPanel();
		hp2.add(vpEvent3);
		GetMainEvents.getFromID("AnsirInnovationCenter_1333132928482", null,
				vpEvent3);

		VerticalPanel vpEvent2 = new VerticalPanel();
		hp2.add(vpEvent2);
		GetMainEvents.getFromID(
				"AlchemistSeriesCustomerDevelopment_1332897337108",
				"March 2012", vpEvent2);

		return vpMainEvent;
	}

}
