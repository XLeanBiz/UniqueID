package co.uniqueid.client;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.client.Utilities.LoadingPanel;
import co.uniqueid.client.entity.EntityPanel;
import co.uniqueid.client.entity.GetUniqueID;
import co.uniqueid.client.groups.GroupsPanel;
import co.uniqueid.client.header.Header;
import co.uniqueid.client.home.Home;
import co.uniqueid.client.home.SearchField;
import co.uniqueid.client.maingroup.MainGroupPanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InitializeUniqueIDAppllication extends VerticalPanel {

	private static VerticalPanel vpRoot = new VerticalPanel();

	public static VerticalPanel vpMain = new VerticalPanel();

	private static final String FacebookAppID = "411608055520713";
	// private static final String FacebookAppID = "194243253971053";
	private static final String Facebook_REDIRECT_URL = "http://www.uniqueid.co/";

	private static void initRootPanel() {

		RootPanel.get().add(vpRoot, 8, 3);

		vpMain.setWidth("100%");
		vpRoot.setWidth("100%");

		vpRoot.add(new Header());

		vpRoot.add(vpMain);

	}

	public static void init(final String ID, final String group) {

		init(ID, group, null, null);
	}

	public static void init(final String ID, final String group,
			final String search, final String field) {

		InitializeUniqueIDAppllication.initRootPanel();

		vpMain.clear();
		vpMain.add(new LoadingPanel());

		if (ID != null) {

			GetUniqueID.getFromID(ID, group, true);

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

		vpMain.add(new MainGroupPanel(entityJsonObject));

		// vpMain.add(new ContactsPanel(entityJsonObject));

		vpMain.add(new GroupsPanel(entityJsonObject));
	}

	public static void InitializeFacebookLogin() {

		FacebookLoginPanel.setPanel(FacebookAppID, Facebook_REDIRECT_URL);
	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(FacebookAppID, authenticationCode,
				Facebook_REDIRECT_URL, Facebook_REDIRECT_URL);
	}

}
