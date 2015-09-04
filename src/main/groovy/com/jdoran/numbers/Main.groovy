package com.jdoran.numbers

/**
 * Created by johndoran on 04/09/15.
 */
class Main {

  static void main(String[] args) {
    NumberToWordsConverter converter = new NumberToWordsConverter("en")

    println(converter.convertToWords(1))
    println(converter.convertToWords(2))
    println(converter.convertToWords(15))
    println(converter.convertToWords(44))
    println(converter.convertToWords(99))
    println(converter.convertToWords(100))
    println(converter.convertToWords(192))
    println(converter.convertToWords(343))
    println(converter.convertToWords(500))
    println(converter.convertToWords(535))
    println(converter.convertToWords(923))
  }

}
