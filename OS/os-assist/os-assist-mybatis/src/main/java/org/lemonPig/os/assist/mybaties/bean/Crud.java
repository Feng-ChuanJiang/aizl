package org.lemonPig.os.assist.mybaties.bean;

import java.util.List;

import org.lemonPig.os.assist.mybaties.support.EntityWrapper;


public class Crud {
	protected String tableName;
	protected String alias;
	protected List<Column> columns;
	protected Where where;
	protected Order order;
	private Crud(){
	}
	private Crud(Object object){
		EntityWrapper entityWrapper =new EntityWrapper(object);
		this.tableName= entityWrapper.getTableName();
		this.alias=entityWrapper.getAlias();
		this.columns=entityWrapper.getColumns();
	}
	private Crud(Object object,Where where){
		this(object);
		this.where=where;
	}
	private Crud(Object object,Where where,Order order){
		this(object,where);
		this.order=order;
	}

	
	public static class Insert extends Crud{
		public Insert(Object object){
			super(object);
		}
	}
	
	public static class Delete extends Crud {
		public Delete(Object object,Where where){
			//DELETE FROM tableName WHERE wherename whereExp wherevalue
			super(object,where);
		}
	}
	
	public static class Update extends Crud{
		public Update(Object object,Where where) {
			//UPDATE tableName SET 
			super(object,where);
		}
	}
	
	public static class Select extends Crud{
		public Select(Object object,Where where,Order order){
			//SELECT columnName1,columnName2 FROM tableName WHERE wherename whereExp wherevalue ORDER BY columnName direction
			super(object,where,order);
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
