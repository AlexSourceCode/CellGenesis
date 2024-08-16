package com.example.cellgenesis.domain.model

sealed class Cell {
    class Alive : Cell()
    class Dead : Cell()
}
