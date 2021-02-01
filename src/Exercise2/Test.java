package Exercise2;

public class Test {
    public static void main(String[] args) {
        PhoneBook book1 = new PhoneBook();
        book1.add("Иванов Иван", "950000000");
        book1.add("Петров Семен","920000000");
        book1.add("Иванов Иван","9020000000");
        book1.get("Иванов Иван");
        book1.get("Петров Семен");
        book1.get("Пупкин Вася");
    }
}
