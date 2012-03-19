package co.uniqueid.client.entity.edit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopupEntity extends PopupPanel {

	public PopupEntity(final JSONObject unoUserJson) {

		this.setWidget(new EditEntity(unoUserJson, this));

		this.setAutoHideEnabled(true);
	}

	public static HTML getCloseButton(final PopupPanel panel) {

		HTML imageClose = new HTML("<a href=#><img src='images/close.gif' border=0></a>");

		imageClose.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				panel.hide();
			}
		});

		return imageClose;
	}
}
