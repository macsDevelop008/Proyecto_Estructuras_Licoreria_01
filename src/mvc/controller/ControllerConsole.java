package mvc.controller;

import collections.ToList;
import mvc.view.ViewConsole;

public class ControllerConsole
{
    //Envia a la vista el resultado de la operacion
    public static void sendPrint(ToList<? extends Object> objResultOperation)
    {
        //Result executeQuery - Si no es un boolean el primer objeto
        if(objResultOperation.getValor(0).getClass() != Boolean.class)
        {
            ViewConsole.executeQueryPrint(objResultOperation);
        }
        else//Result executeUpdate - Es un boolean
        {
            ViewConsole.executeUpdatePrint((Boolean) objResultOperation.getValor(0));
        }

    }
}
