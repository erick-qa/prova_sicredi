package paginas;


import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Metodos {

    WebDriver driver;

    /**
     * Abrir navegador e site
     *
     * @author Erick Santos
     *
     */
    public void abrirNavegador(String site, String navegador, String descricaoPasso) throws IOException {

        try {
            if (navegador == "Chrome" || navegador == "Firefox") {
                if (navegador == "Chrome") {
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(false);
                    driver = new ChromeDriver(options);
                    driver.get(site);
                    driver.manage().window().maximize();
                } else if (navegador == "Firefox") {
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                    File pathBinary = new File("./mozilla/firefox.exe");
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("browser.cache.disk.enable", false);
                    profile.setPreference("browser.cache.memory.enable", false);
                    profile.setPreference("browser.cache.offline.enable", false);
                    profile.setPreference("network.http.use-cache", false);
                    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                    DesiredCapabilities desired = new DesiredCapabilities();
                    FirefoxOptions options = new FirefoxOptions();
                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                    options.setHeadless(true);
                    driver = new FirefoxDriver(options);
                    driver.get(site);
                    driver.manage().window().maximize();
                }
            } else {
                System.out.println("Opcao invalida escolha Chrome ou Firefox");
            }
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-- " + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-- " + descricaoPasso);
        }
    }

    /**
     * Escrever
     *
     * @author Erick Santos
     *
     */
    public void escrever(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).sendKeys(texto);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Clicar
     *
     * @author Erick Santos
     *
     */
    public void clicar(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).click();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Submit
     *
     * @author Erick Santos
     *
     */
    public void submit(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).submit();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Print Screen Cadastro Usuario
     *
     * @author Erick Santos
     *
     */
    public void printScreenCadastrUser(String nomePrint) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./evidencias/cadastro_user/"+nomePrint+".png"));
    }

    /**
     * Print Screen Cadastro Funcionario
     *
     * @author Erick Santos
     *
     */
    public void printScreenCadastroFuncionario(String nomePrint) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./evidencias/cadastro_funcionario/"+nomePrint+".png"));
    }


    /**
     * Print Screen de Erros
     *
     * @author Erick Santos
     *
     */
    public void printScreenErros(String descricaoPasso) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./evidencias/erros/"+descricaoPasso+".png"));
    }

    /**
     * Fechar Navegador
     *
     * @author Erick Santos
     *
     */
    public void fecharNavegador(String descricaoPasso) throws IOException {
        try {
            driver.quit();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Super Click
     *
     * @author Erick Santos
     *
     */
    public void superClick(By elemento, String descricaoPasso) throws IOException {
        try {
            superClick((By) driver.findElement(elemento), descricaoPasso);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Duplo Click
     *
     * @author Erick Santos
     *
     */
    public void duploCliqueNoElemento(By elemento, String descricaoPasso) throws IOException {
        long TIMEOUT = 60;
        Actions action = new Actions(driver);
        try {
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
            action.doubleClick(
                    new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(elemento)));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Selecionar Combo na Posicao
     *
     * @author Erick Santos
     *
     */
    public void selecionarComboPosicao(By elemento, int posicao, String descricaoPasso) throws IOException {
        try {
            WebElement webElement = driver.findElement(elemento);
            Select combo = new Select(webElement);
            combo.selectByIndex(posicao);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Selecionar Combo no Texto
     *
     * @author Erick Santos
     *
     */
    public void selecionarComboTexto(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            WebElement webElement = driver.findElement(elemento);
            Select combo = new Select(webElement);
            combo.selectByVisibleText(texto);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Esperar ser clicavel
     *
     * @author Erick Santos
     *
     */
    public void esperarClicavel(By elemento, String descricaoPasso) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Validar Pagina
     *
     * @author Erick Santos
     *
     */
    public void validarPagina(String pagina, String descricaoPasso) throws IOException {
        try {
            String pag = driver.getTitle();
            assertEquals(pagina, pag);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Validar Texto
     *
     * @author Erick Santos
     *
     */
    public void validarTexto(By elemento, String texto, String descricaoPasso) throws IOException {
        try {
            String msg = driver.findElement(elemento).getText();
            assertEquals(texto, msg);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Pausa
     *
     * @author Erick Santos
     *
     */
    public void pausa(int tempo, String descricaoPasso) throws InterruptedException, IOException {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Esperar Alert na Tela
     *
     * @author Erick Santos
     *
     */
    public void esperarAlert(int tempo, String descricaoPasso) throws IOException {
        try {
            new WebDriverWait(driver, tempo).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    public void switcPage() {
        driver.switchTo().alert().accept();
    }

    /**
     * Passar o Mouse no Elemento Sem Clicar
     *
     * @author Erick Santos
     *
     */
    public void passarMouse(By elemento, String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            WebElement passarMouse = driver.findElement(elemento);
            action.moveToElement(passarMouse).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Pressionar tecla Enter
     *
     * @author Erick Santos
     *
     */
    public void teclaEnter(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * Clicar e segurar, mover e soltar com mouse
     *
     * @author Erick Santos
     *
     */
    public void moverElemento(By elementoOrigem, By elementoDestino, String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            WebElement origem = driver.findElement(elementoOrigem);
            WebElement destino = driver.findElement(elementoDestino);
            action.dragAndDrop(origem, destino).build().perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaPageUp
     *
     * @author Erick Santos
     *
     */
    public void teclaPageUp(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_UP).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaPageDw
     *
     * @author Erick Santos
     *
     */
    public void teclaPageDw(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * botaoVoltar
     *
     * @author Erick Santos
     *
     */
    public void botaoVoltar(String descricaoPasso) throws IOException {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * botaoAtualizar
     *
     * @author Erick Santos
     *
     */
    public void botaoAtualizar(String descricaoPasso) throws IOException {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * teclaBackSpace
     *
     * @author Erick Santos
     *
     */
    public void teclaBackSpace(String descricaoPasso) throws IOException {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.BACK_SPACE).perform();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * limparTexto
     *
     * @author Erick Santos
     *
     */
    public void limparTexto(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).clear();
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

    /**
     * limparTextoAlternativo
     *
     * @author Erick Santos
     *
     */
    public void limparTextoAlternativo(By elemento, String descricaoPasso) throws IOException {
        try {
            driver.findElement(elemento).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        } catch (Exception e) {
            printScreenErros("Erro_ao_tentar-" + descricaoPasso);
            Assert.fail(LocalDateTime.now() + "Erro_ao_tentar-" + descricaoPasso);
        }
    }

}

