package com.example.foyerrouamnissi.DTO;

import com.example.foyerrouamnissi.DAO.Entities.TypeChambre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChambreTypeStatistics {

    private TypeChambre type;
    private Long count;
}
