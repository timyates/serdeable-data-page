package com.example

import io.micronaut.data.model.Page
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class WidgetControllerSpec extends Specification {

    @Shared @AutoCleanup @Inject @Client("/")
    HttpClient client

    @Inject
    WidgetRepository widgetRepository;

    void "test index with Page"() {
        given:
        def widget = new Widget()
        widget.name = 'One'
        widgetRepository.save(widget);

        when:
        def request = HttpRequest.GET("/widgets")
        client.toBlocking().retrieve(request, Page.class);

        then :
        noExceptionThrown()
    }
}
