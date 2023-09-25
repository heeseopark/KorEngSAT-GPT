package Algorize.KorEngSATGPT.Repository;

import Algorize.KorEngSATGPT.Domain.ImageDomain;
import Algorize.KorEngSATGPT.Domain.PassageDomain;
import Algorize.KorEngSATGPT.Domain.QuestionDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public QuestionDomain saveQuestion(QuestionDomain questionDomain) {
        entityManager.persist(questionDomain);
        return questionDomain;
    }

    @Transactional
    public PassageDomain savePassage(PassageDomain passageDomain) {
        entityManager.persist(passageDomain);
        return passageDomain;
    }

    @Transactional
    public ImageDomain saveImage(ImageDomain imageEntity) {
        entityManager.persist(imageEntity);
        return imageEntity;
    }

    public QuestionDomain findQuestionById(Long id) {
        return entityManager.find(QuestionDomain.class, id);
    }



    // Add other CRUD operations as needed...
}
