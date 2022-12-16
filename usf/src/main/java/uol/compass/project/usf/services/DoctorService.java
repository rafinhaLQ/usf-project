package uol.compass.project.usf.services;

import uol.compass.project.usf.dto.request.DoctorRequestDTO;
import uol.compass.project.usf.dto.response.DoctorResponseDTO;
import uol.compass.project.usf.dto.response.DoctorResponseParameters;

import org.springframework.data.domain.Pageable;

public interface DoctorService {
    DoctorResponseDTO create(DoctorRequestDTO request);

    DoctorResponseParameters findAll(Pageable pageable);

    DoctorResponseDTO findById(Long id);

    DoctorResponseDTO update(Long id, DoctorRequestDTO request);

    void delete(Long id);
}
