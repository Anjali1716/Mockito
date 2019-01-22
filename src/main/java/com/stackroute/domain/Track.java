package com.stackroute.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Track {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String trackName;
    private String trackComment;

}
