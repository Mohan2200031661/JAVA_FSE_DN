--Scenario 2
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_id        IN NUMBER,
        p_name      IN VARCHAR2,
        p_position  IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept      IN VARCHAR2,
        p_hire_date IN DATE
    );

    PROCEDURE UpdateEmployeeDetails (
        p_id   IN NUMBER,
        p_name IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary (
        p_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/



CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_id        IN NUMBER,
        p_name      IN VARCHAR2,
        p_position  IN VARCHAR2,
        p_salary    IN NUMBER,
        p_dept      IN VARCHAR2,
        p_hire_date IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_dept, p_hire_date);
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID already exists.');
    END;

    PROCEDURE UpdateEmployeeDetails (
        p_id   IN NUMBER,
        p_name IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name
        WHERE EmployeeID = p_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Employee not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Employee details updated.');
        END IF;
    END;

    FUNCTION CalculateAnnualSalary (
        p_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;

END EmployeeManagement;
/

--hire new employee
BEGIN
    EmployeeManagement.HireEmployee(
        10, 'Suresh Kumar', 'Analyst', 45000, 'Finance', TO_DATE('2022-06-01', 'YYYY-MM-DD')
    );
END;
/

--update Employee

BEGIN
    EmployeeManagement.UpdateEmployeeDetails(10, 'Suresh K.');
END;
/

--claculate Annual Salary
DECLARE
    v_annual NUMBER;
BEGIN
    v_annual := EmployeeManagement.CalculateAnnualSalary(10);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || v_annual);
END;
/


SELECT * FROM Employees;
