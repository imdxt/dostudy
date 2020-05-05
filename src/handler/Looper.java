package handler;

public class Looper {

    public MessageQueue mQueue;
    public static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    public static Looper myLooper(){
        return sThreadLocal.get();
    }
    private Looper(){
        mQueue = new MessageQueue();
    }
    public static void prepare(){
            if(sThreadLocal.get() != null){
                throw new RuntimeException("sdfsdfs");
            }

            sThreadLocal.set(new Looper());
    }
    //启动looper，让messagequeue run
    public static  void loop(){
        final Looper me = myLooper();
        final MessageQueue queue = me.mQueue;
        for (;;){
            Message msg = queue.next();
            if(msg != null){
                msg.target.dispatchMessage(msg);
            }
        }
    }
}
