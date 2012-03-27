package co.uniqueid.client.founded;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class FoundedList extends HorizontalPanel {

	public FoundedList(final String foundedUniqueID) {

		this.setSpacing(10);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HorizontalPanel hpPhoto = new HorizontalPanel();

		this.add(hpPhoto);

		GetFoundedUniqueID.getFromID(foundedUniqueID, hpPhoto);

	}

}
