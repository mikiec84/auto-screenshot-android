OneSky Auto Screenshot Library for Android
======================================

This library helps you easily upload screenshots of your app that contains localizable strings to your OneSky project.

**NOTE:** This library is **not designed for distribution** on Google Play Store so remember to **remove** before submission.

Installation
------------

**1) Download .jar file ```libs``` folder**

1. Download [`OneSkyScreenshotHelper-v0.6.3.jar`](https://github.com/onesky/auto-screenshot-android/releases/download/v0.6.3/OneSkyScreenshotHelper-v0.6.3.jar) in the release tab in this GitHub page and drag it into the ```libs``` folder of your project.
2. On Eclipse you are good to go.
3. On Android Studio, locate the ```build.gradle``` file under your app's module and add the following:

```java
	dependencies {
		compile files("OneSkyScreenshotHelper-v0.6.3.jar")
	}
```

**2) Remote Maven Repository**

Add the follow code to your ```pom.xml```
```xml
	<dependencies>
		<dependency>
			<groupId>com.oneskyapp</groupId>
			<artifactId>screenshot</artifactId>
			<version>0.6.3</version>
        </dependency>
	</dependencies>

	<repositories>
		<repository>
		    <id>screenshot</id>
			<name>OneSkyScreenshotHelper</name>
			<url>https://raw.github.com/onesky/auto-screenshot-android/mvn-repo/</url>
		</repository>
	</repositories>
```

**3) Android Studio/Gradle**

Add the follow code to your ```build.gradle```
```java
	repositories {
		// mavenCentral()
    	maven {
        	url "https://raw.github.com/onesky/auto-screenshot-android/mvn-repo/"
    	}
	}

	dependencies {
		// other dependencies.
	    compile "com.oneskyapp:screenshot:0.6.3"
	}
```

Integration
-----------

In your ```Application``` or main ```Activity``` subclass file, import the library:

```java
import com.oneskyapp.screenshot.OneSkyScreenshotHelper;
```

Add the following code in under ```onCreate()```:

```java
OneSkyScreenshotHelper.getHelper().setApiKey("ONESKY_API_KEY");
OneSkyScreenshotHelper.getHelper().setApiSecret("ONESKY_API_SECRET");
OneSkyScreenshotHelper.getHelper().setProjectId("ONESKY_PROJECT_ID");

OneSkyScreenshotHelper.getHelper().startCapturing(this); // for Activity subclasses, use startCapturing(this.getApplication())
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

The default position of the screenshot button is bottom right of the main window, you can adjust using ```Gravity```.
```java
OneSkyScreenshotHelper.getHelper().setCatpureButtonGravity(Gravity.TOP | Gravity.LEFT);
```

Turn on/off debug messages in your logs.
```java
OneSkyScreenshotHelper.getHelper().setDebug(true);
```

By default the helper looks for string resources of your app using DexFile and Reflection automatically. If you  experience trouble getting the helper to load the string resources, you can provide specific string resource classes.
```java
OneSkyScreenshotHelper.getHelper().setResourceClasses(R.string, R.array);
```


Support
-------
http://support.oneskyapp.com/
