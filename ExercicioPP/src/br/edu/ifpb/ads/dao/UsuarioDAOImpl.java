package br.edu.ifpb.ads.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.dto.UsuarioDTO;

public class UsuarioDAOImpl implements UsuarioDAO {
	private List<UsuarioDTO> usuarios = new ArrayList<>();

	@Override
	public void adicionarUsuario(UsuarioDTO usuario) {
		usuarios.add(usuario);
	}

	@Override
	public void atualizarUsuario(String email, UsuarioDTO usuario) {
		UsuarioDTO usuarioExistente = buscarUsuarioPorEmail(email);

		if (usuarioExistente != null) {
			usuarioExistente.setNome(usuario.getNome());
			usuarioExistente.setEmail(usuario.getEmail());
			usuarioExistente.setTelefone(usuario.getTelefone());
		}

	}

	@Override
	public void removerUsuario(String email) {
		usuarios.removeIf(u -> u.getEmail().equals(email));
	}

	@Override
	public UsuarioDTO buscarUsuarioPorEmail(String email) {
		for (UsuarioDTO u : usuarios) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		return usuarios;
	}
}