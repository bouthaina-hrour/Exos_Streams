
import org.example.Suite1.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Suite1.Utilities.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamExosTests {

    @Test
    public void findSumOfAllEvenNumbersTest() {
        List<Integer> numbers = List.of(3, 2, 4, 7, 1, 0);
        assertEquals(findSumOfAllEvenNumbers(numbers), 6);
    }

    @Test
    public void countStringsWithLengthMoreThan5Test() {
        List<String> strings = List.of("hrour", "bouthaina", "codebusters", "hello");
        assertEquals(countStringsWithLengthMoreThan5(strings), 2);
    }

    @Test
    public void getListOfSquaresTest() {
        List<Integer> numbers = List.of(2, 0, -1, 7);
        assertEquals(getListOfSquares(numbers), List.of(4, 0, 1, 49));
    }

    @Test
    public void findMaxTest() {
        List<Integer> numbers = List.of(2, 0, -1, 7);
        assertEquals(findMax(numbers), 7);
    }

    @Test
    public void findMinTest() {
        List<Integer> numbers = List.of(2, 0, -1, 7);
        assertEquals(findMin(numbers), -1);
    }

    @Test
    public void concatenateStringTest() {
        List<String> strings = List.of("I", "love", "mama");
        assertEquals(concatenateStrings(strings), "I love mama");
    }

    @Test
    public void convertStringTest() {
        List<String> strings = List.of("      ma ma    ", "I", "love");
        assertEquals(convertStrings(strings), List.of("I", "LOVE", "MA MA"));
    }

    @Test
    public void findAverageTest() {
        List<Double> nums = List.of(1.5, 2.5, 3.5, 4.5, 5.5);
        assertEquals(findAverage(nums), 3.5);
    }

    @Test
    public void getUniqueWordsTest() {
        List<String> words = List.of("hrour", "bouthaina", "hrour");
        assertEquals(getUniqueWords(words).size(), 2);
    }

    @Test
    public void checkIfGreaterThanTwoTest() {
        List<Integer> numbers = List.of(2, 0, -1, 7);
        assertFalse(checkIfGreaterThan2(numbers));
    }

    @Test
    public void checkIfContainsElementStartingWithxTest() {
        List<String> words = List.of("Xhrour", "bouthaina", "hrour");
        assertTrue(containsElementStartsWithX(words));
    }

    @Test
    public void findLongestStringTest() {
        List<String> words = List.of("Xhrour", "bouthaina", "hrour");
        assertEquals(findLongestString(words), "bouthaina");
    }

    @Test
    public void removeNullValuesTest() {
        List<Object> list = new ArrayList<>();
        list.add("bouthaina");
        list.add(1);
        list.add(null);
        assertEquals(removeNullValues(list).size(), 2);
    }

    @Test
    public void getSecondSmallestElementTest() {
        List<Integer> list = List.of(5, 2, 1, 7, 9);
        assertEquals(findSecondSmallest(list), 2);
    }

    @Test
    public void findIntersectionTest() {
        List<Integer> list1 = List.of(5, 2, 1, 7, 9);
        List<Integer> list2 = List.of(5, 4, 7);
        assertEquals(findIntersection(list1, list2), List.of(5, 7));
    }

    @Test
    public void findStringsContainingATest() {
        List<List<String>> bigList = List.of(
                List.of("Ananas", "Banane"),
                List.of("Fraise", "kiwi"),
                List.of("Pomme", "Litchi")
        );
        assertEquals(findStringsContainingA(bigList), List.of("Ananas", "Banane", "Fraise"));
    }

    @Test
    public void getCityNamesTest() {
        // Create some sample companies with different cities
        City city1 = new City("City1", new State("State1"));
        City city2 = new City("City2", new State("State2"));
        City city3 = new City("City3", new State("State3"));

        Company company1 = new Company("c1", new Address("Street1", city1), new ArrayList<>());
        Company company2 = new Company("c2", new Address("Street2", city2), new ArrayList<>());
        Company company3 = new Company("c3", new Address("Street3", city1), new ArrayList<>());
        Company company4 = new Company("c4", new Address("Street4", city3), new ArrayList<>());

        assertEquals(getCityNames(List.of(company1, company2, company3, company4)), List.of("City1", "City2", "City1", "City3"));

    }

    @Test
    public void getCompaniesByCityTest() {
        // Create some sample companies with different cities
        City city1 = new City("City1", new State("State1"));
        City city2 = new City("City2", new State("State2"));
        City city3 = new City("City3", new State("State3"));
        City city4 = new City("City4", new State("State4"));
        Company company1 = new Company("c1", new Address("Street1", city1), new ArrayList<>());
        Company company2 = new Company("c2", new Address("Street2", city2), new ArrayList<>());
        Company company3 = new Company("c3", new Address("Street3", city1), new ArrayList<>());
        Company company4 = new Company("c4", new Address("Street4", city3), new ArrayList<>());

        // verify that city1 has two companies, city2 has one and city3 has also one
        assertEquals(1, getCompaniesByCity(List.of(company1, company2, company3, company4)).get(city1).size());
        assertEquals(1, getCompaniesByCity(List.of(company1, company2, company3, company4)).get(city2).size());
        assertEquals(1, getCompaniesByCity(List.of(company1, company2, company3, company4)).get(city3).size());
        //verify that city4 has no companie
        assertNull(getCompaniesByCity(List.of(company1, company2, company3, company4)).get(city4));

    }

    @Test
    public void getCityNamesWithNullChecksTest() {
        City city1 = new City("City1", new State("State1"));
        City city2 = new City("City2", new State("State2"));
        City city3 = new City(null, new State("State3"));
        City city4 = null;
        Company company1 = new Company("c1", null, new ArrayList<>());
        Company company2 = new Company("c2", new Address("Street2", city2), new ArrayList<>());
        Company company3 = new Company("c3", new Address("Street3", city4), new ArrayList<>());
        Company company4 = new Company("c4", new Address("Street4", city3), new ArrayList<>());

        assertEquals(getCityNamesWithNullChecks(List.of(company1, company2, company3, company4)), List.of("City2"));


    }

    @Test
    public void getAllPersonTest() {
        Person p1 = new Person(1L, "p1");
        Person p2 = new Person(2L, "p2");
        Person p3 = new Person(3L, "p3");
        Person p4 = new Person(4L, "p4");
        Company company1 = new Company("c1", null, List.of(p1, p3));
        Company company2 = new Company("c2", null, List.of(p2, p4));

        assertEquals(getAllPerson(List.of(company1, company2)), List.of(p1, p3, p2, p4));
        // test with some null values
        Company company3 = new Company("c1", null, null);
        Company company4 = new Company("c2", null, List.of(p2, p4));

        assertEquals(List.of(p2, p4), getAllPerson(List.of(company3, company4)));

    }

    @Test
    public void hasCompanyInCityTest() {
        // Create some sample companies with different cities
        City city1 = new City("City1", new State("State1"));
        City city2 = new City("City2", new State("State2"));
        City city3 = new City("City3", new State("State3"));

        Company company1 = new Company("c1", null, new ArrayList<>());
        Company company2 = new Company("c2", new Address("Street2", city2), new ArrayList<>());
        Company company3 = new Company("c3", new Address("Street3", city1), new ArrayList<>());
        Company company4 = new Company("c4", new Address("Street4", city3), new ArrayList<>());

        assertTrue(hasCompanyInCity(List.of(company1, company2, company3, company4), "City1"));
        assertFalse(hasCompanyInCity(List.of(company1, company2, company3, company4), "City4"));


    }

    @Test
    public void getUniqueCityNamesTest() {
        // Create some sample companies with different cities
        City city1 = new City("City1", new State("State1"));
        City city2 = new City("City2", new State("State2"));
        City city3 = new City("City3", new State("State3"));

        Company company1 = new Company("c1", new Address("Street1", city1), new ArrayList<>());
        Company company2 = new Company("c2", new Address("Street2", city2), new ArrayList<>());
        Company company3 = new Company("c3", new Address("Street3", city1), new ArrayList<>());
        Company company4 = new Company("c4", new Address("Street4", city3), new ArrayList<>());


        assertEquals(3, getUniqueCityNames(List.of(company1, company2, company3, company4)).size());


    }


}
