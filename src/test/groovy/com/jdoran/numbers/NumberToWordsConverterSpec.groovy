package com.jdoran.numbers

import spock.lang.Specification

/**
 * Created by johndoran on 04/09/15.
 */
class NumberToWordsConverterSpec extends Specification {

  private NumberToWordsConverter converter

  void setup() {
    converter = new NumberToWordsConverter("en")
  }


  def "should not handle more than one thousand"(){
    when:
    converter.convertToWords(1001)

    then:
    HumanReadableNumberException ex = thrown()
    assert ex.message == "Number Formatter doesn't handle more than 1000"
  }

  def "should not allow unsupported language"() {
    when:
    new NumberToWordsConverter("zh")

    then:
    HumanReadableNumberException ex = thrown()

    assert ex.message == "Unsupported language"
  }

  def "should convert small numbers"(int number, String humanReadable) {
    given:
    def readableString = converter.convertToWords(number)

    expect:
    assert readableString == humanReadable

    where:
    number | humanReadable
    1      | "One"
    2      | "Two"
    3      | "Three"
    4      | "Four"
    5      | "Five"
    6      | "Six"
    7      | "Seven"
    8      | "Eight"
    9      | "Nine"
    10     | "Ten"
    11     | "Eleven"
    12     | "Twelve"
    13     | "Thirteen"
    14     | "Fourteen"
    15     | "Fifteen"
    16     | "Sixteen"
    17     | "Seventeen"
    18     | "Eighteen"
    19     | "Nineteen"
    20     | "Twenty"
  }

  def "should handle negative numbers elegantly"(){
    given:
    def readableString = converter.convertToWords(-20)

    expect:
    assert readableString == "Negative"
  }

  def "should convert numbers in the twenties"(int number, String humanReadable) {
    given:
    def readableString = converter.convertToWords(number)

    expect:
    assert readableString == humanReadable

    where:
    number | humanReadable
    20     | "Twenty"
    22     | "Twenty Two"
    25     | "Twenty Five"
    26     | "Twenty Six"
    28     | "Twenty Eight"
    29     | "Twenty Nine"
  }

  def "should convert numbers in hundreds"(int number, String humanReadable) {
    given:
    def readableString = converter.convertToWords(number)

    expect:
    assert readableString == humanReadable

    where:
    number | humanReadable
    100    | "One Hundred"
    105    | "One Hundred and Five"
    115    | "One Hundred and Fifteen"
    125    | "One Hundred and Twenty Five"
    135    | "One Hundred and Thirty Five"
    222    | "Two Hundred and Twenty Two"
    333    | "Three Hundred and Thirty Three"
    444    | "Four Hundred and Forty Four"
    555    | "Five Hundred and Fifty Five"
    666    | "Six Hundred and Sixty Six"
    777    | "Seven Hundred and Seventy Seven"
    888    | "Eight Hundred and Eighty Eight"
    999    | "Nine Hundred and Ninety Nine"
  }

}
