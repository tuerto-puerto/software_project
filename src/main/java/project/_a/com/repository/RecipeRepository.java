package project._a.com.repository;

import project._a.com.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r JOIN r.ingredients i WHERE i.name IN :ingredients GROUP BY r HAVING COUNT(DISTINCT i.name) = :size")
    List<Recipe> findRecipesByIngredients(@Param("ingredients") List<String> ingredients, @Param("size") long size);
}

