package com.marceltex.recipeapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Images(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "recipeId") val recipeId: Int,
    @ColumnInfo(name = "path") val path: String
)
