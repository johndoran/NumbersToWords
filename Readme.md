## Numbers To Words
A little to convert numbers to human readable words. Only supports less than 1000 for now
1 = One
15 = Fifteen
192 = One Hundred and Ninety Two
543 = Three Hundred and Forty Three

## Installation/Code Example

./gradlew idea

See sample in Main.groovy
def converter = new NumberToWordsConverter("en")
println(converter.convertToWords(20))

## API Reference

NumberToWordsConverter is the main class, expects a supported locale(only english for now).
Throws an exception is an unsupported locale is supplied

## Tests/Documentation(your tests are your docs :>)

NumberToWordsConverterSpec

./gradlew test

## Contributors

JDoran