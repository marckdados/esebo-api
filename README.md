# Esebo Api

- Meu projeto pessoal que serve como conclusão de curso e portfólio.

```mermaid
classDiagram
  class User {
    -id: int
    -username: string
    -email: string
    -password: string
  }

  class Book {
    -id: int
    -title: string
    -author: string
    -condition: string
  }

  class SaleListing {
    -id: int
    -user: User
    -book: Book
    -price: float
  }

  class TradeListing {
    -id: int
    -user: User
    -book: Book
  }

  User -- Book : 1...n
  User -- SaleListing : 1...n
  User -- TradeListing : 1...n
  SaleListing -- Book : 1...1
  TradeListing -- Book : 1...1
```
