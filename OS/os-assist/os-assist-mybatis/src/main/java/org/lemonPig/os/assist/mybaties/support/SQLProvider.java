package org.lemonPig.os.assist.mybaties.support;

import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.lemonPig.os.assist.mybaties.bean.Column;
import org.lemonPig.os.assist.mybaties.bean.Crud;
import org.lemonPig.os.assist.mybaties.bean.Crud.Insert;

public class SQLProvider {
	private final String PARAMS_KEY="objective"; 
	private SQL sql;
	public SQLProvider() {
		sql=new SQL();
	}

	public String getInsertSql(Map<String, Object> paramMap) {
		Object object=paramMap.get(PARAMS_KEY);
		//INSERT INTO tableName(columnName,columnName) values(#{columnName},#{columnName})
		Insert insert = new Crud.Insert(object);
		StringBuilder columnNames=new StringBuilder();
		StringBuilder columnValues=new StringBuilder();
		Column column=null;
		boolean isFirst=true;
		for (Iterator<Column> iterator=insert.getColumns().iterator(); iterator.hasNext();isFirst=false) {
			if (!isFirst) {
				columnNames.append(",");
				columnValues.append(",");
			}
			column=iterator.next();
			columnNames.append(column.getName());
			columnValues.append("#{").append(PARAMS_KEY).append(".").append(column.getName()).append("}");
		}
		sql=sql.INSERT_INTO(insert.getTableName()).VALUES(columnNames.toString(), columnValues.toString());
		return sql.toString();
	}
}
