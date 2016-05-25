/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author kamil
 */
public class City {
    public int _id, _population, _area;
    public String _name;
    
    public City(int id, String name, int population, int area) {
        _id = id;
        _name = name;
        _population = population;
        _area = area;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %2d, nazwa: %9s, liczba ludności: %7d, obszar: %d ha", _id, _name, _population, _area);
    }
    
    public static Comparator idComparator() {
        return new Comparator <City> () {
            @Override
            public int compare(City left, City right) throws ClassCastException {
                return left._id - right._id;
            }
        };
    }
    
    public static Comparator areaComparator() {
        return new Comparator <City> () {
            @Override
            public int compare(City left, City right) throws ClassCastException {
                return right._area - left._area;
            }
        };
    }
    
    public static Comparator populationComparator() {
        return new Comparator <City> () {
            @Override
            public int compare(City left, City right) throws ClassCastException {
                return right._population - left._population;
            }
        };
    }
    
    public static Comparator nameComparator() {
        return new Comparator <City> () {
            @Override
            public int compare(City left, City right) throws ClassCastException {
                return left._name.compareTo(right._name);
            }
        };
    }
}
