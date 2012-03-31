package co.uniqueid.client.Utilities;

public class UseTracking {

	public UseTracking(String trackingString) {

		useTrack(FeatureNameGenerator.getLastNameSpaced(trackingString, "\\."));
	}

	public static native void useTrack(String trackingString)/*-{

		//$wnd._gaq.push([ '_trackEvent', 'xlean', trackingString ])
		$wnd.mixpanel.track(trackingString);
	}-*/;
}
