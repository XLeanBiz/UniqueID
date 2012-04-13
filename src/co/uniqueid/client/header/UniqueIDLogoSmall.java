package co.uniqueid.client.header;

import co.uniqueid.client.InitializeUniqueIDAppllication;
import co.uniqueid.client.home.Home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class UniqueIDLogoSmall extends HTML {

	public UniqueIDLogoSmall() {

		this.setHTML("<a href=#><img src='images/UniqueIDLogo_small.jpg' border=0 height=35></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				InitializeUniqueIDAppllication.vpMain.clear();
				InitializeUniqueIDAppllication.vpMain.add(new Home());
			}
		});
	}
}
