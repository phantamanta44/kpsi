package xyz.phanta.kpsi.sample

import xyz.phanta.kpsi.spell

fun main() {
    spell {
        selectorCaster().debug()
    }.asGraphStream().display()
}
