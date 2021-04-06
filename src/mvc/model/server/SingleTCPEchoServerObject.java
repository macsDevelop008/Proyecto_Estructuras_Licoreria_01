package mvc.model.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class SingleTCPEchoServerObject extends Thread {
    public static final int PORT = 1234;
    private ServerSocket socket = null;

    public SingleTCPEchoServerObject(Socket sock) {

        try {
            socket = new ServerSocket(PORT);
            System.out.println("ServerSocket created");
        } catch (SocketException e) {
            System.out.println("Error Attatch Port");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error create socket");
            System.exit(1);
        }
        do {
            {
                run();
            }

        } while (true);

    }

    public void run() {
        Socket sock = null;
        try {
            sock = socket.accept();
            System.out.println("Client Conected");
            OutputStream outputStream = sock.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            InputStream inputStream = sock.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inputStream);

            try {
                List<Client> clientList =  (List<Client>) in.readObject();
                clientList.forEach(client -> {
                    System.out.println(client);
                    client.setMessage("Proccesed by server");
                });
                System.out.println("Send clients ====>");
                out.writeObject(clientList);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
