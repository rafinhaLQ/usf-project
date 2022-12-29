package uol.compass.project.usf.config.security.user;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uol.compass.project.usf.config.security.role.CreateUserRoleDTO;
import uol.compass.project.usf.config.security.role.RoleUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    private final RoleUserService roleUserService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO request) {
        UserResponseDTO response = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable("id") Long id,
            @RequestBody @Valid UserRequestDTO request) {
        UserResponseDTO response = userService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/role")
    public ResponseEntity<UserResponseDTO> role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
        UserResponseDTO response = roleUserService.execute(createUserRoleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
