package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private int numOfHouse;
    private int numOfApartment;
    private String postalCode;

}
