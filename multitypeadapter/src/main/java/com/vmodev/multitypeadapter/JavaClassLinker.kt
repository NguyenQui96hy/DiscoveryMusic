package com.vmodev.multitypeadapter

/**
 * An interface to link the items and binders by the classes of binders.
 *
 * @author Drakeet Xu
 */
interface JavaClassLinker<T> {

    /**
     * Returns the class of your registered binders for your item.
     *
     * @param position The position in items
     * @param item The item
     * @return The index of your registered binders
     * @see OneToManyEndpoint.withJavaClassLinker
     */
    fun index(position: Int, item: T): Class<out ItemViewBinder<T, *>>
}
