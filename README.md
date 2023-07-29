 # Number to Words Converter

This repository contains a Java program that converts a given integer (between 0 and 1,000,000) into its corresponding English words representation. The program reads user input, performs the conversion, and writes the result to an output file. Additionally, the program includes a class with utility methods for various functionalities, such as counting words in a sentence, checking if a number is prime, finding the sum of digits in a number, reversing words in a sentence, finding the maximum and minimum values in an array.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [How to Use](#how-to-use)
- [Converter Class](#converter-class)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This Java program provides a user-friendly interface to convert a given integer to its English words representation. It uses the `Converter` class, which contains methods for performing the conversion and various other utility functions.

## Getting Started

To run the number-to-words converter on your local machine, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your computer. You can download it from the Oracle website or use an OpenJDK distribution.

2. Clone this GitHub repository to your local machine using Git or download the ZIP file and extract it.

3. Navigate to the project directory containing the `NumberToWords.java` file.

4. Compile the Java source code using the following command:

   ```
   javac NumberToWords.java
   ```

5. After successful compilation, run the program with:

   ```
   java NumberToWords
   ```

## How to Use

1. Upon running the `NumberToWords` program, you will be prompted to enter a number between 0 and 1,000,000.

2. Enter a valid integer within the specified range and press Enter.

3. The program will convert the entered number into its English words representation and display the result on the console.

4. The program will also write the result to an output file named `output.txt`, which will be created in the same directory as the program.

## Converter Class

### Overview

The `Converter` class contains various utility methods for performing the number-to-words conversion and other functionalities. Here are the key methods:

- `String convertToWords(int number)`: Converts an integer to its corresponding English words representation.

- `String convertToWords(long number)`: Overloaded method to convert a `long` to words by calling the `convertToWords(int number)` method.

- `int countWords(String words)`: Counts the number of words in a given sentence.

- `boolean isPrime(int number)`: Checks if a number is prime.

- `int sumDigits(int number)`: Calculates the sum of digits in a number.

- `String reverseWords(String sentence)`: Reverses the words in a sentence.

- `int findMax(int[] array)`: Finds the maximum value in an array of integers.

- `int findMin(int[] array)`: Finds the minimum value in an array of integers.

### Usage

The `Converter` class is used by the main program (`NumberToWords.java`) to perform the number-to-words conversion. It contains methods that can be reused in other Java applications for different utility functionalities.

## Contributing

If you find any issues with the code or have suggestions for improvement, feel free to open an issue or submit a pull request. We welcome contributions from the community!

## License

This project is licensed under the MIT License. You can find the details in the [LICENSE](LICENSE) file.

---

Thank you for using the Number to Words Converter program. Happy number-to-words conversion!
