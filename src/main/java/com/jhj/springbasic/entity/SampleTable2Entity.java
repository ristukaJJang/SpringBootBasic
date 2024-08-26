package com.jhj.springbasic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//create table sample_table2 (sample_ai int primary key auto_increment, sample_column boolean);

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="st2")
@Table(name="sample_table2")
public class SampleTable2Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleAi;
    private boolean sampleColumn;    
}
