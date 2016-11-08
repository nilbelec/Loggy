package com.monkeyprojectz.loggy.spark.processor;

import com.monkeyprojectz.loggy.model.File;
import com.monkeyprojectz.loggy.model.FileProcessingResult;
import com.monkeyprojectz.loggy.services.processor.FileProcessor;

import javax.inject.Named;
import java.util.List;

@Named
public class SparkFileProcessor implements FileProcessor {

    @Override
    public List<FileProcessingResult> process(List<File> files) {
        return null;
    }
}
