package com.jdoran.numbers

/**
 * Created by johndoran on 04/09/15.
 */
class NumberToWordsConverter {
  private static final String NEGATIVE = "Negative"

  private List supportedLanguages = ["en"]
  private String currentLanguage = "en"
  private List normalNumbers = []
  private List tensNumbers = []

  public NumberToWordsConverter(String language) {
    if (!supportedLanguages.contains(language)) {
      throw new HumanReadableNumberException("Unsupported language")
    }

    currentLanguage = language
    normalNumbers = new File("src/main/resources/normal-numbers-${language}.txt")?.readLines()
    tensNumbers = new File("src/main/resources/tens-numbers-${language}.txt")?.readLines()
  }


  public String convertToWords(int number) {

    if (number < 0) {
      return NEGATIVE
    }

    if (numberIsBetweenZeroAndNineteen(number)) {
      return normalNumbers[number]
    }

    if (number < 100) {
      return getReadableNumberForLessThanOneHundred(number)
    }

    if (number <= 999) {
      return gerReadableNumberForLessThanOneThousand(number)
    }

    throw new HumanReadableNumberException("Number Formatter doesn't handle more than 1000")
  }

  private String gerReadableNumberForLessThanOneThousand(int number) {
    def  startNumber = Math.floor(number / 100.toDouble())
    def no = normalNumbers[startNumber.toInteger()] + " Hundred"


    def remainder = number % 100
    if (remainder != 0) {
      if(remainder<20) {
        no += " and " + normalNumbers[remainder]
      }else{
        no += " and " + getReadableNumberForLessThanOneHundred(remainder)
      }
    }
    return no
  }

  private String getReadableNumberForLessThanOneHundred(int number) {
    def tenNumberIndex = number / 10 - 1
    def readableNumber = tensNumbers[tenNumberIndex.toInteger()]

    if (number % 10 != 0) {
      readableNumber += " " + normalNumbers[number % 10.toInteger()]
    }
    return readableNumber

  }

  private boolean numberIsBetweenZeroAndNineteen(int number) {
    number < 20 && number > 0
  }

}
