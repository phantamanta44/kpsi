package xyz.phanta.kpsi.sample

import xyz.phanta.kpsi.spell

fun main() {
    spell {
        // get starting point for line of blocks
        val caster = selectorCaster()
        val startPoint = operatorVectorRaycast(operatorEntityPosition(caster), operatorEntityLook(caster))

        // get vector of blocks to break
        val ruler = selectorRulerVector()
        val rulerPlusOne = operatorVectorSum(ruler, operatorVectorNormalize(ruler))

        // break the blocks
        trickBreakInSequence(startPoint, rulerPlusOne, constantNumber(12))
    }.asGraphStream().display()
}
