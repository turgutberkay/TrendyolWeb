@HomePage
Feature: LoginPage Feature

    # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.

  @Case-3
  Scenario: Verify Product Images Load Correctly for Each Tab
    Given Go to Url "https://www.trendyol.com/"
    When user clicks each tab one by one, clicks the first component, and logs whether the images of the first 4 products are received
