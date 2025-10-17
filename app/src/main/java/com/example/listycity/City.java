package com.example.listycity;

import java.util.Collection;
import java.util.Comparator;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This gets the city name of the city object
     * @return
     * Return the name of the city
     */
    public String getCityName(){
        return this.city;
    }
    /**
     * This gets the province name of the city object
     * @return
     * Return the name of the province
     */
    public String getProvinceName(){
        return this.province;
    }

    /**
     * This defines comparison between this and another city
     * @param o
     * the city object to compare to this city
     * @return
     * Return the int comparison
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * This defines equality between cities
     * @param o
     * the city object to check
     * @return
     * Return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if (this == o){
            return  true;
        }
        if (o.getClass() != this.getClass() || o==null){
            return false;
        }
        return ((City) o).getCityName()==this.city && ((City) o).getProvinceName() ==this.province;
    }
}