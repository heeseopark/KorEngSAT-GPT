package Algorize.KorEngSATGPT.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

@Entity
@Getter @Setter
@Table(name = "passages")
public class PassageDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_num_start")
    private int questionNumStart;

    @Column(name = "question_num_end")
    private int questionNumEnd;

    @Column(name = "question_text", length = 1000) // Assuming a max length of 1000 for the question text
    private String questionText;

    @ElementCollection
    @CollectionTable(name = "passage_texts", joinColumns = @JoinColumn(name = "passage_id"))
    @Column(name = "text_segment")
    private List<String> passageTextList;

    @ElementCollection
    @CollectionTable(name = "refer_texts", joinColumns = @JoinColumn(name = "passage_id"))
    @MapKeyColumn(name = "refer_symbol")
    @Column(name = "refer_text")
    private Map<String, String> referTextMap;

    // Note: Storing images in databases as BLOBs can be inefficient.
    // It might be better to store the image file paths in the database and the images in a file system or cloud storage.
    @ElementCollection
    @CollectionTable(name = "refer_images", joinColumns = @JoinColumn(name = "passage_id"))
    @MapKeyColumn(name = "image_id")
    @Column(name = "image_data")
    private Map<Integer, BufferedImage> referImageMap;

    // ... getters, setters, and other necessary methods go here ...

}
