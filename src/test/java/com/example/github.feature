Feature: Résolution d'équations du second degré
  En tant qu'utilisateur, je veux pouvoir résoudre des équations du second degré pour obtenir leurs solutions.

  Scenario: Équation avec deux solutions réelles
    Given l'équation du second degré avec coefficients a = 1, b = -3, c = 2
    When je résous l'équation
    Then les solutions de l'équation sont x1 = 1 et x2 = 2

  Scenario: Équation avec une solution réelle
    Given l'équation du second degré avec coefficients a = 1, b = -2, c = 1
    When je résous l'équation
    Then la solution de l'équation est x = 1

  # Scenario: Équation sans solution réelle
  #   Given l'équation du second degré avec coefficients a = 1, b = 3, c = 2
  #   When je résous l'équation
  #   Then l'équation n'a pas de solutions réelles
