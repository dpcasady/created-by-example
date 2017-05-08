package com.example

abstract class Vehicle {

    String name

    Date dateCreated

    static mapping = {
        tablePerConcreteClass true
        id generator: 'increment'
    }

}
