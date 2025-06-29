--Scenario 1
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer (
        p_id      IN NUMBER,
        p_name    IN VARCHAR2,
        p_dob     IN DATE,
        p_balance IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails (
        p_id   IN NUMBER,
        p_name IN VARCHAR2
    );

    FUNCTION GetCustomerBalance (
        p_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddNewCustomer (
        p_id      IN NUMBER,
        p_name    IN VARCHAR2,
        p_dob     IN DATE,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
    END;

    PROCEDURE UpdateCustomerDetails (
        p_id   IN NUMBER,
        p_name IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, LastModified = SYSDATE
        WHERE CustomerID = p_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Customer not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer updated.');
        END IF;
    END;

    FUNCTION GetCustomerBalance (
        p_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;

END CustomerManagement;
/


--test add new customers
BEGIN
    CustomerManagement.AddNewCustomer(50, 'Mohan Raj', TO_DATE('1996-01-01', 'YYYY-MM-DD'), 5000);
END;
/

--test update customer
BEGIN
    CustomerManagement.UpdateCustomerDetails(50, 'Mohan Raj Kumar');
END;
/

--test get balance
DECLARE
    v_bal NUMBER;
BEGIN
    v_bal := CustomerManagement.GetCustomerBalance(50);
    DBMS_OUTPUT.PUT_LINE('Balance: ₹' || v_bal);
END;
/


SELECT * FRom CUSTOMERS;


