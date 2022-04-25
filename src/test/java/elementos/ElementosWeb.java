package elementos;

import org.openqa.selenium.By;

public class ElementosWeb {


    private By switchVersion = By.id("switch-version-select");
    private By add = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[1]/a");
    private By name = By.name("customerName");
    private By lastName = By.name("contactLastName");
    private By firstName = By.name("contactFirstName");
    private By phone = By.name("phone");
    private By adressLine1 = By.name("addressLine1");
    private By adressLine2 = By.name("addressLine2");
    private By city = By.name("city");
    private By state = By.name("state");
    private By postalCode = By.name("postalCode");
    private By country = By.name("country");
    private By employeer = By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/a/span");

    private By fixter = By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/div/ul/li[8]");
    private By creditLimit = By.name("creditLimit");
    private By buttonSave = By.id("form-button-save");
    private By cadastroPronto = By.id("report-success");
    private By save = By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p/a[2]");
    private By goBackToList = By.id("save-and-go-back-button");

    private By searchName = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[3]/input");
    private By action = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[1]/input");
    private By delete = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a");
    private By areYouSure = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]");
    private By deletar = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");

    private By confirm = By.xpath("/html/body/div[4]/span[3]");


    public By getConfirm() {
        return confirm;
    }

    public By getAreYouSure() {
        return areYouSure;
    }

    public By getDeletar() {
        return deletar;
    }


    public By getAction() {
        return action;
    }

    public By getDelete() {
        return delete;
    }

    public By getSearchName() {
        return searchName;
    }

    public By getSwitchVersion() {
        return switchVersion;
    }

    public By getAdd() {
        return add;
    }

    public By getName() {
        return name;
    }

    public By getLastName() {
        return lastName;
    }

    public By getFirstName() {
        return firstName;
    }

    public By getPhone() {
        return phone;
    }

    public By getAdressLine1() {
        return adressLine1;
    }

    public By getAdressLine2() {
        return adressLine2;
    }

    public By getCity() {
        return city;
    }

    public By getState() {
        return state;
    }

    public By getPostalCode() {
        return postalCode;
    }

    public By getCountry() {
        return country;
    }

    public By getEmployeer() {
        return employeer;
    }

    public By getFixter() {
        return fixter;
    }

    public By getCreditLimit() {
        return creditLimit;
    }

    public By getButtonSave() {
        return buttonSave;
    }

    public By getCadastroPronto() {
        return cadastroPronto;
    }

    public By getSave() {
        return save;
    }

    public By getGoBackToList() {
        return goBackToList;
    }

    {


    }
}