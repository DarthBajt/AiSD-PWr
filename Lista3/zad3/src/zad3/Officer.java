/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author kamil
 */
public class Officer {
    private String _name;
    private int _served, _servedTime;
    private boolean _hasClient;
    private Client _client;
    
    public Officer (String name) {
        _name = name;
        _served = _servedTime = 0;
        _hasClient = false;
    }
    
    public boolean isBusy() {
        return _hasClient;
    }
    
    public void nextClient (Client client) {
        _served++;
        _client = client;
        _servedTime = _client.getTime();
        _hasClient = true;
        System.out.printf("Klient %d podchodzi do okienka urzednika %s\n", _client.getID(), _name);
    }
    
    public void serve() {
        if (_hasClient)
            _servedTime--;
        if (_servedTime == 0) {
            _hasClient = false;
            System.out.printf("Klient %d obsluzony przez urzednika %s w %d minut\n", _client.getID(), _name, _client.getTime());
        } 
    }
    
    public int served () {
        return _served;
    }
}
