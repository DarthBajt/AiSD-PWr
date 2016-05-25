/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choose;
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City(1, "Warszawa", 1735442, 51724));
        cities.add(new City(2, "Wrocław", 634487, 29282));
        cities.add(new City(3, "Łódź", 706004, 29325));
        cities.add(new City(4, "Kraków", 761873, 32685));
        cities.add(new City(5, "Gdańsk", 461489, 26196));
        cities.add(new City(6, "Lublin", 341722, 14747));
        cities.add(new City(7, "Katowice", 301834, 16464));
        cities.add(new City(8, "Bydgoszcz", 357652, 17598));
        cities.add(new City(9, "Szczecin", 407180, 30055));
        cities.add(new City(10, "Poznań", 545680, 26191));
        
        InsertSort insert = new InsertSort(City.idComparator());
        Scanner in = new Scanner(System.in);
        List<City> list;
        
        do {
            System.out.println("\nMenu:\n  1: posortuj miasta po ID\n"+
                            "  2: posortuj miasta po nazwie\n"+
                            "  3: posortuj miasta po liczbie mieszkancow\n"+
                            "  4: posortuj miasta po wielkości\n"+
                            "  5: wyjdz z programu");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    insert.setCompatator(City.idComparator());
                    list = insert.sort(cities);
                    for (City city : list) {
                        System.out.println(city);
                    }
                    break;
                case 2:
                    insert.setCompatator(City.nameComparator());
                    list = insert.sort(cities);
                    for (City city : list) {
                        System.out.println(city);
                    }
                    break;
                case 3:
                    insert.setCompatator(City.populationComparator());
                    list = insert.sort(cities);
                    for (City city : list) {
                        System.out.println(city);
                    }
                    break;
                case 4:
                    insert.setCompatator(City.areaComparator());
                    list = insert.sort(cities);
                    for (City city : list) {
                        System.out.println(city);
                    }
                    break;
                default:
                    break;
            }
            
        } while (choose != 5);
    }
    
}
