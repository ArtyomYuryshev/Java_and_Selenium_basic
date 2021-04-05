//        1) Создайте следующую структуру:
//
//        Банк - клиент. Клиент может быть 2х типов юр.лицо и физ.лицо (enum).
//
//        Банк может выдавать клиенту кредит.
//        Выдавать или нет он решает по заложенному внутри механизму под названием ClientHistoryCatalog
//        (inner class): шанс получить новый уменьшается на 25 %(15 % для юр лица)
//        за каждый активный кредит для просящего клиента.
//        (у вас должно получится 3 класса ( Client, Bank и Runner) и тип клиента (enum);

package course1.bank;

public class Runner {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.createUser();
        boolean loop = true;
        while (loop) {
            switch (bank.run()) {
                case "get": //взять кредит
                    bank.getHistoryCatalog().getCredit();
                    break;
                case "print": //вывод инф о клиенте
                    System.out.println("\n" + bank.print());
                    loop = true;
                    break;
                case "end": //завершение программы
                    loop = bank.end();
                    break;
                default: //сообщение при неверной команде
                    System.out.println("\nНеверная комманда. Попробуйте ещё раз.");
            }
        }
    }
}