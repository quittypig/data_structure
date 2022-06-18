package com.datastructure.example.sort

class BubbleSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("BubbleSort Start! $numbers")

            for (i in numbers.size - 1 downTo 1) {
                for (j in 0 until i) {
                    if (numbers[j] > numbers[j + 1]) {
                        swap(numbers, j, j + 1)
                    }
                }

                println(numbers)
            }

            println("BubbleSort End!")
        }

        private fun swap(numbers: MutableList<Int>, min: Int, i: Int) {
            val temp = numbers[min]

            numbers[min] = numbers[i]
            numbers[i] = temp
        }
    }
}
