package xyz.phanta.kpsi.sample

import xyz.phanta.kpsi.spell

fun main() {
    spell {
        trickBreakInSequence(
            selectorCaster().raycast(),
            selectorRulerVector().let { it + it.norm() },
            constantNumber(12)
        )
    }.asGraphStream().display()
}
