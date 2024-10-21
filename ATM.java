public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin){
        this.balance=balance;
        this.pin=pin;
    }

    public void displayMenu(){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }

    public void deposit(int amount){
        balance+=amount;
    }

    public void withdraw(int amount){
        if(balance<amount){
            System.out.println("Insufficient Funds!");
            return;
        }
        balance-=amount;
    }

    public int getBalance(){
        return balance;
    }

    public boolean validatePin(int pin){
        return this.pin==pin;
    }

    public void changePin(int newPin){
        pin=newPin;
        System.out.println("PIN changed!");
    }
    public static void main(String[] args) {
      ATM atm=new ATM(1000, 1234);
      System.out.println("Enter the PIN: ");
      int pin=Integer.parseInt(System.console().readLine());
      if(atm.validatePin(pin)){
        int option=0;
        while(option !=5){
            atm.displayMenu();
            option=Integer.parseInt(System.console().readLine());
            switch (option) {
                case 1:
                    System.out.println("Balance: "+atm.getBalance());
                    break;

                case 2:
                    System.out.println("Enter Amount: ");
                    int amount=Integer.parseInt(System.console().readLine());
                    atm.deposit(amount);
                    break;

                case 3:
                    System.out.println("Enter Amount: ");
                    amount=Integer.parseInt(System.console().readLine());
                    atm.withdraw(amount);
                    break;

                case 4:
                    System.out.println("Enter new PIN: ");
                    int newpin=Integer.parseInt(System.console().readLine());
                    atm.changePin(newpin);
                    break;

                case 5:
                    System.out.println("Thank You for using ATM!");
                    break;
                  
                default:

                    break;
            }
        }
      }
      else{
        System.out.println("You have entered Invalid PIN!");
      }

    }
}
