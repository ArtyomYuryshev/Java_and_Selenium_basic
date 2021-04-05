package course1.bank;

import java.util.Scanner;

import static course1.bank.ClientType.ENTITY;
import static course1.bank.ClientType.INDIVIDUAL;

public class Bank {

    private String name;
    private boolean type;
    private int creditBalance = 0;
    private String output;
    private Client client;
    private Bank.clientHistoryCatalog historyCatalog = new  clientHistoryCatalog();

    public Bank() {
        this.client = new Client();
    }

    public clientHistoryCatalog getHistoryCatalog() {
        return historyCatalog;
    }

    //меню банка
    public String run() {
        System.out.println("\nЛичный кабинет Банк Пинькофф \nхотите взять выгодный кредит на 40 лет "
                + "под 100500% годовых с ежемесечным начислением процентов под залог почки? \n get - взять кредит"
                + "\n print -  показать информацию о пользователе \n end - выйти из личного кабинета");
        Scanner scMenu = new Scanner(System.in);
        return scMenu.next();
    }

    //создание клиента
    public void createUser() {
        System.out.println("\nЗарегистрируйтесь в системе");
        this.name = client.createUserName();
        this.type = client.createUserType();
        if (this.type) {
            //this.creditBalance = ENTITY.getCreditScore();
            this.output = "Пользователь: " + this.name + "\nТип кредитного рейтинга: " + ENTITY.toString().toLowerCase();
            System.out.println(this.output);
        } else {
            //this.creditBalance = INDIVIDUAL.getCreditScore();
            this.output = "Пользователь: " + this.name + "\nТип кредитного рейтинга: " + INDIVIDUAL.toString().toLowerCase();
            System.out.println(this.output);
        }
    }

    public class clientHistoryCatalog {

        //выдать кредит
        public void getCredit() {
            if (type) {
                if (101 - (creditBalance + ENTITY.getCreditScore()) > 0) {
                    creditBalance = creditBalance + ENTITY.getCreditScore();
                    System.out.println("\nЗаявка на новый кредит принята. "
                            + "Наш специалист свяжется с вами, в ближайшее время");
                    System.out.println("Кредитный баланс обновлён. Текущее значение: " + creditBalance);
                } else {
                    System.out.println("\nКредитный лимит достигнут");
                }
            } else {
                if (101 - (creditBalance + INDIVIDUAL.getCreditScore()) > 0) {
                    creditBalance = creditBalance + INDIVIDUAL.getCreditScore();
                    System.out.println("\nЗаявка на новый кредит принята. "
                            + "Наш специалист свяжется с вами, в ближайшее время");
                    System.out.println("Кредитный баланс обновлён. Текущее значение: " + creditBalance);
                } else {
                    System.out.println("\nКредитный лимит достигнут");
                }
            }
        }
    }

    //вывод инфы о клиенте
    public String print() {
        return String.format("%1$s \nКредитный рейтинг: %2$d", output, this.creditBalance);
    }

    //завершение приложения
    public Boolean end() {
        boolean loop;
        Scanner scEnd = new Scanner(System.in);
        System.out.println("\nВы уверены, что нехотите взять нашу кредитную карту?"
                + "\nДля вас действует специальное предложение! \nПри оформлении нашей кредитной карты, "
                + "полное строхование внутренних органов "
                + "со скидкой в 0,03% (не является публичной офертой)"
                + "\nВведите y - да, хочу; n - спасибо.");
        String end = scEnd.next();
        if (end.contentEquals("y")) {
            loop = true;
        } else {
            System.out.println("\nВаша заявка на кредитную карту принята. "
                    + "Наш специалист свяжется с вами в ближайшее время. \nПартнёрский материал: "
                    + "\nСтавки на спорт — 1XBET!"
                    + "\nБольшие выигрыши — 1XBET!"
                    + "\nБыстрые выплаты — 1XBET!"
                    + "\nНадежный букмекер — 1XBET!"
                    + "\nО-ДИН-ИКС-БЕТ!!!");
            loop = false;
        }
        return loop;
    }

}