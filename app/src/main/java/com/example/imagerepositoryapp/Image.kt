package com.example.imagerepositoryapp

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Immutable
data class Image(
    @PrimaryKey val id: Long,
    val title: String,
    val imageUrl: String,
    val height: String
)
