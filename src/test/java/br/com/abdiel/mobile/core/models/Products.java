package br.com.abdiel.mobile.core.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Products {

    private List<String> mice;
    private List<String> laptops;
    private List<String> tablets;
    private List<String> headphones;
    private List<String> speadkers;
    private List<String> error;
}
