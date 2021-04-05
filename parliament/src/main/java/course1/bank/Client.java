package course1.bank;

import java.util.Scanner;

public class Client {

    private boolean userType; // тип false - физ лицо; тип true - юр лицо.
    private String userName;

    //ввод имени
    public String createUserName() {
        System.out.println("\nВведите имя:");
        Scanner scUserName = new Scanner(System.in);
        userName = scUserName.next();
        return userName;
    }

    //ввод тип юзера
    public boolean createUserType() {
        System.out.println("\nЮр. лицо? (true/false):");
        Scanner scUserType = new Scanner(System.in);
        userType = Boolean.parseBoolean(scUserType.next());
        return userType;
    }


}