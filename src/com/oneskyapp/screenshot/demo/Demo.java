package com.oneskyapp.screenshot.demo;

import com.oneskyapp.screenshot.OneSkyScreenshotHelper;

import android.app.Application;
import android.view.Gravity;

public class Demo extends Application {

	@Override
	public void onCreate(){		
		
		OneSkyScreenshotHelper.getHelper().setApiKey("YOUR API KEY");
		OneSkyScreenshotHelper.getHelper().setApiSecret("YOUR API SECRET");
		OneSkyScreenshotHelper.getHelper().setProjectId("YOUR PROJECT ID");
		
		OneSkyScreenshotHelper.getHelper().setCaptureButtonGravity(Gravity.LEFT | Gravity.BOTTOM);
		OneSkyScreenshotHelper.getHelper().startCapturing(this);
	}
}
