--Scenario 1
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
SELECT CustomerID, Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;


--Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount     IN NUMBER,
    p_interest_rate   IN NUMBER,
    p_years           IN NUMBER
) RETURN NUMBER
IS
    v_emi NUMBER;
    r     NUMBER := p_interest_rate / 12 / 100;
    n     NUMBER := p_years * 12;
BEGIN
    IF r = 0 THEN
        v_emi := p_loan_amount / n;
    ELSE
        v_emi := p_loan_amount * r * POWER(1 + r, n) / (POWER(1 + r, n) - 1);
    END IF;

    RETURN ROUND(v_emi, 2);
END;
/
SELECT LoanID, CustomerID,
       LoanAmount,
       InterestRate,
       ROUND(MONTHS_BETWEEN(EndDate, StartDate)/12) AS Years,
       CalculateMonthlyInstallment(LoanAmount, InterestRate, ROUND(MONTHS_BETWEEN(EndDate, StartDate)/12)) AS EMI
FROM Loans;

--scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(1, 500); 

    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/

SELECT * FRom ACCOUNTS;



