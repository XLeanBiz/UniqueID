package co.uniqueid.client.home;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.client.InitializeUniqueIDAppllication;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class Header extends HorizontalPanel {

	public Header() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label space = new Label(" ");
		space.setWidth("500px");
		this.add(space);

		this.add(FacebookLoginPanel.hpFacebookLogin);
		InitializeUniqueIDAppllication.InitializeFacebookPanel();

	}

}
