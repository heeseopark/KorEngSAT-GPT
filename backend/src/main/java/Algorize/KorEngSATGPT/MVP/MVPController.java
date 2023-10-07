package Algorize.KorEngSATGPT.MVP;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MVPController {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }

    private final MVPService mvpService;

    public MVPController(MVPService mvpService) {
        this.mvpService = mvpService;
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        // Handle the uploaded image file
        // You can call the service layer here to process the uploaded file

        // Return a response
        return ResponseEntity.ok("Image uploaded successfully!"); // You can modify the response as needed
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<String> getImage(@PathVariable Long id) {
        // Fetch the MVPDomain object using the service layer
        Optional<MVPDomain> optionalMvpDomain = mvpService.findById(id);

        // Check if the MVPDomain object is present
        if (optionalMvpDomain.isPresent()) {
            MVPDomain mvpDomain = optionalMvpDomain.get();
            // Return the image URL
            return ResponseEntity.ok(mvpDomain.getImageUrl());
        } else {
            // Return a 404 Not Found status if the object is not present
            return ResponseEntity.notFound().build();
        }
    }
}
