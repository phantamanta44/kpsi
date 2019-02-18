package xyz.phanta.kpsi.sample

import xyz.phanta.kpsi.spell

fun main() {
    spell {
        trickDebug(selectorCaster())
    }.asGraphStream().display()
}
