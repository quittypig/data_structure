package com.datastructure.example.sort

import com.datastructure.example.heap.Heap

class HeapSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("HeapSort Start! $numbers")

            val heap = Heap()
            val sortedNumbers = mutableListOf<Int>()

            numbers.forEach { heap.insert(it) }

            while (heap.nodes.isNotEmpty()) {
                sortedNumbers.add(0, heap.rootNode!!)
                heap.remove()
            }

            println(sortedNumbers)

            println("HeapSort End!")
        }
    }
}
