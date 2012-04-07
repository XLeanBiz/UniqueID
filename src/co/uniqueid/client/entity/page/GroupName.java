package co.uniqueid.client.entity.page;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class GroupName extends HorizontalPanel {

	public GroupName(final String groupName) {

		this.setSpacing(15);

		HTML html = new HTML("<font size=3><b>" + groupName + "</b></font>");

		this.add(html);

	}

}
