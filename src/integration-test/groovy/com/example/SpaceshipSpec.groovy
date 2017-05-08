package com.example

import grails.test.mixin.integration.Integration
import spock.lang.Specification
import grails.transaction.Rollback

@Integration
@Rollback
class SpacechipSpec extends Specification {

    void "should set the dateCreated automatically"() {
        given:
        Spaceship ship = new Spaceship(name: "Heart of Gold")
        ship.save(flush: true)

        expect:
        ship.dateCreated != null
    }

    void "should set the dateCreated automatically on update"() {
        given:
        Spaceship ship = new Spaceship(name: "Heart of Gold")
        ship.save()

        when:
        ship.name = "Heart of Gold II"
        ship.save(flush: true)

        then:
        // DataIntegrityViolationException is thrown:
        // NULL not allowed for column "DATE_CREATED"
        ship.dateCreated != null
    }

}
