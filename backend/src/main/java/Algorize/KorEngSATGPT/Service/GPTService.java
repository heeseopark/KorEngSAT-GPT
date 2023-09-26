package Algorize.KorEngSATGPT.Service;

import Algorize.KorEngSATGPT.Domain.QuestionDomain;
import Algorize.KorEngSATGPT.Repository.Repository;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GPT answer 그대로 가지고 온거라 한 번 확인해야함.
public class GPTService {
    private final Repository repository;

    public GPTService(Repository repository) {
        this.repository = repository;
    }

    // Assuming that the getAnswerMap method is meant to be called from outside,
    // and should find a QuestionDomain object, update its answerMap, and save it back.
    @Transactional
    public void updateAnswerMap(Long questionId) {
        // Retrieving the QuestionDomain object from the EntityManager
        QuestionDomain questionDomain = repository.findQuestionById(questionId);

        if(questionDomain == null) {
            throw new IllegalStateException("Question with id " + questionId + " not found");
        }

        // Getting the answerMap by calling the getAnswerMap method
        Map<Integer, String> answerMap = getAnswerMap(questionDomain);

        // Storing back the answerMap into the QuestionDomain object
        questionDomain.setAnswerMap(answerMap);

        // Updating the QuestionDomain object in the database
        repository.saveQuestion(questionDomain);
    }

    // Changed return type to Map<Integer, String> as we are getting a Map from askQuestion method
    public Map<Integer, String> getAnswerMap(QuestionDomain questionDomain) {
        StringBuilder prompt = new StringBuilder(questionDomain.getQuestionText());

        // Assume getSelections returns a List<String> of selections
        List<String> selections = questionDomain.getSelections();

        // Append each selection to the prompt
        for (String selection : selections) {
            prompt.append(" ").append(selection);
        }

        return askQuestion(prompt.toString());
    }

    private Map<Integer, String> askQuestion(String prompt) {
        // This method seems to simulate asking a question and receiving an answer.
        // The actual implementation will depend on how you are planning to get the answer.
        Integer answerselection = 0; // or some other default value
        String solutiontext = ""; // or some other default value

        Map<Integer, String> answerMap = new HashMap<>();
        answerMap.put(answerselection, solutiontext);

        return answerMap;
    }
}
