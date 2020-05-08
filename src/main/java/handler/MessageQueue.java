package handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {

    BlockingQueue<Message> queue;
    private static final int MAXCOUNT = 10;
    public MessageQueue(){
        queue = new ArrayBlockingQueue<>(MAXCOUNT);
    }

    //add message
    public void enqueueMessage(Message msg){
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //get
    public Message next(){
        Message msg = null;
        try {
            msg = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
