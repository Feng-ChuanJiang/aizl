package org.lemonPig.os.assist.mybaties.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hsqldb.User;
import org.lemonPig.os.assist.mybaties.support.EntityWrapper;


public class Crud {
	String tableName;
	String alias;
	List<Column> columns;
	EntityWrapper entityWrapper=null;
	private Crud(){
	}
	public static class Insert extends Crud{
		public Insert(Object object){
			this.entityWrapper =new EntityWrapper(object);
			this.tableName=entityWrapper.getTableName();
			this.alias=entityWrapper.getAlias();
			this.columns=entityWrapper.getColumns();
		}
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
}
