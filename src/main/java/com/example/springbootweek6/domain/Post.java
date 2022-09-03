package com.example.springbootweek6.domain;

import com.example.springbootweek6.Dto.Request.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String review;

    @Column(length = 1000)
    private String imgUrl;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Post(PostRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.review= requestDto.getReview();
        this.imgUrl= requestDto.getImageUrl();
    }
    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.review = requestDto.getReview();
        this.imgUrl = requestDto.getImageUrl();
    }
    public boolean validateMember(Member member) {
        return !this.member.equals(member);
    }


}
