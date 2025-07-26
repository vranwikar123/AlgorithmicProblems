package Stacks;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class NestedIterator {

    private Stack<NestedInteger> stackIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stackIterator = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.stackIterator.push(nestedList.get(i));
        }
    }

    public boolean hasNext()
    {
        while (!stackIterator.isEmpty()) {
            NestedInteger top = stackIterator.peek();
            if (top.isInteger()) {
                return true;
            }
            List<NestedInteger> topList = stackIterator.pop().getList();
            for (int i = topList.size() - 1; i >= 0; i--) {
                this.stackIterator.push(topList.get(i));
            }
        }
        return false;
    }

    // Check if there is still an integer in the stack
    public int next() {
        if (hasNext()) {
            return this.stackIterator.pop().getInteger();
        }
        return -1;
    }

    // ------ Please don't change the following function ----------
    // flattenList function is used for testing porpuses.
    // Your code will be tested using this function
    public static List<Integer> flattenList(NestedIterator obj){
        List<Integer> result = new ArrayList<Integer>();

        while (obj.hasNext()) {
            result.add(obj.next());
        }
        return result;
    }
}

class NestedInteger {
    private Integer integer;
    private List<NestedInteger> nList;

    // Constructor initializes a single integer if a value has been passed
    // else it initializes an empty list
    public NestedInteger() {
        this.nList = new ArrayList<>();
        this.integer = null;
    }

    public NestedInteger(int integer) {
        this.integer = integer;
        this.nList = null;
    }

    // If this NestedIntegers holds a single integer rather
    // than a nested list, returns TRUE, else, returns FALSE
    public boolean isInteger() {
        return integer != null;
    }

    // Returns the single integer, if this NestedIntegers holds a single integer
    // Returns null if this NestedIntegers holds a nested list
    public Integer getInteger() {
        return integer;
    }

    // Sets this NestedIntegers to hold a single integer.
    public void setInteger(int value) {
        this.nList = null;
        this.integer = value;
    }

    // Sets this NestedIntegers to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (this.integer != null) {
            this.nList = new ArrayList<>();
            this.nList.add(new NestedInteger(this.integer));
            this.integer = null;
        }
        if (this.nList != null) {
            this.nList.add(ni);
        }
    }

    // Returns the nested list, if this NestedIntegers holds a nested list
    // Returns null if this NestedIntegers holds a single integer
    public List<NestedInteger> getList() {
        return nList;
    }
}