package com.paty.food.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.paty.food.DTO.UsuarioAccessDTO;
import com.paty.food.Util.Util;
import com.paty.food.model.Usuario;
import com.paty.food.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll(
                Sort.by(Sort.Direction.DESC, "id"));
    }

    public Usuario access(UsuarioAccessDTO pUsuario) {
        return usuarioRepository.access(
                pUsuario.getLogin(), pUsuario.getSenha());
    }

    public Usuario save(Usuario pUsuario) {
        pUsuario.setDataCriacao(Util.dataAtual());
        return usuarioRepository.save(pUsuario);
    }

    public Usuario update(Usuario pUsuario) {
		return usuarioRepository.save(pUsuario); 
	}

	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
}