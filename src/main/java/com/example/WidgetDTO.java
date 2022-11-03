package com.example;


import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class WidgetDTO {
    private final Long id;
    private final String name;

    public WidgetDTO(Widget w) {
        this.id = w.getId();
        this.name = w.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
