package com.vmodev.multitypeadapter

data class Type<T>(
    val clazz: Class<out T>,
    val binder: ItemViewBinder<T, *>,
    val linker: Linker<T>
)
