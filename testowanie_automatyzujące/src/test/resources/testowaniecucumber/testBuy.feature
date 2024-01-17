Feature: Test Buy przy pomocy Cucumbera

  Background:
    Given Open prestashop and Switch to frame

  Scenario Outline: As a client log into existing account and buy one product.
    When Create new account as "<name>" "<surname>" "<password>" "<mail>"
    And Sign out
    And Sign in as "<mail>" "<password>"
    And Add product to cart by "<productname>"
    And Go to cart
    And Buy
    And Fill address as "<address>" "<city>" "<zipcode>"
    And Fill delivery
    And Fill payment
    Then Check if order is completed
    Then Sign out

    Examples:
      | productname                 | name | surname | password     | mail               | address   | city        | zipcode |
      | Hummingbird printed t-shirt | John | Doe     | Nawetniewiem | mail@mail.com      | kraj      | miasto      | 55555   |
      | Mug Today is                | Jane | Doe     | Nawetniewiem | jakismail@mail.com | inny kraj | inne miasto | 44444   |
