package exeption.lesson2;

// собственный класс исключений
class MyException extends Exception {

    public MyException(String message) {
        super(message);
        System.out.println("можно записать в лог БД, для анализа ошибок в дальнейшем");
    }
}