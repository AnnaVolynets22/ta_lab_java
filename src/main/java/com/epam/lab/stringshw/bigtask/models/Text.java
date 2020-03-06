package com.epam.lab.stringshw.bigtask.models;

import com.epam.lab.stringshw.bigtask.utils.Const;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    List<Sentence> sentences = new ArrayList<>();

    public Text(String s){
        s = replaceMultiplySpaces(s);
        Pattern reg = Pattern.compile(Const.SENTENCES_REG);
        Matcher matcher = reg.matcher(s);
        while (matcher.find()) {
            sentences.add(new Sentence(matcher.group()));
        }
    }

    public String replaceMultiplySpaces(String s){
        return s.replaceAll(Const.SPACES_REG, " ").trim();
    }

}
