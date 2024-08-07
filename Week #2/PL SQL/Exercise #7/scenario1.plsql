-- Package Specification

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_customerId IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER);

    PROCEDURE UpdateCustomer(p_customerId IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER);

    FUNCTION GetCustomerBalance(p_customerId IN NUMBER) RETURN NUMBER;
END CustomerManagement;


-- Package Body 

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_customerId IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO Customers (customerId, name, balance)
        VALUES (p_customerId, p_name, p_balance);
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_customerId IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER) IS
    BEGIN
        UPDATE Customers
        SET name = p_name, balance = p_balance
        WHERE customer_id = p_customerId;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_customerId IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance
        FROM Customers
        WHERE customerId = p_customerId;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
