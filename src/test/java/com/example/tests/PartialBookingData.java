package com.example.tests;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class PartialBookingData {
    String firstname;
    int totalprice;
}