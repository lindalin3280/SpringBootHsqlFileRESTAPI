package org.linda.restdemo.controller;

import java.io.File;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class UploadAndQueryAPITest {
	private static final String projectPath = System.getProperty("user.dir");
    private static final String fileSeparator = File.separator;

    @Test
    public void uploadTest() {
        String url = "http://127.0.0.1:8080/file/upload";
        String filePath = projectPath + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "demo.txt";

        RestTemplate rest = new RestTemplate();

        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", resource);
        param.add("userId", "tester");

        String s = rest.postForObject(url, param, String.class);
        System.out.println(s);
    }
    
    @Test
    public void queryTest() {
    	String url = "http://localhost:8080/file/query?fileName=demo.txt";
    	RestTemplate rest = new RestTemplate();
    	String s = rest.getForObject(url, String.class);
    	System.out.println(s);
    }
}
