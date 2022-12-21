package uol.compass.project.usf.services;

import org.springframework.data.domain.Pageable;

import uol.compass.project.usf.dto.request.SolicitationRequestDTO;
import uol.compass.project.usf.dto.response.SolicitationResponseDTO;
import uol.compass.project.usf.dto.response.SolicitationResponseParameters;

public interface SolicitationService {
    
    SolicitationResponseDTO create(SolicitationRequestDTO request);

    SolicitationResponseParameters findAll(Pageable pageable);

    SolicitationResponseDTO findById(Long id);

}
