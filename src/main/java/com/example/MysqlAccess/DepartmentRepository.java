package com.example.MysqlAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 DepartmentEntity と String を指定します。
public interface DepartmentRepository extends CrudRepository<Department, String> {
	
}
