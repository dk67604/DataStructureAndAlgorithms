package main.java.systemdesign;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedList){
        // Push the element from back to front
        for(int i = nestedList.size() -1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }
}
