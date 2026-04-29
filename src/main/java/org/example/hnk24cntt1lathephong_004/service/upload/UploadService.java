package org.example.hnk24cntt1lathephong_004.service.upload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final Cloudinary cloudinary;
    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            if(fileName != null && fileName.contains(".")) {
                fileName = fileName.substring(0,fileName.lastIndexOf("."));
            }
            Map uploadParams = ObjectUtils.asMap(
                    "public_id",fileName
            );
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), uploadParams);
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}