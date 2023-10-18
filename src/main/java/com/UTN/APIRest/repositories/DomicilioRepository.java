package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long>{
    List<Domicilio> findByCalleContaining(String calle);

    Page<Domicilio> findByCalleContaining(String calle, Pageable pageable);

    @Query(value = "SELECT c FROM Domicilio c WHERE c.calle LIKE %:filtro%")
    List<Domicilio> search(String filtro);

    @Query(value = "SELECT c FROM Domicilio c WHERE c.calle LIKE %:filtro%")
    Page<Domicilio> search(String filtro, Pageable pageable);
    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") String filtro);



    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM calle",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
