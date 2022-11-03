package com.example;

import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

@Singleton
public class Bootstrap {

    private final WidgetRepository widgetRepository;

    public Bootstrap(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    @EventListener
    public void createData(ServerStartupEvent event) {
        Widget widget = new Widget();
        widget.setName("One");
        widgetRepository.save(widget);
    }
}
