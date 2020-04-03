# IconTextFx
![](https://jitpack.io/v/Stars-One/IconTextFx.svg)	

为JavaFx/Tornadofx实现的字体图标控件,基于Text控件

已经整合Material Desgin Icon,包含5000+个字体图标,字体图标来源[Material Design](https://github.com/Templarian/MaterialDesign)

## 使用说明
### 1.导入依赖
**Maven:**

打开maven目录中`setting.xml`文件,添加下面代码
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

在你项目中的`pom.xml`添加依赖

**PS:在上述图片jitpack中可以看到最新的版本号**

```
<dependency>
	<groupId>com.github.Stars-One</groupId>
	<artifactId>IconTextFx</artifactId>
	<version>最新版本号</version>
</dependency>
```

**Gradle:**

添加仓库:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

添加依赖:

**PS:在上述图片jitpack中可以看到最新的版本号**
```
dependencies {
	implementation 'com.github.Stars-One:IconTextFx:最新版本号'
}	
```

### 2.Use
**TornadoFx使用**



|name	|descption	|example	|
|--	|--	|--	|
|iconName	|字体图标对应的名字	|account,在`icon-preview.html`页面可以查看更多|
|size	|字体的大小|接受带单位的字符串,如1px,1em|
|color|字体颜色|接受十六进制颜色代码或颜色名称,如#f391c8,red...	|

```
icontext("account","20px","red"){
	
}
```

**JavaFx使用:**

**PS:我并没有在JavaFx项目中测试过此开源库,如果你遇到问题请新建一个issue,告诉我你遇到的问题**

你可以使用`MaterialDesignIconText`或`MaterialDesignIconTextFactory`这两个类类获得对应的字体图标


**例如:**
```
MaterialDesignIconText iconText = new MaterialDesignIconText("account");
//设置颜色
iconText.setColor("red");
//设置字体大小
iconText.setSize("20px");
```

**上面的三个参数和上述表格中的参数类型一样**

## 高级使用
### MaterialDesignIconTextFactory

如果你想一次性获得多个图标字体,你可以使用此工厂类来获取

**例如:**

```
//通过图标名获得一个图标
val icon = MaterialDesignIconTextFactory.getIconText("account")

//通过一个存有多个图标名的List来获得多个图标
val dataList = arraylistof("account","close")
val icons = MaterialDesignIconTextFactory.getIconTextList(dataList)

//获得全部图标
val icons = MaterialDesignIconTextFactory.getIconTextALL()

```
### IconText
你可以使用这个来加载自定义tff字体文件来显示字体图标

```
val iconText = IconText("D:\\xx.ttf",'\ue001')
```

此类也包含有`setColor`和`setSize`方法,参数接收和上面的表格一样
## 核心代码分析

如何去实现一个字体图标?很简单


1. 加载tff文件
2. 获得对应的unicode
3. 设置text控件的text属性为unicode

**例如:**
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

**使用JavaFx也是一样:**

```
Text text = Text()
text.setFont = xx
text.setText('\ue001'.toString());
text.setStyle("-fx-font-size:18px");
text.setStyle("-fx-fill:red");
```

**注意:**

实际上,大部分的unicode本质上是一个十六进制数据,如`'\ue001'` 对应`0xe001`

## 致谢

- [Material Design](https://github.com/Templarian/MaterialDesign)
- [MaterialDesign-Font](https://github.com/Templarian/MaterialDesign-Font)
- [tornadofx](https://github.com/edvin/tornadofx)
- [fonteditor](https://github.com/ecomfe/fonteditor)