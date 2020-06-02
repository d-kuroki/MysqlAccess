package com.example.MysqlAccess;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_DEPARTMENT")
public class Department {
	@Id
	@Column(name="D_CD" ,columnDefinition = "CHAR(2)")
	private String d_cd;
	
	@Column(name="D_NAME" ,nullable = false ,columnDefinition = "VARCHAR(20)")
	private String d_name;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;

	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	public String getD_cd() {
		return d_cd;
	}
	public void setD_cd(String d_cd) {
		this.d_cd = d_cd;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	
	public void setAll(  String d_cd
						,String d_name
						) {
		this.d_cd = d_cd;
		this.d_name = d_name;	
	}
	
	

	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Timestamp getUpdate_date() {
		return update_date;
	}
	
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}

