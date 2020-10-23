package crutchesbicycles.studyhelper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadController {
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * Сохраняет файл на внутреннем хранилиже
     * @param file -- уже обезопасен от колизий с помощью UUID.randomUUID().toString()
     * @return true/false в зависимости от результата сохранения файла
     */
    boolean saveFile(MultipartFile file) {
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
        try{
            file.transferTo(new File(uploadPath + "/" + file.getOriginalFilename()));
        }
        catch (IOException e){
            return false;
        }

        return true;
    }
}
