-- risk HIGH
INSERT INTO credit_card (card_number, last_pay)
VALUES (9981, CURRENT_DATE() - 30);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9982, CURRENT_DATE() - 21);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9983, CURRENT_DATE() - 25);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9984, CURRENT_DATE() - 27);

-- risk LOW
INSERT INTO credit_card (card_number, last_pay)
VALUES (9993, CURRENT_DATE() - 20);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9994, CURRENT_DATE() - 11);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9995, CURRENT_DATE() - 15);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9996, CURRENT_DATE() - 17);

-- risk NORMAL
INSERT INTO credit_card (card_number, last_pay)
VALUES (9955, CURRENT_DATE() - 10);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9956, CURRENT_DATE() - 5);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9957, CURRENT_DATE() - 6);
INSERT INTO credit_card (card_number, last_pay)
VALUES (9958, CURRENT_DATE() - 8);