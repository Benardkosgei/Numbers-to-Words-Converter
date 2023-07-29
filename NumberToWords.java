import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWords {

    public static void main(String[] args) {
        //Get user input
        Scanner scnr = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter a number between 0 and 1,000,000: ");

            try {
                if (scnr.hasNextInt()) {
                    number = scnr.nextInt();
                    if (number >= 0 && number <= 1_000_000) {
                        break; // Valid input, break the loop
                    } else {
                        System.out.println("Invalid input! Please enter a number between 0 and 1,000,000.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scnr.next(); // Consume the invalid input
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scnr.next(); // Consume the invalid input
            }
        } while (true);

        scnr.close();

        // Convert the number to words
        Converter converter = new Converter();
        String result = converter.convertToWords(number);

        // Writing the result to an output file
        String outputFileName = "output.txt";
        try {
            FileWriter writer = new FileWriter(outputFileName);
            writer.write(result);
            writer.close();
            System.out.println(result);
            System.out.println("Translated words have been written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

class Converter {
    private static final String[] onesWords = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teensWords = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tensWords = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] thousandsWords = {
            "", "thousand", "million"
    };

    public String convertToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        String words = "";
        int place = 0;
        // Convert number in groups of three digits (thousands, millions.)
        do {
            int n = number % 1000;
            if (n != 0) {
                String word = convertThreeDigitNumberToWords(n);
                words = word + thousandsWords[place] + " " + words;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return words.trim();
    }
    // Convert a three-digit number to words
    private String convertThreeDigitNumberToWords(int number) {
        String word = "";

        if (number >= 100) {
            word += onesWords[number / 100] + " hundred ";
            number %= 100;
        }

        if (number >= 20) {
            word += tensWords[number / 10] + " ";
            number %= 10;
        } else if (number >= 10) {
            word += teensWords[number - 10] + " ";
            number = 0;
            // Skip ones place as it's already covered by teensWords
        }

        if (number > 0) {
            word += onesWords[number] + " ";
        }

        return word;
    }

    // Overloaded Method to Convert Long to Words
    public String convertToWords(long number) {
        if (number < 0 || number > 1_000_000) {
            return "Invalid input! Please enter a number between 0 and 1,000,000.";
        }

        return convertToWords((int) number);
    }

    // Count the number of words in a given sentence
    public int countWords(String words) {
        return words.trim().isEmpty() ? 0 : words.trim().split("\\s+").length;
    }
    // Check if a number is prime
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    // Calculate the sum of digits in a number
    public int sumDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    // Reverse the words in a sentence
    public String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }

        return reversedSentence.toString().trim();
    }
    // Maximum value in an array
    public int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
    // Minimum value in an array
    public int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}
