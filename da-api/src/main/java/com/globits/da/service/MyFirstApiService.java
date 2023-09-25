package com.globits.da.service;

import com.globits.da.dto.FileInfo;
import com.globits.da.dto.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface MyFirstApiService {
    public String myFirstApi();

    public Student saveStudent(Student student);

    public FileInfo getFileInfo(MultipartFile fileInfo) throws IOException;
}
