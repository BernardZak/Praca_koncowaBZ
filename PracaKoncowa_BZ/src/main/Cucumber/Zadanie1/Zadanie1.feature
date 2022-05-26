Feature: Adding new address to account (on MyStore)

  Scenario Outline: user can add new address
    Given user logged on store
    And choose option to change address
    When fills and submit New Address form: <alias>,<address>,<city>,<postalcode>,<country>,<phone>
    Then New Address is added: <alias>,<address>,<city>,<postalcode>,<country>,<phone>
    And quit site

   Examples:
    | alias |address | city | postalcode | country | phone |
    |Maras|ul.Kwietna 13|Londyn|22-334|United Kingdom|31235325324|



