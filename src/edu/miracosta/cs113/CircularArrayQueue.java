package edu.miracosta.cs113;

import java.util.*;

public class CircularArrayQueue<E>  extends AbstractQueue implements Queue {

    private E[] dataStructure ;
    int bottomIndex = 0 ;
    int topIndex = 0 ;
    int numberOfElements = 0 ;
    int capacity = 0 ;


    public CircularArrayQueue(int initialCapacity)
    {
        dataStructure = (E[]) new Object[initialCapacity];
        capacity = initialCapacity ;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E remove()
    {
        if (numberOfElements == 0)
        {
            throw new NoSuchElementException() ;
        }
        return (E) poll();
    }

    @Override
    public boolean offer(Object o)
    {
        if (capacity == numberOfElements)
        {
            int count = 0 ;
            E[] biggerDataStructure = (E[]) new Object[capacity * 2];
            for (int i = 0 ; i < numberOfElements ; i++)
            {
                biggerDataStructure[i] = dataStructure[(bottomIndex + i < capacity ? bottomIndex + i : count++)];
            }
            capacity = capacity * 2 ;
            bottomIndex = 0 ;
            topIndex = numberOfElements  ;
            dataStructure = biggerDataStructure ;
        }
        dataStructure[topIndex++] = (E) o;
        numberOfElements++ ;

        return true;
    }

    public boolean add(Object obj)
    {
        return offer(obj) ;
    }

    @Override
    public Object poll()
    {
        if (numberOfElements == 0)
            return null ;
        numberOfElements-- ;
        return dataStructure[bottomIndex++];
    }

    @Override
    public Object peek()
    {
        if (numberOfElements == 0)
            return null ;
        return dataStructure[bottomIndex];
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}
