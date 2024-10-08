public class Main {
    public static void main(String[] args) throws LimitException {
        BankAccount account = new BankAccount(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Попытка снять больше, чем остаток. Осталось: " + e.getRemainingAmount());
                account.withDraw(e.getRemainingAmount());
                System.out.println("Снято " + e.getRemainingAmount() + " сом. Остаток: " + account.getAmount());
                break; // Завершаем цикл
            }
        }
    }
}