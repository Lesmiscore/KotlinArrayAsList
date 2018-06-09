package com.nao20010128nao.KotlinArrayAsList

class ArraysList<E>(private val array: Array<E>) : AbstractList<E>(), MutableList<E>, ReadOnlyList<E>, RandomAccess {
    override val size: Int = array.size
    override fun get(index: Int): E = array[index]
    override fun iterator(): MutableIterator<E> = listIterator()
    override fun listIterator(): MutableListIterator<E> = listIterator(0)
    override fun listIterator(index: Int): MutableListIterator<E> = ListIter(this, index)
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = MutableSubList(this, fromIndex, toIndex)

    override fun set(index: Int, element: E): E {
        val old = array[index]
        array[index] = element
        return old
    }

    private class ListIter<E>(private val list: MutableList<E>, index: Int) : MutableListIterator<E>, ListIterator<E> by list.listIterator(index) {
        override fun add(element: E) {
            unsupported()
        }

        override fun set(element: E) {
            list[nextIndex() - 1] = element
        }

        override fun remove() {
            unsupported()
        }
    }

    private class MutableSubList<E>(private val list: MutableList<E>, private val fromIndex: Int, toIndex: Int) : AbstractList<E>(), MutableList<E>, ReadOnlyList<E>, RandomAccess {
        override val size: Int = toIndex - fromIndex
        override fun get(index: Int): E = list[fromIndex + index]
        override fun set(index: Int, element: E): E = list.set(index, element)
        override fun listIterator(): MutableListIterator<E> = listIterator(0)
        override fun listIterator(index: Int): MutableListIterator<E> = ListIter(this, index)
        override fun iterator(): MutableIterator<E> = listIterator()
        override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = MutableSubList(this, fromIndex, toIndex)
    }
}