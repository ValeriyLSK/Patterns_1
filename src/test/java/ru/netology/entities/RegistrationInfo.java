package ru.netology.entities;

import lombok.Data;

@Data
public class RegistrationInfo {
    private final String address;
    private final String name;
    private final String phoneNumber;
}
