package com.starsone.icontext.view

import com.starsone.icontext.MaterialDesignIconTextFactory
import tornadofx.*


class MainView :View() {

    override var root = vbox {
        setPrefSize(500.0, 300.0)

        /*text {
            font = loadFont("/ttf/MaterialDesignIconsDesktop.ttf", 20)
            val c = 61928
            text = c.toChar().toString()
            style {
                fontSize = 2.em
                fill = c("red")
            }
        }*/
//        this += MaterialDesignIconTextFactory.getIconText("vector-square")
        val list = MaterialDesignIconTextFactory.getIconTextALL()
//        val list = MaterialDesignIconTextFactory.getIconTextList("card-plus", "map-marker-question", "chart-pie", "flower-tulip-outline")

        scrollpane {
            vbox {
                gridpane {
                    var row = 0
                    var l = 0
                    list.forEachIndexed { index, materialDesignIconText ->

                        add(materialDesignIconText, l, row)
                        l++
                        if (index != 0 && index % 90 == 0) {
                            row++
                            l = 0
                        }
                    }
                }
            }
        }
    }

}

