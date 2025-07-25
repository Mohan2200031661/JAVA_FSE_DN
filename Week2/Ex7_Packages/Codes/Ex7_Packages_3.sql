-- Scenario 3
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount (
        p_account_id   IN NUMBER,
        p_customer_id  IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance      IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened: ID ' || p_account_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;

    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Account not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account closed: ID ' || p_account_id);
        END IF;
    END;

    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN NVL(v_total, 0);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END;

END AccountOperations;
/

BEGIN
    AccountOperations.OpenAccount(100, 1, 'Savings', 5000);
END;
/

BEGIN
    AccountOperations.CloseAccount(100);
END;
/


DECLARE
    v_total NUMBER;
BEGIN
    v_total := AccountOperations.GetTotalBalance(1);
    DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 1: ₹' || v_total);
END;
/


