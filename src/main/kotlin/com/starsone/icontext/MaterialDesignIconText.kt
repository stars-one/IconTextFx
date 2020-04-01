package com.starsone.icontext

import javafx.scene.text.Font
import javafx.scene.text.Text
import tornadofx.*
import java.util.*



/**
 *
 * @author StarsOne
 * @date Create in  2020/3/31 0031 22:37
 * @description
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
    var name:String = ""

    constructor(unicode: Char,myFont: Font? = null) : this() {
        font = myFont ?: loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20.0)
        text = unicode.toString()
    }

    constructor(text: String,myFont: Font? = null) : this() {
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

data class IconData(
        val `data`: String,
        var hex: String,
        val name: String,
        val version: String
)
