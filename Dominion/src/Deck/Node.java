/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deck;

/**
 *
 * @author 
 */
public class Node
{
    private int data;
    private Node next;
    
    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
    
    public Node(int data)
    {
        this(data, null);
    }
    
    public Node getNext()
    {
        return next;
    }
    
    public int getData()
    {
        return data;
    }
    
    public void setNext(Node next)
    {
        this.next = next;
    }
    public void setData(int data)
    {
        this.data = data;
    }
}
