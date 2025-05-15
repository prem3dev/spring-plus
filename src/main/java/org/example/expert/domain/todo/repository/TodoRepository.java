package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("""
        SELECT t FROM Todo t
        WHERE (:weather IS NULL OR t.weather = :weather)
          AND (:fromDate IS NULL OR t.modifiedAt >= :fromDate)
          AND (:toDate IS NULL OR t.modifiedAt <= :toDate)
        ORDER BY t.modifiedAt DESC
        """)
    Page<Todo> searchByCondModifiedAtDesc(
        @Param("weather") String weather,
        @Param("fromDate") LocalDateTime fromDate,
        @Param("toDate") LocalDateTime toDate,
        Pageable pageable
    );

    @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);

}
