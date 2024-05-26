@LoginPage
Feature: LoginPage Feature

    # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.

  @Case-1-1
  Scenario Outline: Successful Login
    Given Go to Url "https://www.trendyol.com/giris?cb=/"
    Then should see Login Form on the Login Page
    When taps to Cookies Accept
    When write to E-posta "<ePosta>" on the Login Page
    When write to Password "<password>" on the Login Page
    When taps to Login Button on the Login Page
    Then should see Home Page
    Then should see Logged In MemberShip on the Home Page
    Examples:
      | ePosta                 | | password     |
      | denemepoc123@gmail.com | | berkaydeneme1 |

  @Case-1-2
  Scenario Outline: Dynamic Negative Login Scenarios
    Given Go to Url "https://www.trendyol.com/giris?cb=/"
    Then should see Login Form on the Login Page
    When taps to Cookies Accept
    When write to E-posta "<ePosta>" on the Login Page
    When write to Password "<password>" on the Login Page
    When taps to Login Button on the Login Page
    Then should see an Error Message saying "<errorMessage>" on the Login Page
    Examples:
      | ePosta                 | | password      | | errorMessage                                   |
      |                        | |               | | Lütfen geçerli bir e-posta adresi giriniz.     |
      |                        | | berkaydeneme1 | | Lütfen geçerli bir e-posta adresi giriniz.     |
      | denemepoc123gmail.com  | | berkaydeneme1 | | Lütfen geçerli bir e-posta adresi giriniz.     |
      | denemepoc123@gmail.com | |               | | Lütfen şifrenizi giriniz.                      |
