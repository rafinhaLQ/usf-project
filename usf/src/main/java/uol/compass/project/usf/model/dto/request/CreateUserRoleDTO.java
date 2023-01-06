package uol.compass.project.usf.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRoleDTO {

    private Long idUser;

    private List<Long> idRoles;

}
