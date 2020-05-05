package handler;

public class Handler {

    final Looper mLooper;
    final MessageQueue mQueue;
    public Handler(){
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

    public void sendMessage(Message message){
        enqueueMessage(message);
    }
    public  void enqueueMessage(Message message){
        message.target = this;
        mQueue.enqueueMessage(message);
    }
    //分发消息
    public void dispatchMessage(Message msg){
        handlerMessage(msg);
    }
    //处理消息
    public void handlerMessage(Message msg){

    }

}
