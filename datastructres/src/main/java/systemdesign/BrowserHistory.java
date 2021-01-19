package main.java.systemdesign;

import java.util.Stack;

class BrowserHistory {

    Stack<String> history ;
    Stack<String> future;

    public BrowserHistory(String homepage) {
        history =new Stack<>();
        history.push(homepage);
        future = new Stack<>(); // reset the future stack
    }

    public void visit(String url) {
        history.push(url);
        future = new Stack<>(); // reset the forward stack
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) { // Always keep at least one element in stack
            future.push(history.peek());
            history.pop();
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && future.size() > 0){
            history.push(future.peek());
            future.pop();
            steps--;
        }
        return history.peek();
    }
}
