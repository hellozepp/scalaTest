package myscala.jettyTest.JettyReceiveHttpMsg;

//启动jetty并保活的主函数
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            JettyStart.start();// 启动jetty服务器
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 全局异常监控 没起作用
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("uncaughtException" + e.getMessage());
                System.exit(-1);
            }
        });

//        while (true) {
//            // 线程保活
//            // ...
//            // jetty服务器保活
//            JettyStart.start();
//        }
    }
}