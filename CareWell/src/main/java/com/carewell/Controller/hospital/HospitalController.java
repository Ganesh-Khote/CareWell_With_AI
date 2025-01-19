package com.carewell.Controller.hospital;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carewell.AuthJwt.JwtUtils;
import com.carewell.Hospital.DoctorEntity;

// import com.carewell.services.hospital.HospitalService;
import com.carewell.services.hospital.activity.HospitalactivityService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

   @Autowired
   HospitalactivityService hospitalactivityService;

   
    JwtUtils jwtUtils=new JwtUtils();

    @Value("${image.upload.dir}")
    private String uploadDir;

   

    

    @PostMapping("/{id}/image")
    public ResponseEntity<String> uploadHospitalImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            // 1. Create the directory if it doesn't exist
            Path dirPath = Paths.get(uploadDir);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // 2. Generate a unique file name
            String fileName = "hospital_" + id + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = dirPath.resolve(fileName);

            // 3. Save the file to the file system
            file.transferTo(filePath.toFile());

            // 4. Save the file path in the database
            hospitalactivityService.saveHospitalImage(id, filePath.toString());

            return ResponseEntity.ok("Image uploaded successfully!");

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving image: " + e.getMessage());
        }
    }

    @PostMapping("/add-doctor")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorEntity doctor, @RequestHeader("Authorization") String token) {
    // Extract hospitalId from JWT token
    Long hospitalId = this.jwtUtils.extractHospitalId(token);

    // Add doctor for the logged-in hospital
    DoctorEntity addedDoctor = hospitalactivityService.addDoctor(hospitalId, doctor);
    return ResponseEntity.status(HttpStatus.CREATED).body(addedDoctor);
}


//Get the data




}
