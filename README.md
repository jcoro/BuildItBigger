# BuildItBigger
This App is Project 4 for the Udacity Android Developer Nanodegree. BuidItBigger implements Gradle, Java & Android Libraries, and Google Cloud Endpoints to produce a joke telling app.

![BuildItBigger](http://www.coronite.net/assets/img/github/project4-1.png)
![BuildItBigger](http://www.coronite.net/assets/img/github/project4-2.png)

## Android Features / Libraries Implemented:

- [Gradle AppEngine Plugin](https://github.com/GoogleCloudPlatform/gradle-appengine-plugin)
- [Flavors and Build Variants](https://developer.android.com/studio/build/build-variants.html)
- [Java Library Module](https://developer.android.com/studio/projects/index.html)
- [Android Library Module](https://developer.android.com/studio/projects/index.html)
- [Google Cloud Endpoints](https://cloud.google.com/appengine/docs/java/endpoints/calling-from-android)
- [AdMob](https://firebase.google.com/docs/admob/android/quick-start)


## Specifications
- `compileSdkVersion 24`
- `buildToolsVersion "24.0.1"`
- `minSdkVersion 15`
- `targetSdkVersion 23`

## Dependencies
```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile project(':javajokes')
    compile project(':androidlibrary')
    // Added for AdMob
    freeCompile 'com.google.android.gms:play-services:9.2.1'
    compile 'com.android.support:appcompat-v7:24.1.1'
    compile project(path: ':backend', configuration: 'android-endpoints')
}
```


## Implementation

To test AdMob ads in the free version, the app-level build.gradle file defines a test-device id as follows:
```
buildTypes.each {
        it.buildConfigField 'String', 'TEST_DEVICE_ID', ' "5305B8C6893FE4F3FF66234C569F0D5A" '
    }
```

Check logcat output for the hashed device ID of your particular device.


This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

If you have any questions I'd be happy to try and help. Please contact me at: john@coronite.net.

# License
This is a public domain work under [CC0 1.0](https://creativecommons.org/publicdomain/zero/1.0/). Feel free to use it as you see fit.