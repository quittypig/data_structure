package com.datastructure.example.sort

class SelectionSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("SelectSort Start! $numbers")

            for (i in numbers.indices) {
                var min = i

                for (j in (i + 1) until numbers.size) {
                    if (numbers[min] > numbers[j]) {
                        min = j
                    }
                }

                swap(numbers, min, i)

                println(numbers)
            }

            println("SelectSort End!")
        }

        private fun swap(numbers: MutableList<Int>, min: Int, i: Int) {
            val temp = numbers[min]

            numbers[min] = numbers[i]
            numbers[i] = temp
        }
    }
}
