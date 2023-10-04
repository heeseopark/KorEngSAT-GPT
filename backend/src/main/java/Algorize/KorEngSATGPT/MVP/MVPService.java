package Algorize.KorEngSATGPT.MVP;

import Algorize.KorEngSATGPT.Exception.NoTextFoundException;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class MVPService {

    private final MVPRepository mvpRepository;

    public MVPService(MVPRepository mvpRepository) {
        this.mvpRepository = mvpRepository;
    }

    public String findText(MVPDomain mvpDomain){
        // Use Tesseract to get text from image URL
        String text = ""; // Replace with actual implementation

        if (text.isEmpty()) {
            throw new NoTextFoundException("No text found");
        }

        // tesseract related codes

        return text;
    }

    private MVPDomain saveText(MVPDomain mvpDomain) {
        String text = findText(mvpDomain);
        mvpDomain.setImageText(text);
        mvpRepository.save(mvpDomain);
        return mvpDomain;
    }

    public String getGptAnswer(MVPDomain mvpDomain){
        String text = "";
        // add code of first getting the imagetext field from the mvpDomain and sending it to the gpt using gpt api.
        // this function should return the text that gpt has provided

        return text;
    }

    public Map<Integer, String> findAndSaveAnswer(Long id){
        // Get the MVPDomain from the DB using the repository function
        MVPDomain mvpDomain =  new MVPDomain();//mvpRepository.findById(id);

        String text = mvpDomain.getImageText();

        // Pass it through the GPT using GPT API
        Map<Integer, String> answerMap = null; // Replace with actual implementation



        // Save the answerMap in the MVPDomain
        mvpDomain.setAnswerMap(answerMap);
        mvpRepository.save(mvpDomain);

        return answerMap;
    }

    public Optional<MVPDomain> findById(Long id) {
    }
}
