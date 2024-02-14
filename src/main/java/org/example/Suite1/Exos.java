package org.example.Suite1;

import org.example.Suite1.Address;
import org.example.Suite1.City;
import org.example.Suite1.Company;
import org.example.Suite1.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Utilities {

    /*
    Find the sum of all even numbers in a list of integers.
     */
    public static int findSumOfAllEvenNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(x -> x)
                .filter((num) -> num % 2 == 0)
                .sum();
    }

    /*
    Find and print the count of strings that have length greater than 5.
     */
    public static long countStringsWithLengthMoreThan5(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 5)
                .count();
    }

    /*
    Implement a function that takes a list of integers as input and returns a new list containing the square of each element.
     */
    public static List<Integer> getListOfSquares(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .toList();
    }

    /*
    Find the maximum element in a list of integers.
     */
    public static int findMax(List<Integer> list) {
        return list.stream()
                .mapToInt(x -> x)
                .max()
                .orElseThrow(RuntimeException::new);
    }


    /*
    Find the min element in a list of integers.
     */
    public static int findMin(List<Integer> list) {
        return list.stream()
                .mapToInt(x -> x)
                .min()
                .orElseThrow(RuntimeException::new);
    }

    /*
    Concatenate all the strings in a list into a single string ( 2 ways)
     */
    public static String concatenateStrings(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(" "));
    }

    /*
    Convert each string to uppercase, remove white spaces in the begining and the end and then sort them in alphabetical order.
     */
    public static List<String> convertStrings(List<String> list) {
        return list.stream()
                .map(s -> s.toUpperCase().trim())
                .sorted()
                .toList();
    }

    /*
    Find the average of all the numbers in a list of doubles using Streams.
     */
    public static double findAverage(List<Double> nums) {
        return nums.stream()
                .mapToDouble(x -> x)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    /*
    Create a new list that contains only unique words (remove duplicates).
     */
    public static List<String> getUniqueWords(List<String> strings) {
        return strings.stream()
                .distinct()
                .toList();
    }

    /*
    Check if all elements in a List of integer are greater than 2
     */
    public static boolean checkIfGreaterThan2(List<Integer> nums) {
        return nums.stream()
                .allMatch(x -> x > 2);

    }

    /*
    Check if a list of string contains a specific element strating with the letter X in lower case or Upper case
     */
    public static boolean containsElementStartsWithX(List<String> strings) {
        return strings.stream()
                .anyMatch(s -> s.startsWith("x") || s.startsWith("X"));
    }

    /*
    Find the longest string in a list using streams.
     */
    public static String findLongestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(RuntimeException::new);
    }

    /*
    Remove null values from a list using streams.
     */
    public static List<Object> removeNullValues(List<Object> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .toList();
    }

    /*
    Find Second Smallest Element in a List
     */
    public static int findSecondSmallest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
    /*
    Find Intersection of Two Lists
     */

    public static List<Integer> findIntersection(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(list2::contains)
                .toList();
    }

    /*
    Given a List of List of String, find the strings containing letter 'A'
     */
    public static List<String> findStringsContainingA(List<List<String>> list) {
        return list.stream()
                .flatMap(l -> l.stream().filter(s -> s.contains("a")))
                .toList();
    }


    //exos suite 1
    /*
    get the city name of the companies addresses
     */
    public static List<String> getCityNames(List<Company> companyList) {
        return companyList.stream()
                .map(company -> company.getAddress().getCity().getName())
                .toList();
    }

    /*
    get the city name of the companies addresses with null checks
     */
    public static List<String> getCityNamesWithNullChecks(List<Company> companyList) {
        return companyList.stream()
                .map(company -> Optional.ofNullable(company.getAddress())
                        .map(Address::getCity)
                        .map(City::getName).orElse(""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    /*
    gets the person list from all companies.
     */
    public static List<Person> getAllPerson(List<Company> companyList) {
        return companyList.stream()
                .map(company -> Optional.ofNullable(company.getPersonList()).orElse(Collections.emptyList()))
                .filter(list -> !list.isEmpty())
                .flatMap(Collection::stream)
                .toList();
    }

    /*
    Map with a List of Company of each city
     */

    public static Map<City, List<Company>> getCompaniesByCity(List<Company> companyList) {

        return companyList.stream()
                .collect(Collectors.groupingBy(
                        company -> Optional.ofNullable(company.getAddress()).map(Address::getCity).orElseThrow()
                        , Collectors.toList()));

    }

    /*
    Check if there is a company in some city
     */
    public static boolean hasCompanyInCity(List<Company> companyList, String cityName) {
        return companyList.stream()
                .map(company -> Optional.ofNullable(company.getAddress())
                        .map(Address::getCity).map(City::getName).orElse(""))
                .filter(s -> !s.isEmpty())
                .anyMatch(name -> name.equals(cityName));
    }
    /*
    write a log for each city name returned
    */

    List<String> getCityNamesWithLog(List<Company> companyList) {
        return companyList.stream()
                .map(company -> Optional.ofNullable(company.getAddress())
                        .map(Address::getCity)
                        .map(City::getName).orElse(""))
                .filter(s -> !s.isEmpty())
                .peek((c) -> System.out.println("city returned " + c))
                .toList();
    }

    /*
    Get unique city names
     */
    public static List<String> getUniqueCityNames(List<Company> companyList) {
        return companyList.stream()
                .map(company -> Optional.ofNullable(company.getAddress())
                        .map(Address::getCity).map(City::getName).orElse(""))
                .filter(s -> !s.isEmpty())
                .distinct()
                .toList();
    }
}