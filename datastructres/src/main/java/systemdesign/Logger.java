package main.java.systemdesign;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Logger {
    class LoggerMsg{
        int timestamp;
        String message;
        public LoggerMsg(int timestamp,String message){
            this.timestamp = timestamp;
            this.message = message;
        }
    }
     static final int MAX_WINDOW_SIZE = 10;
    /** Initialize your data structure here. */
    Queue<LoggerMsg> queue;
    public Logger() {
        queue = new LinkedList<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peek().timestamp >= MAX_WINDOW_SIZE){
            queue.poll();
        }
        Iterator<LoggerMsg> iter = queue.iterator();
        while (iter.hasNext()){
            LoggerMsg loggerMsg = iter.next();
            if(loggerMsg.message.equals(message)) return false;
        }
        queue.offer(new LoggerMsg(timestamp,message));
        return true;
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar"));

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo"));

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar"));

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo"));

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo"));
    }
}
