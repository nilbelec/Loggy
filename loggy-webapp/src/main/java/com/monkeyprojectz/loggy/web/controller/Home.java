package com.monkeyprojectz.loggy.web.controller;

import com.monkeyprojectz.loggy.model.File;
import com.monkeyprojectz.loggy.model.FileProcessingResult;
import com.monkeyprojectz.loggy.services.FileProcessingService;
import com.monkeyprojectz.loggy.web.viewmodel.ProcessingResultsViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class Home {

    private FileProcessingService processingService;

    @Inject
    public void setProcessingService(FileProcessingService processingService) {
        this.processingService = processingService;
    }


    @RequestMapping(value = "/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ProcessingResultsViewModel upload(MultipartHttpServletRequest request){
        try {
            List<File> files = prepareFiles(request);
            List<FileProcessingResult> results = processingService.process(files);
            return new ProcessingResultsViewModel(results);
        } catch (IOException e) {
            e.printStackTrace();
            return new ProcessingResultsViewModel();
        }
    }

    private List<File> prepareFiles(MultipartHttpServletRequest request) throws IOException {
        Map<String, MultipartFile> fileMap = request.getFileMap();

        List<File> uploadedFiles = new ArrayList<>();

        for (MultipartFile multipartFile : fileMap.values()) {
            File fileInfo = getFileInfo(multipartFile);
            uploadedFiles.add(fileInfo);
        }

        return uploadedFiles;
    }

    private File getFileInfo(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setName(multipartFile.getOriginalFilename());
        file.setSize(multipartFile.getSize());
        file.setType(multipartFile.getContentType());
        file.setData(multipartFile.getBytes());
        return file;
    }
}
