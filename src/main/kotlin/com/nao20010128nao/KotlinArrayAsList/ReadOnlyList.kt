package com.nao20010128nao.KotlinArrayAsList

interface ReadOnlyList<E> : MutableList<E> {
    override fun add(element: E): Boolean = unsupported()
    override fun add(index: Int, element: E): Unit = unsupported()
    override fun addAll(index: Int, elements: Collection<E>): Boolean = unsupported()
    override fun addAll(elements: Collection<E>): Boolean = unsupported()
    override fun clear(): Unit = unsupported()
    override fun remove(element: E): Boolean = unsupported()
    override fun removeAll(elements: Collection<E>): Boolean = unsupported()
    override fun removeAt(index: Int): E = unsupported()
    override fun retainAll(elements: Collection<E>): Boolean = unsupported()
}

