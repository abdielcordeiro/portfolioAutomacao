#language: pt
#Author: abdiel.boaz1@gmail.com
#encoding: utf-8

Funcionalidade: Acao de buscar um produto na lupa

  Contexto:
    Dado que o usuario esteja na tela principal
    Quando clica no botao da lupa

  @buscarProduto
  Esquema do Cenario: Buscar um produto na lupa com Sucesso
    E digita nome do produto "<produto>"
    E clica no botao da lupa
    Então busca realizada com sucesso pelo produto "<produto>" encontrado

    Exemplos:
      | produto    |
      | MICE       |
      #| LAPTOPS    |
      #| TABLETS    |
      #| HEADPHONES |
      #| SPEAKERS   |

  @buscainexistente
  Cenário: Buscar um produto que não exista
    E digita nome do produto "ERROR"
    E clica no botao da lupa
    Então valida mensagem de produto não encontrado