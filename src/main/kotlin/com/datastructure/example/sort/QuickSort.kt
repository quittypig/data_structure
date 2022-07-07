package com.datastructure.example.sort

class QuickSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("QuickSort Start! $numbers")

            quick(numbers, 0, numbers.size - 1)

            println(numbers)

            println("QuickSort End!")
        }

        private fun swap(numbers: MutableList<Int>, min: Int, i: Int) {
            val temp = numbers[min]

            numbers[min] = numbers[i]
            numbers[i] = temp
        }

        fun quick(numbers: MutableList<Int>, left: Int, right: Int) {
            val pivotIndex = partition(numbers, left, right)
            if (left < pivotIndex - 1) quick(numbers, left, pivotIndex - 1)
            if (right > pivotIndex) quick(numbers, pivotIndex, right)
        }

        fun partition(numbers: MutableList<Int>, left: Int, right: Int): Int {
            val pivot = numbers[(left + right) / 2]
            var start = left
            var end = right

            while (start <= end) {
                while (numbers[start] < pivot) {
                    start++
                }

                while (numbers[end] > pivot) {
                    end--
                }

                if (start <= end) {
                    swap(numbers, start, end)
                    start++
                    end--
                }
            }

            return start
        }
    }
}
