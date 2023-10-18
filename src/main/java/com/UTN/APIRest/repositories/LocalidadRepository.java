package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long> {
    List<Localidad> findByDenominacionContaining(String denominacion);

    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    @Query(value = "SELECT d FROM Localidad d WHERE d.denominacion LIKE %:filtro%")
    List<Localidad> search(String filtro);

    @Query(value = "SELECT d FROM Localidad d WHERE d.denominacion LIKE %:filtro%")
    Page<Localidad> search(String filtro, Pageable pageable);
    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);



    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
