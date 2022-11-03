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

    @Shared
    @AutoCleanup
    @Inject
    @Client("/")
    HttpClient client

    void "test index with Page"() {
        when:
        def request = HttpRequest.GET("/widgets")
        client.toBlocking().retrieve(request, Page.class);

        then:
        noExceptionThrown()
    }
}
