package uol.compass.project.usf.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.project.usf.entities.DoctorEntity;
import uol.compass.project.usf.entities.UsfEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDTO {

    private Long id;

    private String color;

    private UsfEntity currentUSF;

    private List<DoctorEntity> doctors;

}
