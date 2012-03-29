package co.uniqueid.client;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.facebook.LoginWithFacebookButton;
import co.uniqueid.client.Utilities.LoadingPanel;
import co.uniqueid.client.contacts.ContactsPanel;
import co.uniqueid.client.entity.EntityPanel;
import co.uniqueid.client.entity.GetUniqueID;
import co.uniqueid.client.founded.FoundedPanel;
import co.uniqueid.client.home.Home;
import co.uniqueid.client.home.SearchField;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InitializeUniqueIDAppllication extends VerticalPanel {

	public static VerticalPanel vpMain = new VerticalPanel();

	private static final String FacebookAppID = "411608055520713";
	// private static final String FacebookAppID = "194243253971053";
	private static final String Facebook_REDIRECT_URL = "http://www.uniqueid.co/";

	public static void init(final String ID) {

		init(ID, null, null);
	}

	public static void init(final String ID, final String search,
			final String field) {

		RootPanel.get().add(vpMain);

		vpMain.clear();
		vpMain.add(new LoadingPanel());

		if (ID != null) {

			GetUniqueID.getFromID(ID, true);

		} else if (search != null) {

			SearchField.doSearch(search, field);

		} else {

			vpMain.clear();
			vpMain.add(new Home());
		}
	}

	public static void InitializeEntity(JSONObject entityJsonObject) {

		vpMain.clear();
		vpMain.add(new EntityPanel(entityJsonObject));

		vpMain.add(new FoundedPanel(entityJsonObject));

		vpMain.add(new ContactsPanel(entityJsonObject));
	}

	public static LoginWithFacebookButton InitializeFacebookLogin() {

		return new LoginWithFacebookButton(FacebookAppID, Facebook_REDIRECT_URL);
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(FacebookAppID, authenticationCode,
				Facebook_REDIRECT_URL);
	}

	public static void InitializeFacebookPanel() {

		FacebookLoginPanel.setPanel(FacebookAppID, Facebook_REDIRECT_URL);
	}

}
