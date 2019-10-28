package com.marceltex.recipeapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.marceltex.recipeapp.model.Image
import com.marceltex.recipeapp.model.Recipe
import com.marceltex.recipeapp.model.RecipeWithImages
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface RecipeDao {

    @Transaction
    @Query("SELECT * from recipes")
    fun getAll(): Observable<List<RecipeWithImages>>

    @Insert
    fun insertRecipe(recipe: Recipe): Single<Long>

    @Insert
    fun insertImages(images: List<Image>): Completable
}
