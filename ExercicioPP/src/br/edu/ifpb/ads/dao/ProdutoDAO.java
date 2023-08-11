package br.edu.ifpb.ads.dao;

import java.util.List;

import br.edu.ifpb.ads.dto.ProdutoDTO;

public interface ProdutoDAO {
	
	
	
	void adicionarProduto(ProdutoDTO produto);
    void atualizarProduto(String nome, ProdutoDTO produto);
    void removerProduto(String nome);
    ProdutoDTO buscarProdutoPorNome(String nome);
    List<ProdutoDTO> listarProdutos();

}
