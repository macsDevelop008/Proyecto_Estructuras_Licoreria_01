package mvc.model.server.persistence.helpers;

import collections.ToList;
import mvc.model.server.persistence.DataSource;


public class BuildResultExecuteUpdate
{
    public static ToList<Object> resultExecuteUpdate(String sql, DataSource dataSource)
    {
        ToList<Object> toListResult =new ToList<>();
        toListResult.agregarAlFinal(dataSource.runExecuteUpdate(sql));
        return toListResult;
    }
}
