@yolcu360
Feature: Siteye giris

  Background:
    Given yolcu360 sitesine gidilir
    And login butonuna tiklanir

  @negativelogin
  Scenario: Hatali Numara
    And telefon numarasi "<no>" girilir
    And devam et tiklanir
    And aydinlatma metni, acik riza metni, üyelik sözlesmesi checkbox tiklanir
    And devam et butonuna tekrar tiklanir
    Then gecersiz telefon numarasi hatasi alir

  @pozitivelogin
  Scenario: Dogru Numara
    And telefon numarasi girilir
    And gecerli numara ile devam et tiklanir
    And gecerli numara ile aydinlatma metni, acik riza metni, üyelik sözlesmesi checkbox tiklanir
    And gecerli numara ile devam et butonuna tekrar tiklanir
    Then sms dogrulama kodu alir



