package br.edu.ifpb.ads.controller;

import java.util.List;

import br.edu.ifpb.ads.dao.ProdutoDAO;
import br.edu.ifpb.ads.dto.ProdutoDTO;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void adicionarProduto(ProdutoDTO produto) {
        produtoDAO.adicionarProduto(produto);
    }

    public void atualizarProduto(String nome, ProdutoDTO produto) {
        produtoDAO.atualizarProduto(nome, produto);
    }

    public void removerProduto(String nome) {
        produtoDAO.removerProduto(nome);
    }

    public ProdutoDTO buscarProdutoPorNome(String nome) {
        return produtoDAO.buscarProdutoPorNome(nome);
    }

    public List<ProdutoDTO> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
}