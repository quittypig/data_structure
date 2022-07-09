package com.datastructure.example.heap


fun main() {
    val heap = Heap()

    heap.insert(1)
    heap.insert(2)
    heap.insert(3)
    heap.insert(4)
    println(heap.nodes) // 4 3 2 1

    heap.remove()
    println(heap.nodes) // 3 1 2

    heap.remove()
    println(heap.nodes) // 2 1

    heap.remove()
    println(heap.nodes) // 1

    heap.insert(5)
    println(heap.nodes) // 5 1

    heap.remove()
    println(heap.nodes) // 1


    heap.remove()
    println(heap.nodes) // []


    heap.insert(1)
    heap.insert(2)
    heap.insert(3)
    heap.insert(4)
    println(heap.nodes) // 4 3 2 1
}
