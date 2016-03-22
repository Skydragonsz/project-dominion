/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deck;

/**
 *
 *
 */
public class LinkedCards
{
    private Node first;
    private Node last;
    
    public void addInFront(int data)
    {
        Node newNode = new Node(data, first);
        if(isLeeg()) last = newNode;
        first = newNode;
    }
    
    public boolean isLeeg()
    {
        return first == null;
    }
   
    public int getFirstData(int key)
    {
        Node tmp = first;
        while(tmp != null && tmp.getData() != key)
        {
            tmp = tmp.getNext();
        }
        if(tmp == null)
            throw new IllegalArgumentException("getData with nonexisting key " + key);
        else
            return tmp.getData();
    }
    
    public void deleteFirst(int key)
    {
        Node tmp = first;
        
        //Als temp niet null is en de data is gelijk aan de key
        if(tmp != null && tmp.getData() == key)
        {
            first = tmp.getNext();
            return;
        }
        //Terwijl temp niet null is en de volgende zijn data niet de key is
        while(tmp != null && tmp.getNext().getData() != key)
        {
            tmp = tmp.getNext();
        }
        
        if(tmp != null)
            tmp.setNext(tmp.getNext().getNext());
    }
    
    public void addToBack(int data)
    {
        if(isLeeg())
            addInFront(data);
        else
        {
            //Node last = getLast();
            last.setNext(new Node(data));
            last = last.getNext();
        }
    }
    
    public int getNth(int n)
    {
        Node tmp = first;
        for(int i = 1; i < n; i++)
        {
            if (tmp == null) throw new IllegalArgumentException();
            tmp = tmp.getNext();
        }
        if (tmp == null) throw new IllegalArgumentException();
        return tmp.getData();
    }
    
    public void setNth(int n, int data)
    {
        Node tmp = first;
        for(int i = 1; i < n; i++)
        {
            if (tmp == null) throw new IllegalArgumentException();
            tmp = tmp.getNext();
        }
        if (tmp == null) throw new IllegalArgumentException();
        Node newNode = new Node(data, tmp);
        
    }
    
    public String toString()
    {
        String res = "";
        Node tmp = first;
        while(tmp != null)
        {
            res += tmp.getData() + " ";
            tmp = tmp.getNext();
        }
        return res;
    }
    public int RemoveNth(int n)
    {
        Node tmp = first;
        for(int i = 1; i < n; i++)
        {
            if (tmp == null) throw new IllegalArgumentException();
            tmp = tmp.getNext();
        }
        if (tmp == null) throw new IllegalArgumentException();
        return tmp.getData();
    }
}


