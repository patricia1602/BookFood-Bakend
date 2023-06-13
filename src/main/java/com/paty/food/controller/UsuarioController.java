package com.paty.food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paty.food.DTO.UsuarioAccessDTO;
import com.paty.food.model.ReturnError;
import com.paty.food.model.Usuario;
import com.paty.food.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
@CrossOrigin
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    @RequestMapping("access")
    public ResponseEntity<Object> access(@RequestBody UsuarioAccessDTO pUsuario) {
        Usuario usuario = new Usuario();
        try {
        usuario = usuarioService.access(pUsuario);
            if(usuario != null) {
                return ResponseEntity
                .status(HttpStatus.OK)
                .header("access", "true")
                .body(usuario);
            } else {
                return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("access", "false")
                .body(new ReturnError(HttpStatus.NOT_FOUND, 
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Usuário não encontrado", "/api/usuario/create"));
            }
        } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("access", "false")
                .body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(), "/api/usuario/create"));            
        }
    }    
        
	@GetMapping
	@RequestMapping("find-all")
	public ResponseEntity<Object> findAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK)
            .body(usuarioService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                             e.getMessage(),
							"/api/usuario/find-all"));
		}
	}

	@PostMapping
	@RequestMapping("create")
	public ResponseEntity<Object> create(@RequestBody Usuario pUsuario) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
            .body(usuarioService.save(pUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ReturnError(HttpStatus.INTERNAL_SERVER_ERROR,
							HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                             e.getMessage(),
							"/api/usuario/create"));
		}

   }

}
