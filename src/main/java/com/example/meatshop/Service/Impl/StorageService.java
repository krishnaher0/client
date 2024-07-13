package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.FileData;
import com.example.meatshop.Repo.FileDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

    private FileDataRepository fileDataRepository;
    private final String FOLDER_PATH="/Users/krishnabhandari/IdeaProjects/VehicleCompany/src/main/java/com/example/meatshop/images";


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder().name(file.getOriginalFilename()).type(file.getContentType()).filePath(filePath).build());
        file.transferTo(new File(filePath));
        if (fileData==null) {
            return null;

        }
        return "file uploaded successfully : " + file.getOriginalFilename();
    }
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images= Files.readAllBytes(new File(filePath).toPath());

        return images;
    }

}
