package com.builtech.gst.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Data
public class StadeRegister {
    private String name;
    private String adresse;
    private String location;
    private String contact;
    private List<String> images;
}
