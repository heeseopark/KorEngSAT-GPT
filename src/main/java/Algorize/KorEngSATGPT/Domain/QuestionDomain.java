package Algorize.KorEngSATGPT.Domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter @Setter
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

    @Column(name = "refer_text_symbol")
    private String referTextName;

    @Column(name = "refer_text_text")
    private String referTextInText;

    // Constructors
    // 참조 텍스트으 외부 mapping 여부를 선택할 수 있는지...?
}

