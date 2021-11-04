package myscala.jettyTest.JettyReceiveHttpMsg;

import org.eclipse.jetty.server.Server;

import java.net.InetSocketAddress;

//jetty的启动类
public class JettyStart {

    public static Server server = null;

    public static void start() {
        if (server == null || server.isStopped()) {
            try {
                JettyReceive handler = new JettyReceive();
                // jetty服务器实例
                InetSocketAddress address = new InetSocketAddress("127.0.0.1", 12345);
                server = new Server(address);
                server.setHandler(handler);
                server.start();
                System.out.println("================="+server.getURI()+"================");
                System.out.println("================="+server.getThreadPool().getThreads()+"================");
                System.out.println("================="+server.getThreadPool().getIdleThreads()+"================");
                System.out.println("jetty start succeed");
                server.join();
            } catch (Exception e) {
                System.out.println("jetty start failed");
                e.printStackTrace();
                try {
                    server.stop();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }
    }

}