package kr.co.sboard.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Terms")
public class TermsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String terms;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String privacy;



}
