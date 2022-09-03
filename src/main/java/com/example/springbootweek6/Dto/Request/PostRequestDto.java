package com.example.springbootweek6.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private  String title;

    private  String imageUrl;
    private  String review;



}
