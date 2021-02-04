package com.edu.project.action;

import com.edu.project.model.Test;
import com.edu.project.process.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.hibernate.internal.util.collections.CollectionHelper.isNotEmpty;

@Component
public class TestAction extends ActionSupport {
    public static final String SUCCESS = "success";
    public static final String FILE_PATH = "src/main/resources/Edited_Task_Texts/Edited_EVI_texts/edited_file_%s.html";

    @Autowired
    private transient TestService testService;
    private String jsonObject;
    private String data = "";
    private String sectionPath;
    private String testId;

    public String getMenu() {
        List<Test> tests = testService.findAll();
        Map<Integer, List<AbstractMap.SimpleEntry<String, Long>>> menu = new HashMap<>();

        tests.forEach(test ->
        {
            int year = test.getYear();
            if (isNotEmpty(menu.get(year))) {

                menu.get(year).add(new AbstractMap.SimpleEntry<>(valueOf(test.getShift()), test.getId()));
            } else {
                menu.put(year, asList(new AbstractMap.SimpleEntry<>(valueOf(test.getShift()), test.getId())));
            }
        });

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            jsonObject = objectMapper.writeValueAsString(menu);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    public String getTest(long testId) {
        Test test = testService.findTest(testId);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            jsonObject = objectMapper.writeValueAsString(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getTextBySectionId(String sectionPath) {

        String fullPath = String.format(FILE_PATH, sectionPath);

        try {
            data = new String(Files.readAllBytes(Paths.get(fullPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return SUCCESS;
    }

    public String getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSectionPath() {
        return sectionPath;
    }

    public void setSectionPath(String sectionPath) {
        this.sectionPath = sectionPath;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
}
