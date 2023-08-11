package br.edu.ifpb.ads.controller;

import java.util.List;

import br.edu.ifpb.ads.dao.UsuarioDAO;
import br.edu.ifpb.ads.dto.UsuarioDTO;

public class UsuarioController {
	private UsuarioDAO usuarioDAO;

	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void adicionarUsuario(UsuarioDTO usuario) {
		usuarioDAO.adicionarUsuario(usuario);
	}

	public void atualizarUsuario(String email, UsuarioDTO usuario) {
		usuarioDAO.atualizarUsuario(email, usuario);
	}

	public void removerUsuario(String email) {
		usuarioDAO.removerUsuario(email);
	}

	public UsuarioDTO buscarUsuarioPorEmail(String email) {
		return usuarioDAO.buscarUsuarioPorEmail(email);
	}

	public List<UsuarioDTO> listarUsuarios() {
		return usuarioDAO.listarUsuarios();
	}
}