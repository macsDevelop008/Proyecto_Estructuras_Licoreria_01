package mvc.model.client;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class TCPEchoClientObject
{

    private InetAddress host;
    private static final int         PORT = 1234;

    public static void main(String[] args) {
        new TCPEchoClientObject();
    }

    public TCPEchoClientObject() {
        System.out.println("Opening port");
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Host not found!");
            System.exit(1);
        }
        run();
    }

    private void run() {
        Socket sock = null;
        try {
            sock = new Socket(host, PORT);
            OutputStream outputStream = sock.getOutputStream();
            ObjectOutputStream out          = new ObjectOutputStream(outputStream);

            InputStream inputStream = sock.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inputStream);

            List<Client> studentList = List.of(
                    new Client("Antonio","Nariño","Derecho", "holis"),
                    new Client("Bill","Gates","Engineer Software", "holis"),
                    new Client("Diana","Trujillo","Engineer NASA", "holis")
            );

            System.out.println("Sending students");
            out.writeObject(studentList);
            studentList = (List<Client>) in.readObject();
            studentList.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
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
