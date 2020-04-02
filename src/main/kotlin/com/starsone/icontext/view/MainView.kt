package com.starsone.icontext.view

import com.starsone.icontext.MaterialDesignIconTextFactory
import tornadofx.*


class MainView :View() {

    override var root = vbox {
        setPrefSize(500.0, 300.0)

        val list = MaterialDesignIconTextFactory.getIconTextALL()

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

