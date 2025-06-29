--Scenario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (acc.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest added for Account ID: ' || acc.AccountID);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

--- Scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    FOR emp IN (
        SELECT EmployeeID, Salary FROM Employees WHERE Department = p_dept
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (emp.Salary * p_bonus_percent / 100)
        WHERE EmployeeID = emp.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp.EmployeeID);
    END LOOP;

    COMMIT;
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/


--- Scenario 3


CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amt IN NUMBER
) IS
    v_bal NUMBER;
BEGIN
    -- Check balance
    SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_from_acc;

    IF v_bal < p_amt THEN
        RAISE_APPLICATION_ERROR(-20010, 'Insufficient funds in source account.');
    END IF;

    -- Debit and Credit
    UPDATE Accounts SET Balance = Balance - p_amt WHERE AccountID = p_from_acc;
    UPDATE Accounts SET Balance = Balance + p_amt WHERE AccountID = p_to_acc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amt || ' from ' || p_from_acc || ' to ' || p_to_acc);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(2, 3, 500);
END;
/


