@BasketPage
Feature: LoginPage Feature

    # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.
    # Farklı dinamik kullanımları olması açısından aşağıdaki dinamik verileri farklı kullandım.

  @Case-2-1
  Scenario Outline: End-to-End Product Search, Filter, and Add to Basket Flow
    Given Go to Url "https://www.trendyol.com/"
    Given User Logged In "<ePosta>" "<password>"
    When write to "<product>" SearchBox
    When taps to Search Button on the SearchBox
    Then should see Description Contains "<product>" on the Search Page
    When ensure the Filter "Marka" section is expanded on the Search Page
    When choose Filter "<brandFilterName>" on the Search Page
    Then should see Description Contains "<brandFilterName>" on the Search Page
    When ensure the Filter "Fiyat" section is expanded on the Search Page
    When write to Minimum Price "<minimumPrice>" Price Filter section on the Search Page
    When write to Maximum Price "<maximumPrice>" Price Filter section on the Search Page
    When taps to Search Button Price Filter on the Search Page
    Then should see Products Price within "<minimumPrice>" to "<maximumPrice>" on the Search Page
    When taps to Random Product on the Search Page
    Then should see Product Page
    When taps to Add To Basket Product on the Product Page
    Then should see Product Preview Status Text "Ürün Sepete Eklendi!"
    Examples:
      | ePosta                 | | password      | | product            | | brandFilterName | | minimumPrice | | maximumPrice |
      | denemepoc123@gmail.com | | berkaydeneme1 | | Oyuncu Bilgisayarı | | MONSTER         | | 3000         | | 10000        |

  @Case-2-2
  Scenario Outline: End-to-End Product Search, Add to Favorites and Check Favorites Flow
    Given Go to Url "https://www.trendyol.com/"
    Given User Logged In "<ePosta>" "<password>"
    When write to "<product>" SearchBox
    When taps to Search Button on the SearchBox
    Then should see Description Contains "<product>" on the Search Page
    When taps to Favorites Button Random Product on the Search Page
    When taps to Favorites Navigation
    Then correct product add to favorites on the Favorites Page
    Examples:
      | ePosta                 | | password      | | product            |
      | denemepoc123@gmail.com | | berkaydeneme1 | | Gömlek             |