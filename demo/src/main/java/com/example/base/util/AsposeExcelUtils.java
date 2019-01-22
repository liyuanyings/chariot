package com.example.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class AsposeExcelUtils {

    private static final String LICENSE_FILE_PATH = "/aspose/license.xml";

    private static File outputFile;

    public static boolean getLicense() {
        boolean result = false;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream license = new FileInputStream(loader.getResource(LICENSE_FILE_PATH).getPath());
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}