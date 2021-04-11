package mvc.model.client.socket;


import collections.ToList;
import mvc.controller.ControllerConsole;
import mvc.model.client.BuilderSQL;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClientMix
{

    private InetAddress host;
    private static final int         PORT = 1234;

    public static void main(String[] args)
    {
        new TCPEchoClientMix();
    }

    public TCPEchoClientMix()
    {
        System.out.println("Puerto Abierto");
        try
        {
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host not found!");
            System.exit(1);
        }
        run();
    }

    private void run()
    {
        Socket sock = null;

        try
        {
            //Conecta con el servidor
            sock = new Socket(host, PORT);

            //Recibe Objetos
            InputStream inputStream = sock.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inputStream);

            //Permite enviar String (SQL)
            PrintWriter    out = new PrintWriter(sock.getOutputStream(), true);

            //String que será enviado
            String sql;
            do
                {
                    //Envia  SQL
                    BuilderSQL builderSQL = new BuilderSQL();
                    sql = builderSQL.builderReturn();
                    out.println(sql); //Envia sql al servidor - R
                    System.out.println(sql);
                    //---------------------------

                    if(!sql.equals("EXIT"))
                    {
                        //Recibe objeto del servidor
                        ToList<Object> objResult = (ToList<Object>) in.readObject();

                        //----------------------------------

                        //Imprimir resultado - Controller
                        ControllerConsole.sendPrint(objResult);
                    }
                }while (!sql.equals("EXIT"));
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        finally
        {
            try
            {
                sock.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }



}
