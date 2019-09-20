package com.vmodev.multitypeadapter

import android.support.annotation.CheckResult


/**
 * Process and flow operators for one-to-many.
 *
 * @author Drakeet Xu
 */
interface OneToManyFlow<T> {

    /**
     * Sets some item view binders to the item type.
     *
     * @param binders the item view binders
     * @return end flow operator
     */
    @CheckResult
    fun to(vararg binders: ItemViewBinder<T, *>): OneToManyEndpoint<T>
}
