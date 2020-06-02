package com.example.MysqlAccess;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MysqlAccessController {
	@Autowired	// This means to get the bean called CustomerRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private CustomerRepository customerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
    public String index() {
		// DBアクセスTop画面を表示
        return "index";
    }
	
	@GetMapping(path="/all")
	public String list(Model model) {
		// M_CUSTOMERテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);

		// データ一覧画面を表示
		return "list";
	}
	
//	データ一覧（部署）追加
	@GetMapping(path="/depart")
	public String listDepartment(Model model) {
		Iterable<Department> departmentList = departmentRepository.findAll();
		model.addAttribute("departmentlist",departmentList);
		return "listDepartment";
	}
	
//	データ一覧（従業員）追加
	@GetMapping(path="/employee")
	public String listEmployee(Model model) {
		Iterable<Employee> employeeList = employeeRepository.findAll();
		model.addAttribute("employeelist",employeeList);
		return "listEmployee";
	}
	
	
	@RequestMapping("/insert")
    public String insert() {
		// データ登録画面を表示
        return "insert";
    }
	
//	データ登録画面（部署）追加
	@RequestMapping("/insert.depart")
	public String insertDepart() {
		return "insertDepartment";
	}
	
//	データ登録画面（従業員）追加
	@RequestMapping("/insert.employee")
	public String insertEmployee() {
		return "insertEmployee";
	}
	
	// DB登録処理
	@PostMapping(path="/register")
	public @ResponseBody String addNewCustomer(	  @RequestParam String c_num 
												, @RequestParam String c_name
												, @RequestParam String address
												, @RequestParam String tel){
		
		Customer customerAddData = new Customer();
		customerAddData.setAll(c_num,c_name,address,tel);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		customerAddData.setCreate_date(timestamp);
		customerAddData.setCreate_user("auto_system");
		customerAddData.setUpdate_date(timestamp);
		customerAddData.setUpdate_user("auto_system");
		
		customerRepository.save(customerAddData);
		
		return "登録しました";
	}
	
	// DB登録処理（Department）追加
	@PostMapping(path="/registerDepartment")
	public @ResponseBody String addNewDepartment(	@RequestParam String d_cd 
												  , @RequestParam String d_name){
		Department departmentAddData = new Department();
		departmentAddData.setAll(d_cd, d_name);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		departmentAddData.setUpdate_date(timestamp);
		departmentAddData.setUpdate_user("auto_system");
		departmentAddData.setCreate_date(timestamp);
		departmentAddData.setCreate_user("auto_system");
		
		departmentRepository.save(departmentAddData);
		
		return "登録しました";
	}
	
	// DB登録処理（Employee）追加
	@PostMapping(path="/registerEmployee")
	public @ResponseBody String addNewEmployee(	  @RequestParam String e_num 
												, @RequestParam String e_name
												, @RequestParam int e_year
												, @RequestParam String depart_cd){
		Employee employeeAddData = new Employee();
		employeeAddData.setAll(e_num, e_name, e_year, depart_cd);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		employeeAddData.setUpdate_date(timestamp);
		employeeAddData.setUpdate_user("auto_system");
		employeeAddData.setCreate_date(timestamp);
		employeeAddData.setCreate_user("auto_system");
		
		employeeRepository.save(employeeAddData);
		
		return "登録しました";
	}
	
	
}
