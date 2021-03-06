package co.uniqueid.client.entity.page;

import co.uniqueid.client.Utilities.ConvertJson;
import co.uniqueid.client.entity.slideshow.Slideshow;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EntityPage extends VerticalPanel {

	public static VerticalPanel vpSlideShow = new VerticalPanel();

	public static FlexTable gridFounded = new FlexTable();

	public static VerticalPanel vpGroups = new VerticalPanel();

	public EntityPage(final JSONObject entityJson, final String group) {
		
		this.setWidth("100%");

		String uniqueID = ConvertJson.convertToString(entityJson.get("ID"));

		VerticalPanel vp = new VerticalPanel();
		vp.add(new EntityContactsPanel(entityJson));

		if (entityJson.get("Founded") != null) {

			ListFounded.list(uniqueID);

			String mainGroupName = ConvertJson.convertToString(entityJson
					.get("MainGroupName"));

			if (mainGroupName == null || "".equals(mainGroupName)) {
				mainGroupName = "Founded";
			}

			gridFounded.clear();
			gridFounded.setHTML(0, 0, "<font size=3 color=red><b>"
					+ mainGroupName + ":</b></font>");
			gridFounded.getColumnFormatter().setWidth(1, "250px");
			gridFounded.getColumnFormatter().setWidth(3, "30px");

			vp.add(gridFounded);
		}

		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("100%");
		hp.add(vp);

		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vpSlideShow.clear();
		hp.add(vpSlideShow);
		this.add(hp);

		startSlideShow(entityJson);

		vpGroups.clear();
		this.add(vpGroups);

		ListGroups.list(uniqueID, group);
	}

	private void startSlideShow(JSONObject entityJson) {

		vpSlideShow.clear();

		Slideshow.entities.clear();

		vpSlideShow.add(Slideshow.panelImage);

		Slideshow.addEntity(entityJson);

		new Slideshow();
	}
}
