package mvc.model.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPEchoServer {

    private ServerSocket serverSocket;
    public static final int PORT = 1234;
    private Socket sock = null;

    public static void main(String[] args) {
        new MultiTCPEchoServer();
    }

    public MultiTCPEchoServer() {
        System.out.println("Opnening port");

        try {
            this.serverSocket = new ServerSocket(1234);
        } catch (IOException var3) {
            System.out.println("Port error");
            System.exit(1);
        }

        try {
            while(true) {
                this.sock = this.serverSocket.accept();
                new SingleTCPEchoServerObject(this.sock);
            }
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
