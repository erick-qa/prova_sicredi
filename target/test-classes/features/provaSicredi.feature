#Author: Erick Santos
#language: pt

@Executa
Funcionalidade: Cadastrar novo cliente e depois exclui-lo
  Eu como usuario quero acessar o site para cadastrar novo cliente e depois exclui-lo

  Contexto: acessar o site
    Dado eu acesse o site "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme"

  @Executa
  Cenario: Cadastrar novo cliente
    Quando eu altero o select version
    E clico em add customer
    E preencho todos os dados do cliente
    E valido o cadastro do primeiro cenario
    Entao fecho navegador

  @Executa
  Cenario: Cadastrar novo funcionario
    Quando eu altero o select version
    E clico em add customer
    E preencho todos os dados do cliente
    E valido o cadastro do segundo cenario
    E clico em go back to list
    E pesquiso o nome do cliente cadastrado
    E deleto o cliente cadastrado
    E valido o a confirmacao da exclusao
    E confirmo a exclusao
    E valido a exclusao
    Entao fecho navegador