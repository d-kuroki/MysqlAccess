package com.example.MysqlAccess;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_EMPLOYEE")
public class Employee {
	@Id
	@Column(name="E_NUM" ,columnDefinition = "VARCHAR(5)")
	private String e_num;
	
	@Column(name="E_NAME" ,nullable = false ,columnDefinition = "VARCHAR(40)")
	private String e_name;
	
	@Column(name="E_YEAR" ,columnDefinition = "INT(11)")
	private int e_year;

	@Column(name="DEPART_CD" ,columnDefinition = "CHAR(2)")
	private String depart_cd;

	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")
	private Timestamp create_date;
	
	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")
	private String create_user;
	
	public String getE_num() {
		return e_num;
	}
	public void setE_num(String e_num) {
		this.e_num = e_num;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getE_year() {
		return e_year;
	}
	public void setE_year(int e_year) {
		this.e_year = e_year;
	}
	public String getDepart_cd() {
		return depart_cd;
	}
	public void setDepart_cd(String depart_cd) {
		this.depart_cd = depart_cd;
	}

	
	public void setAll(  String e_num
						,String e_name
						,int e_year
						,String depart_cd
						) {
		this.e_num = e_num;
		this.e_name = e_name;
		this.e_year = e_year;
		this.depart_cd = depart_cd;
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

}	
