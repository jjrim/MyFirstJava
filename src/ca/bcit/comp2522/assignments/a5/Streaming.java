package ca.bcit.comp2522.assignments.a5;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;


import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * QUESTION1
 * First line indicates calls the list of integer as all collections can stream.
 * Second line, filters the integer
 * Then it adds up all the sum that is filtered by the second line.

 * QUESTION2
 * Creates the random number in a range [1,3) 1_000_000 times.
 * So it will create 1_000_000 of 1 or 2.
 * Then, it will count how many 1 and 2s are there and print it.

 * QUESTION9
 * We need to use StreamInt.of instead of Stream.of.
 * If we use Stream.of, it will not give you number because
 * int[ ] values = {1, 4, 9, 16} is not a data
 * structure that we can use for stream.
 */

/**
 * Represent Streaming Class.
 *
 * @author Jay Rim
 * @version 2020
 */
public class Streaming {
    /**
     * Minimum length of string.
     */
    public static final int STRING_MINIMUM_LENGTH = 10;
    /**
     * Number of Random Characters.
     */
    public static final int NUMBER_OF_RANDOM_CHARACTER = 30;
    /**
     * First character in ascii code.
     */
    public static final int ASCII_CHARACTER = 65;
    /**
     * Upper boundary for ascii code.
     */
    public static final int ASCII_BOUNDARY = 26;


    /**
     * Create array list with 30 random characters.
     *
     * @return array list of random characters
     */
    public static List<Character> words() {
        List<Character> randomCharacters = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_RANDOM_CHARACTER; i++) {
            char randomChar = (char) (ASCII_CHARACTER + random.nextInt(ASCII_BOUNDARY));
            randomCharacters.add(randomChar);
        }
        return randomCharacters;
    }


    /**
     * Sorts a arrayList of characters in ascending order.
     *
     * @param arrayList array list to sort
     * @return sorted list in ascending order
     */
    public static List<Character> ascendingSort(List<Character> arrayList) {
        System.out.print("Ascending sort: ");
        return arrayList
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }


    /**
     * Sorts a arrayList of characters in descending order.
     *
     * @param arrayList array list to sort
     * @return sortedList in descending order
     */
    public static List<Character> descendingSort(List<Character> arrayList) {
        System.out.print("Descending sort: ");
        return arrayList
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }


    /**
     * Sorts a arrayList of characters in descending order with no duplicates.
     *
     * @param arrayList arrayList to sort
     * @return sortedList
     */
    public static List<Character> descendingSortNoDuplicates(List<Character> arrayList) {
        System.out.print("Descending sort with no duplicates: ");
        List<Character> descendingSortedList = descendingSort(arrayList);
        return descendingSortedList
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * Filters arrayList by string length longer than 9 and print those filtered results.
     *
     * @param arrayList arrayList to filter
     */
    public static void lazyStream(List<String> arrayList) {
        System.out.println("Result of lazyStream. String length longer than 9 are");
        arrayList.stream()
                .filter(e -> e.length() > STRING_MINIMUM_LENGTH)
                .forEach(System.out::println);
    }


    /**
     * Separates a single string into character by character.
     *
     * @param input string as a parameter
     * @return characters
     */
    public static Stream<Character> characterStream(String input) {
        System.out.println("Result of characterStream.");
        return input.chars()
                .mapToObj(c -> (char) c);
    }


    /**
     * Driver for Streaming.
     * Tests methods created.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // testing random 30 characters
        List<Character> original = words();
        System.out.print("Random 30 words: ");
        for (int i = 0; i < NUMBER_OF_RANDOM_CHARACTER; i++) {
            System.out.print(original.get(i));
        }
        System.out.println("\n");
        // testing ascending sort
        List<Character> sortedAscending = ascendingSort(words());
        for (Character character : sortedAscending) {
            System.out.print(character);
        }
        System.out.println("\n");
        // testing descending sort
        List<Character> sortedDescending = descendingSort(words());
        for (Character character : sortedDescending) {
            System.out.print(character);
        }
        System.out.println("\n");
        // testing descending with no duplicates
        List<Character> sortedDescendingWithNoDuplicate = descendingSortNoDuplicates(words());
        for (Character character : sortedDescendingWithNoDuplicate) {
            System.out.print(character);
        }
        System.out.println("\n");
        List<String> stringList = new ArrayList<String>();
        //shorter than length 9
        stringList.add("");
        stringList.add("abcd");
        stringList.add("abcd abcd");
        // longer than length 9
        stringList.add("abcdabcdabcdabcdabcdabcd");
        // prints string longer than length 9 from the stringList
        lazyStream(stringList);
        System.out.print("\n");
        // prints a string by character by character
        String input = "ABCD";
        System.out.println("Original is " + input);
        Stream<Character> stringToChar = characterStream(input);
        stringToChar.forEach(System.out::println);
    }
}
