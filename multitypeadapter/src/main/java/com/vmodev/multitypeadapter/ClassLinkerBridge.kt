package com.vmodev.multitypeadapter

/**
 * @author Drakeet Xu
 */
internal class ClassLinkerBridge<T> private constructor(
    private val javaClassLinker: JavaClassLinker<T>,
    private val binders: Array<ItemViewBinder<T, *>>
) : Linker<T> {

    override fun index(position: Int, item: T): Int {
        val indexedClass = javaClassLinker.index(position, item)
        for (i in binders.indices) {
            if (binders[i].javaClass == indexedClass) {
                return i
            }
        }
        throw IndexOutOfBoundsException(
            "The binders'(${binders.contentToString()}) you registered do not contain this ${indexedClass.name}."
        )
    }

    companion object {
        fun <T> toLinker(
            javaClassLinker: JavaClassLinker<T>,
            binders: Array<ItemViewBinder<T, *>>
        ): Linker<T> {
            return ClassLinkerBridge(javaClassLinker, binders)
        }
    }
}
