package co.uniqueid.client.header;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.client.InitializeUniqueIDAppllication;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Header extends VerticalPanel {

	public Header() {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		hp.add(new UniqueIDLogoSmall());

		Label space = new Label(" ");
		space.setWidth("200px");
		hp.add(space);

		hp.add(FacebookLoginPanel.hpFacebookLogin);
		InitializeUniqueIDAppllication.InitializeFacebookLogin();

		hp.add(new FacebookFeedbackButton());

		this.add(hp);

		this.add(new HTML("<hr>"));

	}

}
