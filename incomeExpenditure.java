import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

public class IncomeAndExpenditureCalculator {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Income", 1000));
        transactions.add(new Transaction("Expenditure", 500));
        transactions.add(new Transaction("Expenditure", 300));
        transactions.add(new Transaction("Income", 2000));
        transactions.add(new Transaction("Expenditure", 800));

        double totalIncome = transactions.stream()
                .filter(transaction -> transaction.getType().equals("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpenditure = transactions.stream()
                .filter(transaction -> transaction.getType().equals("Expenditure"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenditure: " + totalExpenditure);
    }
}

