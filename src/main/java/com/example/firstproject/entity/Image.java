package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR4",
        sequenceName = "IMAGE_SEQUENCE",
        allocationSize = 1
)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    public Image() {
    }
    public Image(String imagePath,Post post) {
        this.imagePath=imagePath;
        this.post=post;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
//    public String getImagePath() {
//        return imagePath;
//    }
}
