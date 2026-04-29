package org.example.hnk24cntt1lathephong_004.repository;

import org.example.hnk24cntt1lathephong_004.model.Spacecraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpacecratRepository extends JpaRepository<Spacecraft, Long> {
    Page<Spacecraft> findByNameContainingIgnoreCaseOrManufacturerContainingIgnoreCase(String name, String manufacturer, Pageable pageable);
}
