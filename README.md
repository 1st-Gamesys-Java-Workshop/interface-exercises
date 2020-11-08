# Evolving Interfaces Exercises

## 1. Breach of Contract
Modify the _reimburse()_ method of Reimbursement interface such that:

```java
public interface ReimbursementService {

    void reimburse(
        String itemName,
        BigDecimal amount,
        String receiptUrl,
        String bank,
        String accountNumber);

}
``` 
Notice what will happen to ReimbursementServiceImpl, ReimbursementCliClient and ReimbursementTcpHandler

## 2. Evolving Interfaces by Extending an Interface

a. On the reimbursement-service project on the previous exercise, modify _Reimbursement_ class so that it will include bank and account number

b. Extend the _ReimbursementService_ interface into a new interface _ReimbursementWithBankService_ with a new method:

```java
void reimburseWithBank(
    String itemName,
    BigDecimal amount, 
    String receiptUrl,
    String bank,
    String accountNumber);
```
c. Implement _ReimbursementWithBankService_ in _ReimbursementServiceImpl_ class

d. Implement _ReimbursementWithBankService_ in _ReimbursementServiceImpl_ class

## 3. Evolving Interfaces Using Default Methods

a. Add the following default method in _ReimbursementService_ interface:

```java
default void reimburseWithBank(
    String itemName,
    BigDecimal amount, 
    String receiptUrl,
    String bank,
    String accountNumber);
``` 

b. Implement the new method in _reimburseWithBank(…)_ in _ReimbursementServiceImpl_.

c. Implement the new method in _reimburseWithBank(…)_ in _ReimbursementServiceImpl_.

## 4. Static Methods

Find the usages of the static methods in the following class in the project from the previous exercise.
Then, find-out which interface they seem to belong.
And, refactor the project so that the methods are in their proper places.

```java
public class InputUtils {

    public static boolean isValid(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isAnAmount(String value) {
        return value.matches("[0-9]+");
    }

}
```
