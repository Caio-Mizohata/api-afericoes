package application.afericoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/afericoes")
@Tag(name = "Aferições", description = "Gerencia os registros de aferições de sensores")
public class AfericaoController {
    @Autowired
    private AfericaoService afericaoService;

    @GetMapping
    @Operation(summary = "Lista todas as aferições", description = "Retorna uma lista com todas as aferições registradas.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public Iterable<AfericaoDTO> getAll() {
        return afericaoService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém dados de uma aferição específica", description = "Retorna os dados da aferição identificada pelo ID fornecido.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Aferição encontrada e retornada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aferição não encontrada")
    })
    public AfericaoDTO getOne(@Parameter(description = "ID da aferição a ser consultado") @PathVariable long id) {
        return afericaoService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "Insere uma nova aferição", description = "Cria um novo registro na base de dados de aferição com os dados enviados.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Aferição criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public AfericaoDTO insert(@RequestBody AfericaoInsertDTO afericao) {
        return afericaoService.insert(afericao);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza aferição existente", description = "Altera os dados de uma aferição já cadastrada, identificada pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Aferição atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aferição não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public AfericaoDTO update(@Parameter(description = "ID da aferição a ser atualizada") @PathVariable long id, @RequestBody AfericaoInsertDTO afericao) {
        return afericaoService.update(id, afericao);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma aferição existente", description = "Remove uma aferição já cadastrada, identificada pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Aferição removida com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aferição não encontrada")
    })
    public void delete(@Parameter(description = "ID da aferição a ser removida") @PathVariable long id) {
        afericaoService.delete(id);
    }
}
