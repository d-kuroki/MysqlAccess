package com.example.MysqlAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 EmployeeEntity と String を指定します。
public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
}
