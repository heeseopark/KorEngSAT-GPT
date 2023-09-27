//package Algorize.KorEngSATGPT.Service;
//
//import Algorize.KorEngSATGPT.Domain.ImageDomain;
//import Algorize.KorEngSATGPT.Domain.PassageDomain;
//import Algorize.KorEngSATGPT.Domain.QuestionDomain;
//
//import Algorize.KorEngSATGPT.Repository.Repository;
//import jakarta.transaction.Transactional;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
public class OCRService {
//
//    // Assuming you are injecting the repositories via a constructor
//    private final Repository repository;
//
//    public OCRService(Repository repository) {
//        this.repository = repository;
//    }
//
//    public void checkAndSaveImage(BufferedImage inputImage) {
//        if (!checkValidText(inputImage)) {
//            throw new RuntimeException("No valid text found in the image");
//        }
//
//        int recognizedQuestions = checkValidQuestion(inputImage);
//        int recognizedPassages = checkValidPassage(inputImage);
//
//        for (int i = 0; i < recognizedQuestions; i++) {
//            saveQuestion(inputImage, i);
//        }
//
//        for (int i = 0; i < recognizedPassages; i++) {
//            // savePassage(inputImage, i);
//        }
//
//        saveImage(inputImage);
//    }
//
//    private void saveImage(BufferedImage inputImage) {
//
//    }
//
//    private boolean checkValidText(BufferedImage inputImage) {
//        // Implement logic to check for valid text in the image
//        // Return true if valid text is found, false otherwise
//        return true;
//    }
//
//    private int checkValidQuestion(BufferedImage inputImage) {
//        // Implement logic to check for valid questions in the image
//        // Return the number of recognized questions
//        return 0; // Placeholder value
//    }
//
//    private int checkValidPassage(BufferedImage inputImage) {
//        // Implement logic to check for valid passages in the image
//        // Return the number of recognized passages
//        return 0; // Placeholder value
//    }
//
//    @Transactional
//    private void saveQuestion(BufferedImage inputImage, int questionIndex) {
//        QuestionDomain questionDomain = new QuestionDomain();
//        // Populate the QuestionDomain object with recognized data
//        questionDomain.setQuestionNumber(questionIndex);
//        questionDomain.setQuestionText("Recognized Question Text"); // Placeholder value
//        questionDomain.setSelections(new ArrayList<>());
//        questionDomain.setInnerReferTextMap(new HashMap<>());
//        // passage domain에 있는 참조 텍스트 받아와야함.
//        questionDomain.setAnswerMap(new HashMap<>());
//
//        // Save the QuestionDomain object to the database
//        repository.saveQuestion(questionDomain);
//    }
//
////    @Transactional
////    private void savePassage(BufferedImage inputImage, int passageIndex) {
////        PassageDomain passageDomain = new PassageDomain();
////        // Populate the PassageDomain object with recognized data
////        passageDomain.setQuestionNumStart(passageIndex);
////        passageDomain.setQuestionNumEnd(passageIndex);
////        passageDomain.setQuestionText("Recognized Passage Text"); // Placeholder value
////        passageDomain.setPassageTextList(new ArrayList<>());
////        passageDomain.setReferTextMap(new HashMap<>());
////        passageDomain.setReferImageMap(new HashMap<>());
////
////        // Save the PassageDomain object to the database
////        repository.savePassage(passageDomain);
////    }
//
////    @Transactional
////    private void saveImage(BufferedImage inputImage) {
////        try {
////            ByteArrayOutputStream baos = new ByteArrayOutputStream();
////            ImageIO.write(inputImage, "png", baos);
////            byte[] imageData = baos.toByteArray();
////
////            ImageDomain imageEntity = new ImageDomain();
////            imageEntity.setImageData(imageData);
////
////            repository.saveImage(imageEntity);
////        } catch (IOException e) {
////            throw new RuntimeException("Error while saving the image", e);
////        }
////    }
}
