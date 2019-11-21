#PackageManagerHelper Android Library to get app related information 

[![](https://jitpack.io/v/rddewan/PackageManagerHelper.svg)](https://jitpack.io/#rddewan/PackageManagerHelper)

1. add maven { url 'https://jitpack.io' } to top level gradle build

```
allprojects {

    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }

    }
}
```

2. add dependencies  TAG = check for the current version
```
implementation 'com.github.rddewan:PackageManagerHelper:Tag'
```

3. Create new object of PackageManagerHelper passing the context
```
PackageManagerHelper packageManagerHelper = new PackageManagerHelper(this);

//setter method  to set a unique device id 
packageManagerHelper.setDeviceId(deviceId);
```

4. get the list of installed app info
```
ArrayList<InstalledAppProperty> list = packageManagerHelper.getInstalledAppInfo();

//sort the list by app name
Collections.sort(appList,InstalledAppEntity.appNameComparator)


```
