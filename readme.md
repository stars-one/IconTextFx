# IconTextFx
![](https://jitpack.io/v/Stars-One/IconTextFx.svg)	

a control which extends Text and can use awesome font icon for JavaFx/Tornadofx

This liarbay includes the materical icon from [Material Design](https://github.com/Templarian/MaterialDesign),you can download the `icon-preview.html` to see the icon

[中文文档](https://github.com/Stars-One/IconTextFx/blob/master/readme_cn.md)

## Usage
### 1.Import depdendency
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
**Step 2.** Add the dependency

```
dependencies {
	implementation 'com.github.Stars-One:IconTextFx:late-version'
}	
```

### 2.Use
**Use in TornadoFx:**

There is 3 parmas for it.All of them is String.

|name	|descption	|example	|
|--	|--	|--	|
|iconName	|the name of icon	|account,you can see more in the `icon-preview.html` file|
|size	|the size of icon|accept number with unit,like 1px,1em...|
|color|the color of icon	|accept hex color value or color name,like #f391c8,red...	|

```
icontext("account","20px","red"){
	
}
```

**Use in JavaFx:**

**Note:I don't test this library in JavaFx Project.So please open an issue to tell me the bug when you meet some problem in JavaFx.**

You can use the MaterialDesignIconText or MaterialDesignIconTextFactory to get the icon text control.

**like this:**
```
MaterialDesignIconText iconText = new MaterialDesignIconText("account");
//set the color
iconText.setColor("red");
//set the size
iconText.setSize("20px");
```

**The parameter is same as the above-mentioned table.**

## Advanced Usage
### MaterialDesignIconTextFactory

when you want to get more icon text,you can use this factory to get the icon text.

like this:

```
//want to get a icon by icon name
val icon = MaterialDesignIconTextFactory.getIcon("account")

//want to get icons with a list saving more icon name
val dataList = arraylistof("account","close")
val icons = MaterialDesignIconTextFactory.getIconTextList(dataList)

//want to get all icons
val icons = MaterialDesignIconTextFactory.getIconTextALL()

```
### IconText
you can use this to load your custom tff file and show the icon font.

```
val iconText = IconText("D:\\xx.ttf",'\ue001')
```

**Note: the method of setColor and setSize are same as the above-mentioned table.**
## Main Code Analysis

How to accomlish a icon text?It's so easy.

1. load the tff file
2. get the unicode
3. set unicoe to the text control

**like following code:**
```
text {
	font = loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20)
	text = '\ue001'.toChar().toString()
	style {
		fontSize = 2.em
		fill = c("red")
	}
}
```

it's same as when you use javafx.

**Note:**

In fact,the most unicode value is a hex data.For example,'\ue001' mapping the hex data `0xe001`

## Thanks

- [Material Design](https://github.com/Templarian/MaterialDesign)
- [MaterialDesign-Font](https://github.com/Templarian/MaterialDesign-Font)
- [tornadofx](https://github.com/edvin/tornadofx)
- [fonteditor](https://github.com/ecomfe/fonteditor)