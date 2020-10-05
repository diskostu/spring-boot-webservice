package de.diskostu.demo.springbootwebservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Greeting {

    private final long id;
    private final String content;
}