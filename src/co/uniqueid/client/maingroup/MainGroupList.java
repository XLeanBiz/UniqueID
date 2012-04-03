package co.uniqueid.client.maingroup;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class MainGroupList extends HorizontalPanel {

	public MainGroupList(final String foundedUniqueID) {

		this.setSpacing(10);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HorizontalPanel hpPhoto = new HorizontalPanel();

		this.add(hpPhoto);

		GetMainGroupUniqueID.getFromID(foundedUniqueID, hpPhoto);

	}

}
