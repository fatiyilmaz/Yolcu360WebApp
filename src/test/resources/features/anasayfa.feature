@anasayfa
Feature: Anasayfa fonksiyonlari

  Background:
    Given yolcu360 sitesine gidilir

  @dil
  Scenario: Dil degisikligi
    And ulke simgesine tiklanir
    And farkli ulkeler gorur
    And farkli bir ulke dili secer
    Then dil degisikligi dogrulanir


  @arac
  Scenario: Arac kiralama
    And arac alınacak yer "<aracyeri>" yazilir
    And alis tarihi girilir
    And alis saati girilir
    And birakis tarihi girilir
    And birakis saati girilir
    And arac ara butonuna tiklanir
    Then arac listesi dogrulanir


  @tumtedarikciler
  Scenario: Tum tedarikciler
    And tum tedarikciler butonu tiklanir
    And tum tedarikciler sayfasina gecis dogrulanir
    Then alfabeye gore sirketler gorulur ve dogrulanir


    @footer
    Scenario: Footer
      And arac kiralama gorur
      And arac kiralama alt kisimlarina tiklar ve gecis dogrulanir
      And populer lokasyonlar gorur
      And populer lokasyonlar alt kisimlarina tiklar ve gecis dogrulanir
      And populer arac kiralama sirketleri gorur
      And populer arac kiralama sirketleri alt kisimlarina tiklar ve gecis dogrulanir
      And ucak bileti gorur
      And ucak bileti alt kisimlarina tiklar ve gecis dogrulanir
      And kurumsal & destek gorur
      And kurumsal & destek alt kisimlarina tiklar ve gecis dogrulanir
      And mobil uygulamamız gorur
      And mobil uygulama alt kisimlarina tiklar ve gecis dogrulanir




