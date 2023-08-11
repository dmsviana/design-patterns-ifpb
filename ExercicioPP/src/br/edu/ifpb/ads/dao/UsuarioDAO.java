package br.edu.ifpb.ads.dao;

import java.util.List;

import br.edu.ifpb.ads.dto.UsuarioDTO;

public interface UsuarioDAO {
	
	void adicionarUsuario(UsuarioDTO usuario);
    void atualizarUsuario(String email, UsuarioDTO usuario);
    void removerUsuario(String email);
    UsuarioDTO buscarUsuarioPorEmail(String email);
    List<UsuarioDTO> listarUsuarios();

}
