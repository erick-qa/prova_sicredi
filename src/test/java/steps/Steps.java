package steps;

import elementos.ElementosWeb;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import paginas.Metodos;


import java.io.IOException;

public class Steps {

    Metodos metodo = new Metodos();
    ElementosWeb el = new ElementosWeb();


    @Dado("eu acesse o site {string}")
    public void eu_acesse_o_site(String site) throws IOException {
        metodo.abrirNavegador(site, "Chrome", "abrir_navegador");

    }

    @Quando("eu altero o select version")
    public void eu_altero_o_select_version() throws IOException {
        metodo.selecionarComboPosicao(el.getSwitchVersion(), 1, "selecionar_switch_version");


    }

    @Quando("clico em add customer")
    public void clico_em_add_customer() throws IOException {
        metodo.clicar(el.getAdd(), "clicar_em_add");

    }

    @Quando("preencho todos os dados do cliente")
    public void preencho_todos_os_dados_do_cliente() throws IOException, InterruptedException {
        metodo.escrever(el.getName(), "Teste Sicredi", "inserir_nome");
        metodo.escrever(el.getLastName(), "Teste", "inserir_sobrenome");
        metodo.escrever(el.getFirstName(), "Erick", "inserir_first_name");
        metodo.escrever(el.getPhone(), "51 9999-9999", "inserir_phone");
        metodo.escrever(el.getAdressLine1(), "Av Assis Brasil, 3970", "inserir_endereco1");
        metodo.escrever(el.getAdressLine2(), "Torre D", "inserir_endereco2");
        metodo.escrever(el.getCity(), "Porto Alegre", "inserir_cidade");
        metodo.escrever(el.getState(), "RS", "inserir_estado");
        metodo.escrever(el.getPostalCode(), "91000-000", "inserir_cep");
        metodo.escrever(el.getCountry(), "Brasil", "inserir_país");
        metodo.teclaPageDw("teclar_page_down");
        metodo.pausa(1000, "esperar_um_segundo");
        metodo.clicar(el.getEmployeer(), "selecionar_employeer");
        metodo.esperarClicavel(el.getFixter(), "esperar_ser_clicavel");
        metodo.clicar(el.getFixter(), "selecionar_fixter");
        metodo.clicar(el.getButtonSave(), "clicar_em_save");

    }

    @Quando("valido o cadastro")
    public void valido_o_cadastro() throws IOException, InterruptedException {
        metodo.esperarClicavel(el.getCadastroPronto(),"esperar_elemento_ficar_visivel");
        metodo.validarTexto(el.getCadastroPronto(), "Your data has been successfully stored into the database. Edit Customer or Go back to list", "validar_confrimacao_de_cadastro");

    }

    @Entao("fecho navegador")
    public void fecho_navegador() throws IOException {
        metodo.fecharNavegador("fechar_navegador");

    }

    @Quando("clico em go back to list")
    public void clico_em_go_back_to_list() throws IOException {
        metodo.clicar(el.getGoBackToList(), "clicar_em_back_to_list");


    }

    @Quando("pesquiso o nome do cliente cadastrado")
    public void pesquiso_o_nome_do_cliente_cadastrado() throws IOException {
        metodo.esperarClicavel(el.getSearchName(),"esperar_elemento_ser_clicavel");
        metodo.clicar(el.getSearchName(), "clicar_em_pesquisar");
        metodo.escrever(el.getSearchName(), "Teste Sicredi", "pesquisar_cliente_cadastrado");


    }

    @Quando("deleto o cliente cadastrado")
    public void deleto_o_cliente_cadastrado() throws IOException {
        metodo.clicar(el.getAction(), "clicar_em_actions");
        metodo.clicar(el.getDelete(), "clicar_em_delete");

    }

    @Quando("valido o a confirmacao da exclusao")
    public void valido_o_a_confirmacao_da_exclusao() throws IOException, InterruptedException {
        metodo.esperarClicavel(el.getAreYouSure(),"esperar_elemento_ficar_visivel");
        metodo.validarTexto(el.getAreYouSure(), "Are you sure that you want to delete this 1 item?", "validar_exclusao");

    }

    @Quando("confirmo a exclusao")
    public void confirmo_a_exclusao() throws IOException {
        metodo.clicar(el.getDeletar(), "clicar_em_deletar");

    }

    @Quando("valido a exclusao")
    public void valido_a_exclusao() throws IOException {
        metodo.esperarClicavel(el.getConfirm(),"esperar_elemento_ficar_visivel");
        metodo.validarTexto(el.getConfirm(),"Your data has been successfully deleted from the database.","validar");

    }
}


