-- Package Specification

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_employeeId IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER);

    PROCEDURE UpdateEmployee(p_employeeId IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER);

    FUNCTION CalculateAnnualSalary(p_employeeId IN NUMBER) RETURN NUMBER;
END EmployeeManagement;


-- Package Body

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_employeeId IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        INSERT INTO Employees (employeeId, name, salary)
        VALUES (p_employeeId, p_name, p_salary);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID already exists.');
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_employeeId IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET name = p_name, salary = p_salary
        WHERE employeeId = p_employeeId;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error occurred.');
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_employeeId IN NUMBER) RETURN NUMBER IS
        v_salary Employees.salary%TYPE;
    BEGIN
        SELECT salary INTO v_salary
        FROM Employees
        WHERE employeeId = p_employeeId;
        
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;


