package com.epam.lab.iohw.task6directory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandLineUtils {
    private static final Logger logger = LogManager.getLogger(CommandLineUtils.class);

    public static void displayContentOfDirectory(String dirName) {
        File dir = new File(dirName);
        try {
            checkIfExist(dir);
            Files.list(dir.toPath())
                    .forEach(path -> {
                        printDetails(path, Files.getFileAttributeView(path, BasicFileAttributeView.class));
                    });
        } catch (NoSuchFileException e) {
            logger.info(e.getMessage());
            logger.info("Please enter directory path again:");
            displayContentOfDirectory(readCommandLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatTime(FileTime time) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String cTime = df.format(time.toMillis());
        return cTime;
    }

    private static void checkIfExist(File dir) throws NoSuchFileException {
        if (!dir.exists()) {
            throw new NoSuchFileException("Provided directory doesn't exist.");
        }
    }

    private static void printDetails(Path path, BasicFileAttributeView basicView) {
        try {
            logger.info(String.format("%-20s %-13s %-19s %-13s %-19s %-5s %-10s",
                    path.getFileName().toString(), " Creation time:",
                    formatTime(basicView.readAttributes().creationTime()),
                    " Last access:",
                    formatTime(basicView.readAttributes().lastAccessTime()),
                    " Size:",
                    basicView.readAttributes().size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readCommandLine(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
