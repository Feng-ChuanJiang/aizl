package org.lemonPig.os.assist.mybaties.support;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface IGerneralMapper {
	@InsertProvider(type = SQLProvider.class, method = "getInsertSql")
    @Options(flushCache = true, timeout = 20000)
	void insert(@Param("objective")Object object);
}
