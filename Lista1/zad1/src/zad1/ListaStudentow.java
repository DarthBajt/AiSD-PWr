/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Iterator;

/**
 *
 * @author kamil
 */
public class ListaStudentow implements Iterable <Student> {

    Student [] studenci;
    int pierwszy, ostatni, biezacy = 0;
    
    public ListaStudentow () {
        studenci = new Student[5];
        studenci[0] = new Student(1, "Kamil", "Kowalski", 5);
        studenci[1] = new Student(2, "Mateusz", "Płuciennik", 4);
        studenci[2] = new Student(3, "Edmund", "Butkiewicz", 3);
        studenci[3] = new Student(4, "Krzysztof", "Wolski", 2);
        studenci[4] = new Student(5, "Grażyna", "Januszewicz", 2);
        pierwszy = 0;
        ostatni = studenci.length - 1;
       // biezacy = 0;
    }
    
    public void ustawOcene (int id, int ocena) {
        if (id > 0 && id <= ostatni+1 && ocena >= 2 && ocena <= 5)
            studenci[id-1].ocena = ocena;
    }
    
    @Override
    public Iterator <Student> iterator() {
        Iterator <Student> it;
        it = new Iterator <Student>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index <= ostatni;
            }

            @Override
            public Student next() {
                return studenci[index++];
            }
            
            @Override
            public void remove() {
                
            }
        };
        
        return it;
    }
    
    public Iterator <Student> filterIterator (Predicate predicate) {
        Iterator <Student> it;
        it = new Iterator <Student>() {
            private int index = 0;
            private int last = ostatni;

            @Override
            public boolean hasNext() {
                while (!predicate.isPositive(studenci[last]))
                    last--;
                return index <= last && studenci[index] != null;
            }

            @Override
            public Student next() {
                while (!predicate.isPositive(studenci[index]) && index < last) {
                    index++;
                }
                return studenci[index++];
                
            }
            
            @Override
            public void remove() {
                
            }
        };
        return it;
    }
        
}
