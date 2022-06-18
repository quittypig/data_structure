package com.datastructure.example.sort

class InsertionSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("InsertionSort Start! $numbers")

            for (i in 1 until numbers.size) {
                for (j in i downTo 1) {
                    if (numbers[j] < numbers[j - 1]) {
                        swap(numbers, j, j - 1)
                    }
                }

                println(numbers)
            }

            println("InsertionSort End!")
        }

        private fun swap(numbers: MutableList<Int>, min: Int, i: Int) {
            val temp = numbers[min]

            numbers[min] = numbers[i]
            numbers[i] = temp
        }
    }
}
