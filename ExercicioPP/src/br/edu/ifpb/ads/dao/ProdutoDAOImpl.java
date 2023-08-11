package br.edu.ifpb.ads.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.dto.ProdutoDTO;

public class ProdutoDAOImpl implements ProdutoDAO {
    
	private List<ProdutoDTO> produtos = new ArrayList<>();

    @Override
    public void adicionarProduto(ProdutoDTO produto) {
        produtos.add(produto);
    }

    @Override
    public void atualizarProduto(String nome, ProdutoDTO produto) {
        	ProdutoDTO produtoExistente = buscarProdutoPorNome(nome);
            if (produtoExistente != null) {
            	produtoExistente.setNome(produto.getNome());
            	produtoExistente.setDescricao(produto.getDescricao());
            	produtoExistente.setPreco(produto.getPreco());
            }
        
    }

    @Override
    public void removerProduto(String nome) {
        produtos.removeIf(p -> p.getNome().equals(nome));
    }

    @Override
    public ProdutoDTO buscarProdutoPorNome(String nome) {
        for (ProdutoDTO p : produtos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<ProdutoDTO> listarProdutos() {
        return produtos;
    }
}
