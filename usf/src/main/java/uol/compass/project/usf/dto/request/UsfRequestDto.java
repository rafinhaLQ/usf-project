package uol.compass.project.usf.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsfRequestDto {

    @NotBlank
    private String name;

    private Long idCurrentTeam;

    @NotNull
    private String address;

}
