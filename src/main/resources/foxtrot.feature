Feature: buying products
  As a user
  I want to test foxtrot website functionality
  So that I can be sure that site works correctly

  Scenario Outline: check sum of products in cart after buying some product

    When User open 'https://www.foxtrot.com.ua/' page
    And User enter in search input word '<productType>'
    And User sort products from expensive to low price
    And User click on first product
    And User click on buy button
    Then User check that sum of products in cart equals '<expectedAmount>'

    Examples:
      | productType  | expectedAmount |
      | ноутбуки     | 221474         |
      | смартфони    | 54999          |
      | телевізори   | 999999         |
      | холодильники | 145599         |
      | навушники    | 28999          |