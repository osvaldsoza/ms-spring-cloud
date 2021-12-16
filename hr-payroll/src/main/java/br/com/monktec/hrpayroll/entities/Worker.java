package br.com.monktec.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name", "dailyIncome"})
public class Worker implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;
}
