package Algorize.KorEngSATGPT.MVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Repository
public class MVPRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(MVPDomain mvpDomain) {
        entityManager.persist(mvpDomain);
    }

    public Optional<MVPDomain> findById(Long id) {
        try {
            MVPDomain mvpDomain = entityManager.find(MVPDomain.class, id);
            return Optional.ofNullable(mvpDomain);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
