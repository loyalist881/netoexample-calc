public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        // Причина ошибки:
        // b == 0, значит следующая операция деления a / b приведёт к ArithmeticException (деление на ноль).
        // Ошибка заключается в отсутствии проверки делителя (b) перед делением.

        try {
            // Способ решения №1: заранее проверять делитель
            if (b == 0) {
                System.err.println("Ошибка деления на ноль. Делитель b = " + b);
                return;
            }

            int c = calc.devide.apply(a, b);
            calc.println.accept(c);


        } catch (ArithmeticException e) {
            // Способ решения №2: обработка исключения, если оно всё же возникло
            System.err.println("Арифметическая ошибка: " + e.getMessage());
        }
    }
}