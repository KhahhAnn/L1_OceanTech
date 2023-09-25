package com.globits.da.service.impl;

import com.globits.da.dto.FileInfo;
import com.globits.da.dto.Student;
//import com.globits.da.repository.StudentRepository;
import com.globits.da.service.MyFirstApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MyFirstApiServiceImpl  implements MyFirstApiService {
    @Override
    public String myFirstApi() {
        return "My First Api";
    }

    @Override
    public Student saveStudent(Student student) {
        return student;
    }

    @Override
    public FileInfo getFileInfo(MultipartFile userFile) throws IOException {
        FileInfo file = new FileInfo();
        file.setFileName(userFile.getOriginalFilename());
        file.setFileData(userFile.getBytes());
        file.setFileEmpty(userFile.isEmpty());
        file.setContentType(userFile.getContentType());
        file.setFileLength(userFile.getSize());
        file.setReadable(userFile.getResource().isReadable());
        return file;
    }
}
