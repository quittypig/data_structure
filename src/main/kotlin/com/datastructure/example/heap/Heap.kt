package com.datastructure.example.heap

class Heap {
    private var heapSize = 0
    private val _nodes = mutableListOf<Int?>()

    val nodes: List<Int?>
        get() {
            return _nodes.toList()
        }

    fun insert(data: Int) {
        var currentIndex: Int? = heapSize

        _nodes.add(data)

        if (heapSize++ == 0) {
            return
        }

        while (true) {
            val paraentIndex = getParentIndex(currentIndex!!) ?: break
            val paraentData = getData(paraentIndex)!!
            val currentData = getData(currentIndex)!!

            if (paraentData < currentData) {
                swap(paraentIndex, currentIndex)
            }

            currentIndex = getParentIndex(currentIndex) ?: break
        }
    }

    fun remove() {
        if (getRootData() == null) {
            return
        }

        var lastIndex = --heapSize

        swap(0, lastIndex)

        _nodes.removeLast()

        if (lastIndex == 0) {
            return
        }

        var currentIndex = 0
        while (true) {
            val currentData = getData(currentIndex)!!
            val leftIndex = getLeftIndex(currentIndex)
            val leftData = getData(leftIndex) ?: break
            val rightIndex = getRightIndex(currentIndex)
            val rightData = getData(rightIndex) ?: break

            if (leftData >= rightData && currentData < leftData) {
                swap(currentIndex, leftIndex)

                currentIndex = leftIndex

                break
            }

            if (leftData <= rightData && currentData < rightData) {
                swap(currentIndex, rightIndex)

                currentIndex = rightIndex
            }

            break
        }
    }

    private fun getRootData(): Int? {
        return getData(0)
    }

    private fun getData(index: Int): Int? {
        return _nodes.getOrNull(index)
    }

    private fun getParentIndex(index: Int): Int? {
        return if (index == 0) {
            null
        } else if (index % 2 == 0) {
            (index - 1) / 2
        } else {
            index / 2
        }
    }

    private fun getLeftIndex(index: Int): Int {
        return index * 2 + 1
    }

    private fun getRightIndex(index: Int): Int {
        return index * 2 + 2
    }

    private fun swap(firstIndex: Int, secondIndex: Int) {
        val temp = _nodes[firstIndex]

        _nodes[firstIndex] = _nodes[secondIndex]

        _nodes[secondIndex] = temp
    }
}
