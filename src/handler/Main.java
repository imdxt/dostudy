package handler;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Looper.prepare();
        Handler handler = new Handler(){
            @Override
            public void handlerMessage(Message msg) {
                System.out.println("Thread id "+Thread.currentThread().getName()+"received msg :"+msg.toString());
            }
        };
//        new Thread(() -> {
//            while (true){
//                handler.Message msg = new handler.Message();
//                msg.obj = UUID.randomUUID().toString();
//                System.out.println(Thread.currentThread().getName()+" send msg :"+msg.toString());
//                handler.sendMessage(msg);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String string;
                    synchronized (UUID.class){
                        string = UUID.randomUUID().toString();
                    }
                    Message msg = new Message();
                    msg.obj = string;
                    System.out.println(Thread.currentThread().getName()+" send msg :"+msg.toString());
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }

        Looper.loop();

    }


}
