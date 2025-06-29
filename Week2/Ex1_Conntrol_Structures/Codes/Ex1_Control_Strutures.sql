-- Scenario 1
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        IF MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;


--ScenRIO 2 

ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

BEGIN
    FOR cust_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = cust_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;

SELECT * FROM CUSTOMERS;

--scenario 3

BEGIN
    FOR loan_rec IN (
        SELECT L.LoanID, C.Name, L.EndDate
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || loan_rec.Name ||
            ', your loan (Loan ID: ' || loan_rec.LoanID ||
            ') is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY') ||
            '. Please ensure timely payment.'
        );
    END LOOP;
END;
SELECT * FROM LOANS;




