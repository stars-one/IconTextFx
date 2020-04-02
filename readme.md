# IconTextFx
![](https://jitpack.io/v/Stars-One/IconTextFx.svg)	
a control which extends Text and can use awesome font icon for JavaFx/Tornadofx

## Use
### 1.Import
**Maven:**

open the `setting.xml `file and add following code
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

add the dependency in your `pom.xml`

Input the late-version,**please look the jitpack picture to get the late version**
```
<dependency>
	<groupId>com.github.Stars-One</groupId>
	<artifactId>IconTextFx</artifactId>
	<version>late-version</version>
</dependency>
```

**Gradle:**

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency

```
dependencies {
	implementation 'com.github.Stars-One:IconTextFx:late-version'
}	
```

### 2.Use MaterialIconText

## Main Code
```
text {
	font = loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20)
	val c = 61928
	text = c.toChar().toString()
	style {
		fontSize = 2.em
		fill = c("red")
	}
}
```
## Thanks