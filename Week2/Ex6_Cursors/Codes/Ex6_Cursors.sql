-- Scenario 1

DECLARE
    CURSOR txn_cur IS
        SELECT 
            T.TransactionID, 
            T.AccountID,
            C.CustomerID,
            CU.Name,
            T.TransactionDate,
            T.Amount,
            T.TransactionType
        FROM Transactions T
        JOIN Accounts C ON T.AccountID = C.AccountID
        JOIN Customers CU ON C.CustomerID = CU.CustomerID
        WHERE TO_CHAR(T.TransactionDate, 'YYYY-MM') = TO_CHAR(SYSDATE, 'YYYY-MM')
        ORDER BY CU.CustomerID;

    v_txn txn_cur%ROWTYPE;
BEGIN
    OPEN txn_cur;

    LOOP
        FETCH txn_cur INTO v_txn;
        EXIT WHEN txn_cur%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_txn.Name ||
            ' | Account: ' || v_txn.AccountID ||
            ' | Date: ' || TO_CHAR(v_txn.TransactionDate, 'DD-MON-YYYY') ||
            ' | Type: ' || v_txn.TransactionType ||
            ' | Amount: ' || v_txn.Amount
        );
    END LOOP;

    CLOSE txn_cur;
END;
/

SET SERVEROUTPUT ON;


-- Scenario 2

DECLARE
    CURSOR acc_cur IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_acc acc_cur%ROWTYPE;
    v_fee CONSTANT NUMBER := 500;
BEGIN
    OPEN acc_cur;

    LOOP
        FETCH acc_cur INTO v_acc;
        EXIT WHEN acc_cur%NOTFOUND;

        IF v_acc.Balance >= v_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_fee,
                LastModified = SYSDATE
            WHERE AccountID = v_acc.AccountID;

            DBMS_OUTPUT.PUT_LINE('₹' || v_fee || ' fee deducted from Account ID: ' || v_acc.AccountID);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Skipped Account ID: ' || v_acc.AccountID || ' (Insufficient balance)');
        END IF;
    END LOOP;

    CLOSE acc_cur;

    COMMIT;
END;
/


-- Scenario 3

DECLARE
    CURSOR loan_cur IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

    v_loan loan_cur%ROWTYPE;
BEGIN
    OPEN loan_cur;

    LOOP
        FETCH loan_cur INTO v_loan;
        EXIT WHEN loan_cur%NOTFOUND;

        IF v_loan.LoanAmount > 10000 THEN
            UPDATE Loans
            SET InterestRate = InterestRate + 0.5
            WHERE LoanID = v_loan.LoanID;

            DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan.LoanID || 
                                 ' updated: +0.5% (High amount)');
        ELSE
            UPDATE Loans
            SET InterestRate = InterestRate - 0.25
            WHERE LoanID = v_loan.LoanID;

            DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan.LoanID || 
                                 ' updated: -0.25% (Low amount)');
        END IF;
    END LOOP;

    CLOSE loan_cur;

    COMMIT;
END;
/
