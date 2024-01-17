Feature: Test ContactUs przy pomocy Cucumbera

  Background:
    Given Open prestashop and Switch to frame

  Scenario Outline: As a client open Contact Us and send filled form.
    When Open Contact Us
    And Fill form as "<email>" "<messagetext>"
    Then Check if form sent successfully

    Examples:
      | email              | messagetext            |
      | jakismail@mail.com | jakas wiadomosc testowa|
