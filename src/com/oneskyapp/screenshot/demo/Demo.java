package com.oneskyapp.screenshot.demo;

import android.app.Application;

import com.oneskyapp.screenshot.OneSkyScreenshotHelper;

public class Demo extends Application {

	@Override
	public void onCreate(){		
		
		OneSkyScreenshotHelper.getHelper().setApiKey("YOUR API KEY");
		OneSkyScreenshotHelper.getHelper().setApiSecret("YOUR API SECRET");
		OneSkyScreenshotHelper.getHelper().setProjectId("YOUR PROJECT ID");
		
		OneSkyScreenshotHelper.getHelper().startCapturing(this);
	}
}
