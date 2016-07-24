/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author kamil
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Queue clients = new LinkedList();
        int time = 2 * 60; // 2 godziny, typowy urząd
        int n = 10;
        
        Officer a = new Officer("A");
        Officer b = new Officer("B");
        Officer c = new Officer("C");
        
        for (int i = 1; i <= n; ++i)
            clients.add(new Client(i));
        
        while (!clients.isEmpty() || a.isBusy() || b.isBusy() || c.isBusy()) {
            if (!a.isBusy() && !clients.isEmpty())
                a.nextClient((Client) clients.poll());
            if (!b.isBusy() && !clients.isEmpty())
                b.nextClient((Client) clients.poll());
            if (!c.isBusy() && !clients.isEmpty())
                c.nextClient((Client) clients.poll());
            a.serve();
            b.serve();
            c.serve();
            time--;
            if (time > 0 && rand.nextInt(3) == 1)
                clients.add(new Client(n++));
        }
        
        System.out.printf("A obsluzyl %d klientow\nB obsluzyl %d klientow\nC obsluzyl %d klientow\n", a.served(), b.served(), c.served());
    }
    
}
