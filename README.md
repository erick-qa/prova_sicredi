# Automação Web Java

### Requisitos 
* Java 8 
* Maven
* IDE de sua preferência, foi utilizado IntelliJ neste teste

### Como executar o teste
* Com Java 8 e Maven instalados e configurados nas variáveis de ambiente, execute o seguinte comando:
```bash
mvn clean install
```
* Na IDE pode ser executado através da classe "ExecutarIT" dentro da package "executa"

### Ferramentas Utilizadas
|Ferramentas|
|-----------|
|TestNG|
|Cucumber|
|Selenium|
|Ashot|
|ChromeDriver|
|GeckoDriver|

### Como a aplicação funciona
* É utilizado Cucumber dentro da pasta "features" dentro de "resources" onde estão todas as escritas em BDD e Gherkin;
* Todos os elementos inspecionados do site ficam na classe "ElementosWeb" dentro da package "elementos";
* A classe "ExecutarIT" dentro da package "executa" tem a função de executar todos os testes atrvés do TestNG;
* A classe "Metodos" dentro da package "paginas" é onde contém a programação do projeto de teste;
* A classe "Steps" dentro da package "steps" é onde contém toda a escrita do teste;
* Ao final do teste é gerado uma pasta chamada "report" dentro da raíz do projeto, e dentro dela contém um arquivo chamado "prova_sicredi.html" onde contém todos os passos do teste, quais cenários foram aprovados, quanto tempo durou o teste;
* E por final é gerado uma pasta chamada "evidencias" dentro da raíz do projeto, com todas as evidências organizadas por pastas e sequenciadas de acordo como o teste foi executado. 
 
