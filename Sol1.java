import java.util.*;

interface Payment {
    double calculateFinalAmount(double amount);
}

class CardPayment implements Payment {
    public double calculateFinalAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements Payment {
    public double calculateFinalAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    public double calculateFinalAmount(double amount) {
        return amount;
    }
}

class Sol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                default:
                    payment = new BankTransfer();
            }

            double result = payment.calculateFinalAmount(amount);
            total += result;

            System.out.printf("%s: %.2f%n", type, result);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}