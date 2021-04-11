package mvc.model.server.serverSocket;

import mvc.model.server.persistence.DataSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPEchoServer
{

    private ServerSocket serverSocket;
    public static final int PORT = 1234;
    private Socket sock = null; //Cliente
    DataSource dataSource;

    public static void main(String[] args)
    {
        new MultiTCPEchoServer();
    }



    public MultiTCPEchoServer()
    {

        //Conexion con la DB
        dataSource = DataSource.getInstance();

        System.out.println("Puerto Abierto");

        try
        {
            //Crea el server en el puerto seleccionado
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            System.out.println("ERROR: Puerto");
            System.exit(1);
        }

        try
        {
            do
            {
                //Nuevo hilo cuando el cliente entre
                sock = serverSocket.accept();
                new TCPEchoServerMix(sock, dataSource);
                System.out.println("Cliente Conectado");
                //Calculo numero de clientes, sumar

            } while (true);
        }
        catch (IOException var2)
        {
            var2.printStackTrace();
        }
    }
}
