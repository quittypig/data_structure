package com.datastructure.example.heap

var heapSize = 0
val heap = mutableListOf<Int?>()

fun main() {
    insert(1)
    insert(2)
    insert(3)
    insert(4)
    println(heap) // 4 3 2 1

    remove()
    println(heap) // 3 2 1

    remove()
    println(heap) // 2 1

    remove()
    println(heap) // 1

    insert(5)
    println(heap) // 5 1

    remove()
    println(heap) // 1


    remove()
    println(heap) // []


    insert(1)
    insert(2)
    insert(3)
    insert(4)
    println(heap) // 4 3 2 1
}

fun insert(data: Int) {
    var currentIndex: Int? = heapSize

    heap.add(data)

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

    heap.removeLast()

    if (lastIndex == 0) {
        return
    }

    var currentIndex = 0
    while (true) {
        val currentData = getData(currentIndex)!!

        val leftIndex = getLeftIndex(currentIndex)
        val leftData = getData(leftIndex) ?: break
        if (currentData < leftData) {
            swap(currentIndex, leftIndex)

            currentIndex = leftIndex

            break
        }

        val rightIndex = getRightIndex(currentIndex)
        val rightData = getData(rightIndex) ?: break
        if (currentData < rightData) {
            swap(currentIndex, rightIndex)

            currentIndex = rightIndex
        }

        break
    }
}

fun getRootData(): Int? {
    return getData(0)
}

fun getData(index: Int): Int? {
    return heap.getOrNull(index)
}

fun getParentIndex(index: Int): Int? {
    return if (index == 0) {
        null
    } else if (index % 2 == 0) {
        (index - 1) / 2
    } else {
        index / 2
    }
}

fun getLeftIndex(index: Int): Int {
    return index * 2 + 1
}

fun getRightIndex(index: Int): Int {
    return index * 2 + 2
}

fun swap(firstIndex: Int, secondIndex: Int) {
    val temp = heap[firstIndex]

    heap[firstIndex] = heap[secondIndex]

    heap[secondIndex] = temp
}
