package com.datastructure.example.sort

import kotlin.math.ceil

class MergeSort private constructor() {
    companion object {
        fun sort(numbers: MutableList<Int>) {
            println("MergeSort Start! $numbers")

            split(numbers)

            println("MergeSort End!")
        }

        private fun split(numbers: MutableList<Int>): MutableList<Int> {
            println("split: $numbers")

            if (numbers.size == 1) {
                return numbers
            }

            val middle = ceil((numbers.size.toDouble() / 2.toDouble())).toInt()
            val left = split(numbers.subList(0, middle))
            val right = split(numbers.subList(middle, numbers.size))

            return merge(left, right)
        }

        private fun merge(numbers1: MutableList<Int>, numbers2: MutableList<Int>): MutableList<Int> {
            val mergedNumbers: MutableList<Int> = mutableListOf()
            val numbers = numbers1.plus(numbers2).toMutableList()

            for (i in 1..numbers.size) {
                numbers.minOf { it }.apply {
                    mergedNumbers.add(this)

                    numbers.remove(this)
                }
            }

            println("merge: $mergedNumbers")

            return mergedNumbers
        }
    }
}
