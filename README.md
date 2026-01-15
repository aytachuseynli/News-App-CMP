# 📰 News-KMP

A **Kotlin Multiplatform News Application** targeting **Android** and **iOS**, built with **Compose Multiplatform** and structured using **Clean Architecture + MVVM**.

This project demonstrates how to build a scalable, maintainable, and production-ready multiplatform application with shared UI and business logic.

---

## ✨ Project Goals

- Share UI and business logic across Android & iOS
- Apply Clean Architecture in a Multiplatform environment
- Build a state-driven and testable codebase
- Work with real remote API data
- Keep platform-specific code minimal

---

## 📱 Features

- **Top Headlines** – Browse the latest news headlines
- **Search** – Search news articles by keywords
- **Categories** – Explore news by category
- **Favorites** – Save and manage favorite articles locally
- **Article Details** – Read full article content with save/unsave functionality

---
## 🖼 Screenshots

<div style="display: flex; justify-content: center; gap: 10px; flex-wrap: wrap;">
  <img width="180" alt="Home" src="https://github.com/user-attachments/assets/a97646f0-84b5-46f4-9537-d00134bdcf9a" />
  <img width="180" alt="Detail" src="https://github.com/user-attachments/assets/8ebb95c5-88c3-4f18-9562-dd55d68f602b" />
  <img width="180" alt="Favorites" src="https://github.com/user-attachments/assets/164c597b-5643-4180-afda-c396796e3001" />
  <img width="180" alt="Categories" src="https://github.com/user-attachments/assets/ef835f79-afb0-4ddc-b7cb-5c572b5f74d5" />
  <img width="180" alt="Filtered Categorie" src="https://github.com/user-attachments/assets/868a4632-a8ef-45d2-8cef-58f0c8098091" />
</div>


---
## 🧱 Architecture

The project follows **Clean Architecture**, ensuring a clear separation of concerns:

```
┌─────────────────────────────────────┐
│       Presentation Layer            │
│   ┌─────────────────────────────┐   │
│   │  Screens │ ViewModels │ UI  │   │
│   └─────────────────────────────┘   │
├─────────────────────────────────────┤
│          Domain Layer               │
│   ┌─────────────────────────────┐   │
│   │  Use Cases │ Business Models│   │
│   │    Repository Interfaces    │   │
│   └─────────────────────────────┘   │
├─────────────────────────────────────┤
│           Data Layer                │
│   ┌─────────────────────────────┐   │
│   │  API Services │ DTOs/Mappers│   │
│   │       Local Database        │   │
│   └─────────────────────────────┘   │
└─────────────────────────────────────┘
```

This architecture keeps the application **platform-agnostic**, **scalable**, and **easy to maintain**.

---

## 🛠 Tech Stack

| Category | Technology |
|----------|------------|
| Language | Kotlin 2.2.0 |
| UI Framework | Compose Multiplatform 1.8.2 |
| Architecture | MVVM + Clean Architecture |
| Networking | Ktor Client 3.2.2 |
| Database | SQLDelight 2.1.0 |
| Dependency Injection | Koin 4.1.0 |
| Image Loading | Coil 3.2.0 |
| Serialization | Kotlinx Serialization 1.9.0 |
| Navigation | JetBrains Compose Navigation |

---

## 📂 Project Structure

```
composeApp/
├── src/
│   ├── commonMain/kotlin/com/aytachuseynli/news_kmp/
│   │   ├── app/
│   │   ├── core/
│   │   ├── database/
│   │   ├── di/
│   │   ├── feature/
│   │   │   ├── data/
│   │   │   ├── domain/
│   │   │   └── presentation/
│   │   └── navigation/
│   ├── androidMain/
│   └── iosMain/
└── iosApp/
```

---

## ⚙️ Prerequisites

- Android Studio Hedgehog or later
- Xcode 15+
- JDK 11+
- NewsAPI API key -[NewsAPI](https://newsapi.org/)

---

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/News-KMP.git
cd News-KMP
```

### Add your API key

The app uses [NewsAPI](https://newsapi.org/) to fetch news data.
Add your API key to the appropriate configuration file.

### Run on Android

```bash
./gradlew :composeApp:assembleDebug
```

### Run on iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run on a simulator or device.

---

## 🏗 Build

```bash
./gradlew :composeApp:assembleDebug
./gradlew :composeApp:assembleRelease
./gradlew build
```

---

## 📌 Notes

This project is part of my personal portfolio and reflects my approach to real-world Android and Kotlin Multiplatform application development.

---

## 🔗 Learn More

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [NewsAPI Documentation](https://newsapi.org/docs)
