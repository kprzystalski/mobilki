# Zadania

## Zadanie 1 — Nowa etykieta
Dodaj drugi komponent `Text`, który pokaże imię studenta. Po naciśnięciu przycisku `Powitaj` powinien zmienić tekst na `Witaj, [imię]!` (dla wybranego stałego imienia).

**Zwróć uwagę:** jaka zmienna stanu steruje wyświetlanym tekstem?

## Zadanie 2 — Licznik
Dodaj przycisk `Odejmij -1`, który zmniejsza licznik, ale nie pozwala mu zejść poniżej zera. Zaktualizuj etykietę po każdym kliknięciu.

**Podpowiedź:** `if (licznik > 0) { licznik-- }`.

## Zadanie 3 — Nowy układ
Rozdziel interfejs na dwie funkcje `@Composable`: `Naglowek(...)` i `PanelPrzyciskow(...)`. Przekaż tekst, licznik i funkcje `onClick` jako parametry.

**Pytanie:** dlaczego jest to wygodniejsze do testowania i ponownego użycia?

## Zadanie 4 — Porównanie `remember` i `rememberSaveable`

Zamień `rememberSaveable` tylko dla zmiennej `licznik` na `remember`. Kliknij kilka razy i obróć emulator. Zapisz różnicę w zachowaniu. Przywróć `rememberSaveable`.

## Zadanie 5 — Cykl życia
Przygotuj tabelę: **akcja użytkownika → logi cyklu życia**. Przeprowadź scenariusze: uruchomienie aplikacji, Home, powrót do aplikacji, obrót ekranu, przycisk zamknięcia.

**Pytania:**
1. Czy `onCreate()` jest wywoływane po powrocie z tła?
2. Czy `onDestroy()` jest gwarantowane, jeśli system ubije proces?
3. W którym callbacku Activity jest w stanie pierwszoplanowym, możliwym do interakcji?