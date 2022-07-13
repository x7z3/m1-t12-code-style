import java.util.Scanner;

public class DepositCalculator {

    private static final double YEAR_RATE = 0.06;

    double calculateComplexPercent(double amount, int depositPeriod) {
        double income = amount * Math.pow((1 + YEAR_RATE / 12), 12 * depositPeriod);
        return roundNumber(income);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return roundNumber(amount + amount * YEAR_RATE * depositPeriod);
    }

    double roundNumber(double number) {
        double scale = Math.pow(10, 2);
        return Math.round(number * scale) / scale;
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();

        double income = 0;
        if (depositType == 1) {
            income = calculateSimplePercent(amount, period);
        } else if (depositType == 2) {
            income = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
