package uol.compass.project.usf.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import uol.compass.project.usf.dto.request.TeamRequestDTO;
import uol.compass.project.usf.dto.response.TeamResponseDTO;
import uol.compass.project.usf.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> registerTeam(@RequestBody TeamRequestDTO teamRequestDTO){
        try {
            validateTeamParameter(teamRequestDTO);
            TeamResponseDTO teamResponseDTO = teamService.createTeam(teamRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(teamResponseDTO);
        }catch (IllegalStateException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> teams = teamService.getTeams();
        return ResponseEntity.status(HttpStatus.OK).body(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable Long id) {
        TeamResponseDTO teamResponseDTO = teamService.getTeamById(id);
        return ResponseEntity.status(HttpStatus.OK).body(teamResponseDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TeamResponseDTO> atualizarPartido(@PathVariable Long id,
                                                            @RequestBody TeamRequestDTO partidoRequestDTO) {
        TeamResponseDTO partidoResponseDTO = teamService.update(id, partidoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(partidoResponseDTO);
    }

    private void validateTeamParameter(TeamRequestDTO teamRequestDTO) {
        char[] chars = teamRequestDTO.getColor().toCharArray();
        for (char c:chars) {
            if (!Character.isAlphabetic(c)) {
                throw new IllegalStateException();
            }
        }
    }

}