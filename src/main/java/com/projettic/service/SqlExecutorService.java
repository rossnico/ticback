package com.projettic.service;

import com.projettic.entity.SqlQuery;

public interface SqlExecutorService {
    String getHisRes(SqlQuery sqlQuery);
    String getCorrection();
}
