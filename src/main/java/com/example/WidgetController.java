package com.example;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/widgets")
public class WidgetController {

    private final WidgetRepository widgetRepository;

    public WidgetController(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    @Get
    public Page<WidgetDTO> index(Pageable pageable) {
        return widgetRepository.findAll(pageable).map(WidgetDTO::new);
    }
}