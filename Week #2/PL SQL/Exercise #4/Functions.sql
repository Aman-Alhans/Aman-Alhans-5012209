-- Scenario 1

CREATE OR REPLACE FUNCTION CalculateAge (
    p_dateOfBirth DATE
) RETURN NUMBER IS
BEGIN

    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_dateOfBirth) / 12);

END CalculateAge;

-- Scenario 2

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loanAmount IN NUMBER,
    p_annualInterestRate IN NUMBER,
    p_loanDurationYears IN NUMBER
) RETURN NUMBER IS
    v_monthlyInterestRate NUMBER;
    v_numberOfMonths NUMBER;
BEGIN

    v_monthlyInterestRate := p_annualInterestRate / 12 / 100;
    
    v_numberOfMonths := p_loanDurationYears * 12;

    RETURN (p_loanAmount * v_monthlyInterestRate) / 
           (1 - POWER(1 + v_monthlyInterestRate, -v_numberOfMonths));
END CalculateMonthlyInstallment;

-- Scenario 3

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_accountId IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    
    SELECT balance INTO v_balance
    FROM accounts
    WHERE accountId = p_accountId;

    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
        
END HasSufficientBalance;