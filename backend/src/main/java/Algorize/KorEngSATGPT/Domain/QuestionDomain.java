package Algorize.KorEngSATGPT.Domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Entity
@Getter @Setter
@Table(name = "questions")
public class QuestionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_number")
    private int questionNumber;

    @Column(name = "question_text")
    private String questionText;

    @ElementCollection
    @CollectionTable(name = "question_selections", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "selection")
    private List<String> selections;

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "refer_symbol")
    @Column(name = "refer_text")
    @CollectionTable(name = "inner_refer_texts", joinColumns = @JoinColumn(name = "question_id"))
    private Map<String, String> innerReferTextMap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passage_id")
    private PassageDomain passage;

    @ElementCollection
    @CollectionTable(name = "answer_solutions", joinColumns = @JoinColumn(name = "question_id"))
    @MapKeyColumn(name = "answer_number")
    @Column(name = "solution_text")
    private Map<Integer, String> answerMap;

    public Map<String, String> getOuterReferTextMap() {
        return passage.getReferTextMap();
    }

    // ... getters, setters, and other necessary methods go here ...

}

