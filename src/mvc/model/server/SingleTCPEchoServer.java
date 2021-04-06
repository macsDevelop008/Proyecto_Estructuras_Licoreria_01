package mvc.model.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleTCPEchoServer extends Thread {
    public static final int PORT = 1234;
    private Socket socket = null;
    private BufferedReader in;
    private PrintWriter out;

    public SingleTCPEchoServer(Socket sock) {
        this.socket = sock;

        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        this.start();
    }

    public void run() {
        int numMessage = 0;
        String msg = null;

        try {
            do {
                msg = this.in.readLine();
                System.out.println("Message recived");
                this.out.println("Message from Server ->" + msg);
                ++numMessage;
            } while(!msg.equals("Close Server"));

            this.out.println(numMessage + ", Messages recived. Close server");
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }

    }
}
