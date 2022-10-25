#language: pt
#encoding: utf-8
#Author: abdiel.boaz1@gmail.com

@BuscaClique
Funcionalidade: Ação de buscar um produto por clique

  Contexto:
    Dado que o usuario esteja na tela principal


  Esquema do Cenario: Buscar um produto existente por clique
    E clica no botao de menu
    E clica em uma categoria "<produto>"
    E clica no produto desejado "<produto>"
    Então valida produto encontrado com sucesso

    Exemplos:
      | produto    |
      | MICE       |
      | LAPTOPS    |
      | TABLETS    |
      | HEADPHONES |
      | SPEAKERS   |

  Cenário: Buscar um produto que não exista
    E clica no filtros
    E adiciona filtros para buscar um produto
    Então valida produto nao encontrado pelos filtro
