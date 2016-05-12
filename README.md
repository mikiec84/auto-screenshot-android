OneSky Auto Screenshot Library for Android
======================================

This library helps you easily upload screenshots of your app that contains localizable strings to your OneSky project.

**NOTE:** This library is **not designed for distribution** on Google Play Store so remember to **remove** before submission.

Installation
------------
**NOTE**: _This library is now available on maven central (`v0.7.0` or above), if you are updating from previous versions, remove the github repository block from `pom.xml` or `build.gradle`_

You can install this plugin manually or use maven/gradle to apply the plugin to your project.


**Android Studio/Gradle**

Add the follow code to your ```build.gradle```
```java
	dependencies {
		// other dependencies.
	    compile "com.oneskyapp:screenshot:0.7.6"
	}
```

**Remote Maven Repository**

Add the follow code to your ```pom.xml```
```xml
	<dependencies>
		<dependency>
			<groupId>com.oneskyapp</groupId>
			<artifactId>screenshot</artifactId>
			<version>0.7.6</version>
        </dependency>
	</dependencies>
```

**Download .jar file to ```libs``` folder**

1. Download [`OneSkyScreenshotHelper-v0.7.6.jar`](https://github.com/onesky/auto-screenshot-android/releases/download/v0.7.6/OneSkyScreenshotHelper-v0.7.6.jar) in the release tab in this GitHub page and drag it into the ```libs``` folder of your project.
2. On Eclipse you are good to go.
3. On Android Studio, locate the ```build.gradle``` file under your app's module and add the following:

```java
	dependencies {
		compile files("OneSkyScreenshotHelper-v0.7.6.jar")
	}
```

Integration
-----------

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest>
	<!-- Internet permission for uploading screenshots to OneSky server -->
	<uses-permission android:name="android.permission.INTERNET"/>

	<application>
		<!-- declare service for screenshot button -->
		<service android:name="com.oneskyapp.screenshot.ScreenshotButtonService" />
	</application>

</manifest>
```

In your ```Application``` or main ```Activity``` subclass file, import the library:

```java
import com.oneskyapp.screenshot.OneSkyScreenshotHelper;
```

Add the following code in under ```onCreate()```:

```java
OneSkyScreenshotHelper.getHelper().setApiKey("ONESKY_API_KEY");
OneSkyScreenshotHelper.getHelper().setApiSecret("ONESKY_API_SECRET");
OneSkyScreenshotHelper.getHelper().setProjectId("ONESKY_PROJECT_ID");

// Auto loading string resources is now removed to support Android Studio 2.0 Instant Run
// so you will need to manually specify the resource classes that contain the identifiers
OneSkyScreenshotHelper.getHelper().startCapturing(this, R.string.class, R.array.class);
// for Activity subclasses, use startCapturing(this.getApplication())
```

```ONESKY_API_KEY```, ```ONESKY_API_SECRET``` can be found in **Site Settings** under **API Keys & Usage** on **OneSky Web Admin**.
```ONESKY_PROJECT_ID``` can be found under **All Projects** page.

**NOTE:** The above parameters must be set before calling ```startCapturing()```.

Advance Settings
----------------

Turn off capture status ```Toast``` updates.
```java
OneSkyScreenshotHelper.getHelper().setShowsCaptureStatus(false);
```

Turn on/off debug messages in your logs.
```java
OneSkyScreenshotHelper.getHelper().setDebug(true);
```

Support
-------
http://support.oneskyapp.com/
