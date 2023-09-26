package Algorize.KorEngSATGPT.MVP;

import lombok.AllArgsConstructor;
import lombok.Getter;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "mvp_domain")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MVPDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_text")
    private String imageText;

    @ElementCollection
    @MapKeyColumn(name = "answer_number")
    @Column(name = "solution_text")
    @CollectionTable(name = "answer_map", joinColumns = @JoinColumn(name = "mvp_domain_id"))
    private Map<Integer, String> answerMap;


}
