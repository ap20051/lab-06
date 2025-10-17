package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testHas() {
        CityList cityList = mockCityList();
        City city =  new City("Edmonton", "Alberta");
        assertEquals(true, cityList.hasCity(city));
        assertEquals(false, cityList.hasCity( new City("Regina", "Saskatchewan")));
        city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(true,cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        cityList.deleteCity(new City("Edmonton", "Alberta"));
        assertEquals(false, cityList.hasCity(new City("Edmonton", "Alberta")));
        cityList.add(new City("Victoria","BC"));
        cityList.deleteCity(new City("Victoria","BC"));
        assertEquals(false, cityList.hasCity(new City("Victoria","BC")));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(new City("Edmonton", "AB"));
        });
    }

    @Test
    void testCount() {
        CityList cityList = mockCityList();
        cityList.add(new City("Victoria","BC"));
        cityList.add(new City("Sask","SK"));
        cityList.add(new City("Toronto","ON"));
        cityList.add(new City("Montreal","QC"));
        cityList.add(new City("Vancouver","BC"));
        assertEquals(6, cityList.countCities());
    }


    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}