package co.uniqueid.client.home;

import co.uniqueid.client.entity.edit.AddButton;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public Home() {

		this.setSpacing(40);
		
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new HTML("<font size=4><b>UNIQUE ID</b></font>"));

		this.add(new AddButton());

		this.add(new SearchField());
	}
}
