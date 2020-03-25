package com.projettic.service;

import com.projettic.entity.SqlQuery;

public interface SqlExecutorService {
    String getSqlResult(SqlQuery sqlQuery);

    String correctSql(SqlQuery sqlQuery);
}
