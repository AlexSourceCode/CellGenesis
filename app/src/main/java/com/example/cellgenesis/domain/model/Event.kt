package com.example.cellgenesis.domain.model

sealed class Event {
    object CreateLife : Event()
    object DestroyLife : Event()
    object Inactive : Event()

}

