package com.vmodev.multitypeadapter

internal class DefaultLinker<T> : Linker<T> {
    override fun index(position: Int, item: T): Int = 0
}
