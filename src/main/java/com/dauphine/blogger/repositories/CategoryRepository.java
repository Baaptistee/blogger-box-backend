package com.dauphine.blogger.repositories;

import com.dauphine.blogger.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query("""
                    SELECT cat
                            FROM Category cat
                            WHERE cat.name LIKE %:name%
    """)
    List<Category> findAllByName(@Param("name") String name);

    @Query("""
        SELECT CASE WHEN COUNT(cat) > 0 THEN TRUE ELSE FALSE END
        FROM Category cat WHERE cat.name = :name
    """)
    boolean doesNameExist(@Param("name") String name);
}
