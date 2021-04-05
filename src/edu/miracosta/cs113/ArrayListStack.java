package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> extends ArrayList implements StackInterface
{
    private ArrayList<E> dataStructure ;
    private int numberOfElements ;

    public ArrayListStack()
    {
        dataStructure = new ArrayList<>(10) ;
        numberOfElements = 0 ;
    }
    public int getSize()
    {
        return dataStructure.size() ;
    }

    public E pop()  //removed the 'top' element in stack and returns that data
    {
        if (empty())
            throw new EmptyStackException() ;
        E tempData = (dataStructure.get(numberOfElements - 1)) ;
        dataStructure.remove(--numberOfElements) ;  //removes the data from the stack, and decriments the numberOfElements
        return tempData;
    }

    public Object push(Object obj)
    {
        dataStructure.ensureCapacity(numberOfElements + 1); //increases the size of the stack (ArrayList) if the it cannot fit another element
        dataStructure.add((E) obj) ;
        numberOfElements++ ;
        return null;
    }


    public E peek()
    {
        if (empty())
            throw new EmptyStackException() ;
        return dataStructure.get(numberOfElements - 1) ;
    }

    public boolean empty()      //returns true if ArrayListStack is empty of data, false otherwise
    {
        return dataStructure.isEmpty() ;
    }

}
