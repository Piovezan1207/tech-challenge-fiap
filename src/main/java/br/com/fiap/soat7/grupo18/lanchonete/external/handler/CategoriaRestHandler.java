package br.com.fiap.soat7.grupo18.lanchonete.external.handler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.soat7.grupo18.lanchonete.external.handler.dto.CategoriaHandlerResponseDto;
import br.com.fiap.soat7.grupo18.lanchonete.external.handler.service.CategoriaRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lanchonete/v1/categorias")
@Tag(name = "Categorias", description = "Categorias de produtos.")
public class CategoriaRestHandler {

    private CategoriaRestService categoriaService;

    public CategoriaRestHandler(CategoriaRestService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @Operation(description = "Lista todas as categorias disponíveis")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(mediaType = "application/json" , schema = @Schema(implementation = CategoriaHandlerResponseDto.class)))
    public ResponseEntity<List<CategoriaHandlerResponseDto>> getAllCategorias() {
        var categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }



    

}
