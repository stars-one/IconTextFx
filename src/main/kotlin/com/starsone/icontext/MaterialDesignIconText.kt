package com.starsone.icontext

import javafx.event.EventTarget
import javafx.scene.text.Font
import javafx.scene.text.Text
import tornadofx.*
import java.util.*


/**
 *
 * @author StarsOne
 * @date Create in  2020/3/31 0031 22:37
 *
 */
class MaterialDesignIconTextFactory {

    companion object {
        private var myFont = loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20.0) as Font
        private var pro = MaterialProperties()

        @JvmStatic
        fun getIconText(iconName: String): MaterialDesignIconText {
            return MaterialDesignIconText(iconName, myFont)
        }

        @JvmStatic
        fun getIconTextList(vararg iconNames: String): List<MaterialDesignIconText> {
            pro.load(MaterialDesignIconTextFactory::class.java.getResourceAsStream("/mdIcon.properties"))
            val list = arrayListOf<MaterialDesignIconText>()
            iconNames.forEach {
                list.add(MaterialDesignIconText(it, myFont))
            }
            return list
        }

        @JvmStatic
        fun getIconTextALL(): List<MaterialDesignIconText> {
            pro.load(MaterialDesignIconTextFactory::class.java.getResourceAsStream("/mdIcon.properties"))
            val list = arrayListOf<MaterialDesignIconText>()

            pro.keys.forEach {
                list.add(MaterialDesignIconText(it.toString(), myFont))
            }
            return list
        }
    }
}

class MaterialDesignIconText() : Text() {
    var name: String = ""

    constructor(unicode: Char, myFont: Font? = null) : this() {
        font = myFont ?: loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20.0)
        text = unicode.toString()
    }

    constructor(text: String, myFont: Font? = null) : this() {
        //设置字体
        name = text
        font = myFont ?: loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20.0)
        val pro = Properties()
        pro.load(javaClass.getResourceAsStream("/mdIcon.properties"))
        //获得数字,转为char,转为string
        if (pro.containsKey(text)) {
            this.text = pro[text].toString().toInt().toChar().toString()
        } else {
            println("${text}对应图标不存在")
        }
    }

    /**
     * 设置字体大小为[size],可带单位,如px,em
     */
    fun setSize(size: String) {
        style ="-fx-font-size:$size;"
    }

    /**
     * 设置字体颜色为[color],color可以是16进制或者颜色名,如red
     */
    fun setColor(color: String) {
        style="-fx-fill:$color;"
    }

}

class MaterialProperties : Properties() {

    override val keys = LinkedHashSet<Any>()

    override fun keys(): Enumeration<Any> {
        return Collections.enumeration(keys)
    }

    override fun put(key: Any, value: Any): Any? {
        keys.add(key)
        return super.put(key, value)
    }

    override fun stringPropertyNames(): Set<String> {
        val set = LinkedHashSet<String>()

        for (key in this.keys) {
            set.add(key as String)
        }

        return set
    }

}


/**
 * 字体图标 MaterialDesignIconText
 * @param [color]可接受十六进制或字符串,例如red
 * @param [size]支持单位(pt,px,em,cm,ex)带单位 如1pt
 *
 */
fun EventTarget.icontext(iconName: String, size: String="", color: String = "", op: (MaterialDesignIconText.() -> Unit) = {}): MaterialDesignIconText {
    val iconText = MaterialDesignIconText(iconName)
    if (size.isNotBlank()) {
        iconText.style {
            if (size.isNotBlank()) {
                when {
                    size.contains("pt") -> fontSize = size.substringBefore("pt").toInt().pt
                    size.contains("px") -> fontSize = size.substringBefore("px").toInt().px
                    size.contains("em") -> fontSize = size.substringBefore("em").toInt().em
                    size.contains("cm") -> fontSize = size.substringBefore("cm").toInt().cm
                    size.contains("ex") -> fontSize = size.substringBefore("ex").toInt().ex
                }
            }
            if (color.isNotBlank()) {
                fill = c(color)
            }
        }
    }
    return opcr(this, iconText, op)
}

data class IconData(
        val `data`: String,
        var hex: String,
        val name: String,
        val version: String
)
