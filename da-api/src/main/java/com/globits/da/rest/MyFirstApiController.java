package com.globits.da.rest;

import com.globits.da.dto.EmployeeDto;
import com.globits.da.dto.FileInfo;
import com.globits.da.dto.Student;
import com.globits.da.service.EmployeeService;
import com.globits.da.service.MyFirstApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/myFirstApi")
public class MyFirstApiController {
    private MyFirstApiService myFirstApiService;
    private EmployeeService employeeService;

    @Autowired
    public MyFirstApiController(MyFirstApiService myFirstApiService, EmployeeService employeeService) {
        this.myFirstApiService = myFirstApiService;
        this.employeeService = employeeService;
    }



    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String myFirstApi() {
        return this.myFirstApiService.myFirstApi();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student st = myFirstApiService.saveStudent(student);
        return new ResponseEntity<Student>(st, HttpStatus.OK);
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public ResponseEntity<FileInfo> postFile(@RequestParam("file") MultipartFile userFile) throws IOException {
        FileInfo newFile = this.myFirstApiService.getFileInfo(userFile);
        return  new ResponseEntity<FileInfo>(newFile, HttpStatus.OK);
    }

    @GetMapping("/allEmployee")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        List<EmployeeDto> employees = this.employeeService.getAllEmployee();
        if(employees == null) {
            return null;
        }
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto  newEmployeeDto = this.employeeService.addEmployeeDto(employeeDto);
        System.out.println(new ResponseEntity<EmployeeDto>(newEmployeeDto, HttpStatus.OK));
        return new ResponseEntity<EmployeeDto>(newEmployeeDto, HttpStatus.OK);
    }
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        EmployeeDto employeeDto = this.employeeService.getById(id);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        this.employeeService.deleteAll();
        return "Delete complete";
    }

    @GetMapping("/excel")
    public String generateExcelReport(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=employee.xls";
        response.setHeader(headerKey, headerValue);
        this.employeeService.generateExcel(response);
        return "Export complete";
    }
}
//khi không dùng anotation truyền với JSON thì Spring sẽ mặc định hiểu rằng dữ liệu cần được trích xuất
// từ phần thân của yêu cầu HTTP dưới dạng form data (x-www-form-urlencoded).
// Spring sẽ tự động ánh xạ các trường nhưng do gặp vấn đề khi ánh xạ
//Khi không dùng anotation truyền với Form-data thì vẫn trả về binh thường do
// Spring sẽ tự động ánh xạ các trường từ form-data vào các tham số của phương thức dựa trên tên trường.




//Khi thêm student với @PathVariable trong postman bị gặp lỗi 500 vì:
//+ @PathVariable dùng để trích xuất 1 giá trị ví dụ như code hoặc name,...
// mà ta truyền vào 1 obj nên điều này tạo ra ngoại lệ và lỗi 500




//Khi thêm student với form data trong postman bị gặp lỗi 415 vì:
// +Lỗi 415 là lỗi máy chủ không hỗ trợ hoặc không nhận diện đươc dữ liêu gửi đi.
// +Form-data thường dùng để gửi dữ liệu như file và các key-value với dạng form mà khi truyền vào là 1 student là kiểu obj
//vì vậy khi truyền vào postman phải truyền theo JSON do vậy khi truyền vào dataform máy chủ sẽ không gửi được dữ liệu đi và gặp lỗi 415