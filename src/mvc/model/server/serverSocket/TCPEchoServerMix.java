package mvc.model.server.serverSocket;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.helpers.BuildResultExecuteUpdate;
import mvc.model.server.persistence.helpers.BuildResultRunQuery;

import java.io.*;
import java.net.Socket;

public class TCPEchoServerMix extends Thread //Ayuda a crear los nuevos hilos - clientes
{

    public static final int PORT = 1234;

    private Socket socket = null;   //Cliente

    private DataSource dataSource = null; //DB

    private BufferedReader in; //Recibe String (SQL)

    private ObjectOutputStream out; //Envia Objetos

    public TCPEchoServerMix(Socket sock, DataSource dataSource)
    {
        this.socket = sock;
        this.dataSource = dataSource;

        try
        {
            //In Recibe informacion SQL del cliente
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            //Out Envia informacion OBJECT al cliente
            OutputStream outputStream = sock.getOutputStream();
            out = new ObjectOutputStream(outputStream);

        }
        catch (IOException var3)
        {
            var3.printStackTrace();
        }

        this.start();
    }

    public void run()
    {
        //Almacena string
        String sql = null;

        try
        {
            do
            {
                    //CONTINUACION DEL FLUJO******
                    //Almacena info sql que llega del cliente
                sql = this.in.readLine();
                System.out.println("Message recived" +" "+sql);

                    //Envia info object
                if(!sql.equals("EXIT"))
                {
                    //Calculo en cual de los dos metodos de la DB ejecutará.

                    //runQuery - Muliple - Busqueme todo lo de la tabla
                    if(sql.contains("SELECT") && sql.indexOf("SELECT") == 0 &&
                            sql.contains("*") && sql.indexOf("*") <= 7)
                    {
                        out.writeObject(BuildResultRunQuery.objMultipleResult(sql, dataSource));
                    }
                    else //runQuery - Simple
                        if(sql.contains("SELECT") && sql.indexOf("SELECT") == 0)
                        {
                            out.writeObject(BuildResultRunQuery.objSimpleResult(sql, dataSource));
                        }
                    else    //executeUpdate
                        {
                            out.writeObject(BuildResultExecuteUpdate.resultExecuteUpdate(sql, dataSource));
                        }
                }

            } while(!sql.equals("EXIT")); //Condicion para cerrar

            System.out.println("Close server");
        }
        catch (Exception var12)
        {

            var12.printStackTrace();
        }
        finally
        {
            try
            {
                this.socket.close();
            }
            catch (IOException var11)
            {
                var11.printStackTrace();
            }
        }

    }
}

