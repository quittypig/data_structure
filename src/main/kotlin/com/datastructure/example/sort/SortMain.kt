package com.datastructure.example.sort

fun main() {
    SelectionSort.sort(mutableListOf(5, 4, 3, 2, 1))

    BubbleSort.sort(mutableListOf(5, 4, 3, 2, 1))

    InsertionSort.sort(mutableListOf(5, 4, 3, 2, 1))

    MergeSort.sort(mutableListOf(5, 7, 6, 2, 1))

    QuickSort.sort(mutableListOf(3, 2, 1))
    QuickSort.sort(mutableListOf(1, 2, 2, 3, 1, 4, 4, 4, 5, 6, 10, 3, 5, 7, 5, 4, 5, 6, 3, 1))

    HeapSort.sort(mutableListOf(5, 4, 3, 2, 1, 5,5,1,2,2,3,4))
}
