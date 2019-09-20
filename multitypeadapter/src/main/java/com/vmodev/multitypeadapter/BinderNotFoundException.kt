package com.utehy.discovermusic.utils.multitypeadapter

/**
 * @author Drakeet Xu
 */
internal class BinderNotFoundException(clazz: Class<*>) : RuntimeException(
    "Have you registered the ${clazz.name} type and its binder to the adapter or type list?"
)
