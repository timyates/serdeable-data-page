package com.example;

import io.micronaut.data.model.Page;
import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport(Page.class)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
