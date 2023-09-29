package Algorize.KorEngSATGPT.MVP;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class MVPController {

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        // Handle the uploaded image file
        // You can call the service layer here to process the uploaded file

        // Return a response
        return ResponseEntity.ok("Image uploaded successfully!"); // You can modify the response as needed
    }
}
