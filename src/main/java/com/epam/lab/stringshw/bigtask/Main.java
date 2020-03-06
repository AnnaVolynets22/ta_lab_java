package com.epam.lab.stringshw.bigtask;

import com.epam.lab.stringshw.bigtask.models.Text;
import com.epam.lab.stringshw.bigtask.utils.Const;
import com.epam.lab.stringshw.bigtask.utils.PropertyUtils;
import com.epam.lab.stringshw.bigtask.utils.Readers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String fileName = PropertyUtils.getProperty("file_path");
        Text text = new Text(Readers.readFileAsString(fileName));

    }
}
