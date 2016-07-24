/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Random;

/**
 *
 * @author kamil
 */
public class Client {
    private int _time, _id;
    
    public Client (int id) {
        _id = id;
        _time = (new Random()).nextInt(10) + 1;
    }
    
    public int getTime() {
        return _time;
    }
    
    public int getID() {
        return _id;
    }
    
}
