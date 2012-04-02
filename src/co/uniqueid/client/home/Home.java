package co.uniqueid.client.home;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.entity.edit.AddButton;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Home extends VerticalPanel {

	public Home() {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		this.add(new FacebookFeedbackButton());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new UniqueIDLogo());

		this.add(new HTML("MVP #2"));

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(20);
		hp.add(new AddButton());
		hp.add(new Label(" or "));
		hp.add(InitializeUniqueIDAppllication.InitializeFacebookLogin());
		this.add(hp);

		this.add(new SearchField());

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.add(new MainGroups());
	}
}
