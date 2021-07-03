package com.example.todolistcompose.domain.model

import com.example.todolistcompose.data.database.model.ColorDbModel

data class ColorModel(
    val id: Long,
    val name: String,
    val hex: String
) {

    companion object {

        val DEFAULT = with(ColorDbModel.DEFAULT_COLOR) { ColorModel(id, name, hex) }
    }
}