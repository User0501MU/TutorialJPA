//エンティティの作成4.3
package com.techacademy16;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="country")
public class Country {
    @Id
    private String code;
    private String name;
    private int population;
}