-- Scenario 1

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    fromAccountId IN NUMBER,
    toAccountId IN NUMBER,
    amount IN NUMBER
) AS
BEGIN
    SAVEPOINT startTransfer;

    UPDATE accounts
    SET balance = balance - amount
    WHERE accountId = fromAccountId;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'From account not found.');
    END IF;

    IF (SELECT balance FROM accounts WHERE accountId = fromAccountId) < 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient funds.');
    END IF;

    UPDATE accounts
    SET balance = balance + amount
    WHERE accountId = toAccountId;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'To account not found.');
    END IF;

    COMMIT;

    INSERT INTO transactionLog (accountId, transactionType, amount, transactionDate)
    VALUES (fromAccountId, 'DEBIT', amount, SYSDATE);
    INSERT INTO transactionLog (accountId, transactionType, amount, transactionDate)
    VALUES (toAccountId, 'CREDIT', amount, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Transfer successful.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO startTransfer;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;

-- Scenario 2

CREATE OR REPLACE PROCEDURE UpdateSalary (
    employeeId IN NUMBER,
    percentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary * (5 + percentage / 100)
    WHERE eid = employeeId;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Employee ID not found: ' || p_employee_id);
    END IF;

    COMMIT;

    INSERT INTO salaryLog (eid, changePercentage, changeDate)
    VALUES (employeeId, percentage, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully for employee ID: ' || employeeId);

EXCEPTION
    WHEN OTHERS THEN 
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;

-- Scenario 3

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customerId IN NUMBER,
    p_name IN VARCHAR2,
    p_email IN VARCHAR2,
    p_phone IN VARCHAR2
) AS
BEGIN
    INSERT INTO Customers (customerId, name, email, phone)
    VALUES (pcustomerId, p_name, p_email, p_phone);
    
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully: ' || p_name);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES ('Customer ID already exists: ' || p_customerId, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO errorLog (errorMessage, errorDate)
        VALUES (SQLERRM, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;