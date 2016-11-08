package com.monkeyprojectz.loggy.services;

import com.monkeyprojectz.loggy.model.File;
import com.monkeyprojectz.loggy.model.FileProcessingResult;
import com.monkeyprojectz.loggy.services.processor.FileProcessor;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class FileProcessingService {

    private FileProcessor fileProcessor;

    @Inject
    public void setFileProcessor(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public List<FileProcessingResult> process(List<File> files) {
        return fileProcessor.process(files);
    }
}
