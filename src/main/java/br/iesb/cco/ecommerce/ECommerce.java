package br.iesb.cco.ecommerce;

import java.util.List;

class Categoria {
    Long id;
    String nome;
    Categoria pai;

    public String toString() {
        String str = "Categoria=[";
        str += "id: " + id + ",";
        str += "nome: " + nome + "]";
        return str;
    }

}

class Produto extends Object {
    Produto proximo;

    String id;
    String nome;
    Double preco;
    String descricao;
    int quantidade;
    Categoria categoria;

    public String toString() {
        String str = "Produto=[";
        str += "id: " + id + ", ";
        str += " nome: " + nome + ", ";
        str += " descricao: " + descricao + ", ";
        str += " preco: " + preco + ", ";
        str += " quantidade: " + quantidade + ", ";
        str += " categoria: " + categoria + "]";
        return str;
    }
}


public class ECommerce {

    private Produto primeiro;

    public ECommerce() {
        criarProdutosPromocao();
    }

    public Produto listarPromocoes() {
        return primeiro;
    }

    void listarMaisVendidos() {

    }

    private void criarProdutosPromocao() {
        this.primeiro = new Produto();
        this.primeiro.id = "PDT001XVCD";
        this.primeiro.nome = "Heineken 350ml";
        this.primeiro.categoria = new Categoria();
        this.primeiro.categoria.nome = "Cerveja";
        this.primeiro.categoria.id = 123123L;
        this.primeiro.preco = 30.0;
        this.primeiro.descricao = "Cerveja Heineken";
        this.primeiro.quantidade = 1200;

        Produto segundo = new Produto();
        segundo.id = "PDT001RAZER";
        segundo.nome = "Liqui Razer";
        segundo.categoria = new Categoria();
        segundo.categoria.nome = "Eletrodomestico";
        segundo.categoria.id = 123L;
        segundo.descricao = "Liqui Top Razer";
        segundo.preco = 18500.90;
        segundo.quantidade = 20;

        primeiro.proximo = segundo;

        Produto terceiro = new Produto();
        terceiro.id = "PDT002RAZER";
        terceiro.nome = "Mouse Razer";
        terceiro.categoria = new Categoria();
        terceiro.categoria.nome = "Informatica";
        terceiro.categoria.id = 321L;
        terceiro.preco = 15000.50;
        terceiro.descricao = "Mouse Razer";
        terceiro.quantidade = 2;

        segundo.proximo = terceiro;

        if (primeiro.nome.contains("Razer")) {
            primeiro.preco = primeiro.preco * 0.95;
        } else {
            primeiro.preco = primeiro.preco * 0.25;
        }

        if (segundo.nome.contains("Razer")) {
            segundo.preco = segundo.preco * 0.95;
        } else {
            segundo.preco = segundo.preco * 0.40;
        }

        if (terceiro.nome.contains("Razer")) {
            terceiro.preco = terceiro.preco * 0.95;
        } else {
            terceiro.preco = terceiro.preco * 0.55;
        }
    }

}


class ServidorAmazon {
    public static void main(String[] args) {
        ECommerce e = new ECommerce();
        Produto p = e.listarPromocoes();
        while (p != null) {
            System.out.println("Produtos: " + p.toString());
            p = p.proximo;
        }
    }
}

class ServidorAzure {
    public static void main(String[] args) {
        ECommerce e = new ECommerce();
        Produto p = e.listarPromocoes();
        while (p != null) {
            System.out.println("Produtos: " + p.toString());
            p = p.proximo;
        }
    }
}

