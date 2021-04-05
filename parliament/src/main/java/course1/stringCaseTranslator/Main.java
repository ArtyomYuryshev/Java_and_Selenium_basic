//        2) Напишите класс (StringCaseTranslator), который будет переводить текст в тот или иной case.
//        у него должны быть статические методы, которые переводят строки в SCREAMING_SNAKE_CASE, PascalCase
//        и camelCase. Можете добавить и другие ( по желанию*).
//        Выглядеть методы должны примерно так "public static String toScreamSnakeCase(String text) {...}"

package course1.stringCaseTranslator;

public class Main {
    public static void main(String[] args) {
        stringCaseTranslator caseTranslator = new stringCaseTranslator();
        caseTranslator.howToPrint();

    }

    static class stringCaseTranslator {

        public void howToPrint() {
            String str1 = "лоЛ кЕк Чебурек";
            System.out.println("Вывод в SCREAMING_SNAKE_CASE:");
            System.out.println(toScreamSnakeCase(str1) + "\n");
            System.out.println("Вывод в PascalCase:");
            System.out.println(pascalCase(str1) + "\n");
            System.out.println("Вывод в camelCase:");
            System.out.println(camelCase(str1) + "\n");
        }


        public static String toScreamSnakeCase(String str1) {
            String str2 = str1.replace(" ", "_");
            return String.valueOf(str2).toUpperCase();

        }

        public static String pascalCase(String str1) {
            String str2 = str1.toLowerCase();
            String[] arr = str2.split(" ");
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)))
                        .append(arr[i].substring(1)).append(" ");
            }
            String str3 = sb.toString().trim();
            String str4 = str3.replace(" ", "");
            return str4;
        }

        public static String camelCase(String str1) {
            String str2 = str1.toLowerCase();
            String[] arr = str2.split(" ");
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)))
                        .append(arr[i].substring(1)).append(" ");
            }
            String str3 = sb.toString().trim();
            String str4 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
            String str5 = str4.replace(" ", "");
            return str5;
        }

    }

}