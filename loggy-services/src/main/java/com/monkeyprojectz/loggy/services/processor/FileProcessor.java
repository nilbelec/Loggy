package com.monkeyprojectz.loggy.services.processor;

import com.monkeyprojectz.loggy.model.File;
import com.monkeyprojectz.loggy.model.FileProcessingResult;

import java.util.List;

public interface FileProcessor {
    List<FileProcessingResult> process(List<File> files);
}
