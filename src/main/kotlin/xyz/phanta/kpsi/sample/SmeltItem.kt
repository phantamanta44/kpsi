package xyz.phanta.kpsi.sample

import xyz.phanta.kpsi.spell

fun main() {
    spell {
        trickSmeltItem(selectorCaster().raycast().let {
            selectorNearbySmeltables(it, constantNumber(1.5)).closest(it)
        })
    }.asGraphStream().display()
}
