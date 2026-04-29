package org.example.hnk24cntt1lathephong_004.service;

import lombok.RequiredArgsConstructor;
import org.example.hnk24cntt1lathephong_004.model.Spacecraft;
import org.example.hnk24cntt1lathephong_004.repository.SpacecratRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpacecraftService {
    private final SpacecratRepository spacecratRepository;
    public List<Spacecraft> getAll() {
        return spacecratRepository.findAll();
    }
    public Spacecraft findById(Long id) {
        return spacecratRepository.findById(id).orElse(null);
    }
    public Spacecraft save(Spacecraft spacecraft) {
        return spacecratRepository.save(spacecraft);
    }
    public void delete(Long id) {
        spacecratRepository.deleteById(id);
    }
}
