import java.util.Scanner;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    abstract double calculateExtraFee();

    abstract boolean usesBus();

    double calculateTotalFee() {
        double transportFee = usesBus() ? 12000 : 0;
        return calculateTuition() + calculateExtraFee() + transportFee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateExtraFee() {
        return 0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateExtraFee() {
        return 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    double calculateExtraFee() {
        return 0;
    }

    boolean usesBus() {
        return true;
    }
}

public class Sol16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    continue;
            }

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}