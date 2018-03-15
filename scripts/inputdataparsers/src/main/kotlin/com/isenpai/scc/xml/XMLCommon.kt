package com.isenpai.scc.xml

import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList

/*
Some useful extension methods for parsing XML.
*/

operator fun NodeList.get(index: Int): Element = this.item(index) as Element

fun <T> NodeList.map(block: (Element) -> T): List<T> {
    val list = mutableListOf<T>()
    this.forEach {
        list.add(block(it))
    }
    return list
}

fun NodeList.forEach(block: (Element) -> Unit) {
    for(i in 0 until this.length) {
        if(this.item(i) is Element) {
            block(this[i])
        }
    }
}

fun Node.findElementByTagName(tagName: String): Element? {
    for(i in 0 until this.childNodes.length) {
        val node = this.childNodes.item(i)
        if(node is Element) {
            if(node.tagName == tagName) {
                return this.childNodes[i]
            }
        }
    }

    return null
}