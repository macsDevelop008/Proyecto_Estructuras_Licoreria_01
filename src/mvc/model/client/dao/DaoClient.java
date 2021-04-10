package mvc.model.client.dao;

import mvc.model.client.dto.DtoClient;

public abstract class DaoClient <T extends DtoClient>
{
    protected DaoClient(){}

    public String insert(DtoClient data)
    {
        return data.insert();
    }

    public String read(DtoClient data)
    {
        return data.read();
    }

    public String update(DtoClient data)
    {
        return data.update();
    }

    public String delete(DtoClient data)
    {
        return data.delete();
    }

    public String findById(DtoClient data)
    {
        return data.findById();
    }
}
