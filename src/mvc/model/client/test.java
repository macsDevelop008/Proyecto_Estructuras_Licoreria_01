package mvc.model.client;

import collections.ToList;

public class test
{
    public static void main(String[] args)
    {
        boolean kk = true;
        ToList<Object> general = new ToList<Object>();
        general.agregarAlFinal(kk);

        if(general.getValor(0).getClass() == Boolean.class)
        {
            System.out.println("el pepe");
        }


    }
}
