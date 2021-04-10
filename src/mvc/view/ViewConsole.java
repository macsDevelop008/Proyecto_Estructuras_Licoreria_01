package mvc.view;

import collections.ToList;

public class ViewConsole
{
    public static void executeQueryPrint(ToList<? extends Object> objPrint)
    {
        for(int i = 0; i < objPrint.getTamanio(); i++)
        {
            //Si hay un solo registro en la lista
            if(objPrint.getTamanio() <= 1)
            {
                System.out.println("--------------------------------------------------------");
                System.out.println("--------------------------------------------------------");
                System.out.println();
                System.out.println("RESULTADO DE LA OPERACIÓN");
                System.out.println("--------------------------------------------------------");
                System.out.println(objPrint.getValor(i));
                System.out.println();
                System.out.println("--------------------------------------------------------");
                System.out.println("--------------------------------------------------------");
            }
            else //Si hay más de un registro en la lista
                {

                    if(i == 0)//Primer Registro
                    {
                        System.out.println("--------------------------------------------------------");
                        System.out.println("--------------------------------------------------------");
                        System.out.println();
                        System.out.println("RESULTADO DE LA OPERACIÓN");
                        System.out.println("--------------------------------------------------------");
                        System.out.println(objPrint.getValor(i));
                    }
                    else
                    if(i == objPrint.getTamanio() -1)//Ultimo Registro
                    {
                        System.out.println(objPrint.getValor(i));
                        System.out.println();
                        System.out.println("--------------------------------------------------------");
                        System.out.println("--------------------------------------------------------");
                    }
                    else//Registros intermedios
                    {
                        System.out.println(objPrint.getValor(i));
                    }
                }

        }
    }

    public static void executeUpdatePrint(boolean objPrint)
    {
        String message = "";

        if(objPrint)
        {
            message = "Operación exitosa !!! :)";
        }
        else
            {
                message = "Operación NO exitosa :( - Ingresa la información de forma correcta.";
            }

            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.println("RESULTADO DE LA OPERACION");
            System.out.println("--------------------------------------------------------");
            System.out.println(message);
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("--------------------------------------------------------");
    }
}
