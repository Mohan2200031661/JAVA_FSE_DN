--Scenario 1
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

UPDATE Customers
SET Balance = Balance + 1000
WHERE CustomerID = 1;

/

SELECT CustomerID, LastModified FROM Customers WHERE CustomerID = 1;

--Scenario 2


CREATE TABLE AuditLog (
    LogID            NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID    NUMBER,
    AccountID        NUMBER,
    TransactionDate  DATE,
    Amount           NUMBER,
    TransactionType  VARCHAR2(10)
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID, AccountID, TransactionDate, Amount, TransactionType
    )
    VALUES (
        :NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType
    );
END;
/
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (100, 1, SYSDATE, 500, 'Deposit');

SELECT * FROM AuditLog WHERE TransactionID = 100;


--Scenario 3

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds account balance.');
    END IF;

    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (301, 1, SYSDATE, 1000, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (302, 1, SYSDATE, 100000, 'Withdrawal');

SELECT * From TRANSACTIONS;


