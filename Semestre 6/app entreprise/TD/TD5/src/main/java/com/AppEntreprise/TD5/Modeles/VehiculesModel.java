package com.AppEntreprise.TD5.Modeles;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculesModel {
    private String marque;
    private String modele;
    private String immat;
    private Integer nbrPlace;
}
