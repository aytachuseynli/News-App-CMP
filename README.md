# News-KMP

A Kotlin Multiplatform news application targeting **Android** and **iOS**, built with Compose Multiplatform and following clean architecture principles.

## Features

- **Top Headlines** - Browse the latest news headlines
- **Search** - Search news articles by keywords
- **Trends** - Explore news sources by category
- **Favorites** - Save and manage favorite articles locally
- **Article Details** - Read full article details with save/unsave functionality

## Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Kotlin 2.2.0 |
| **UI Framework** | Compose Multiplatform 1.8.2 |
| **Architecture** | MVVM + Clean Architecture |
| **Networking** | Ktor Client 3.2.2 |
| **Database** | SQLDelight 2.1.0 |
| **Dependency Injection** | Koin 4.1.0 |
| **Image Loading** | Coil 3.2.0 |
| **Serialization** | Kotlinx Serialization 1.9.0 |
| **Navigation** | Jetbrains Compose Navigation |

## Architecture

The project follows **Clean Architecture** with clear separation of concerns:

```
┌─────────────────────────────────────┐
│         Presentation Layer          │
│   (Screens, ViewModels, UI State)   │
├─────────────────────────────────────┤
│           Domain Layer              │
│  (Use Cases, Models, Repositories)  │
├─────────────────────────────────────┤
│            Data Layer               │
│ (DTOs, Mappers, API Service, DB)    │
└─────────────────────────────────────┘
```

## Project Structure

```
composeApp/
├── src/
│   ├── commonMain/kotlin/com/aytachuseynli/news_kmp/
│   │   ├── app/              # App entry point
│   │   ├── core/             # Base classes, utilities
│   │   ├── database/         # Database setup
│   │   ├── di/               # Koin modules
│   │   ├── feature/
│   │   │   ├── data/         # DTOs, mappers, repositories
│   │   │   ├── domain/       # Models, use cases
│   │   │   └── presentation/ # Screens, ViewModels
│   │   └── navigation/       # Navigation setup
│   ├── androidMain/          # Android-specific code
│   └── iosMain/              # iOS-specific code
└── iosApp/                   # iOS app entry point
```

## Prerequisites

- Android Studio Hedgehog or later
- Xcode 15+ (for iOS)
- JDK 11+
- [NewsAPI](https://newsapi.org/) API key

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/News-App-CMP.git
   cd News-App-CMP
   ```

2. **Add your API key**

   Create or update the API key configuration in your project. The app uses [NewsAPI](https://newsapi.org/) for fetching news data.

3. **Run on Android**
   ```bash
   ./gradlew :composeApp:assembleDebug
   ```
   Or run directly from Android Studio.

4. **Run on iOS**

   Open `iosApp/iosApp.xcodeproj` in Xcode and run on a simulator or device.

## Build

```bash
# Android Debug APK
./gradlew :composeApp:assembleDebug

# Android Release APK
./gradlew :composeApp:assembleRelease

# Check all targets
./gradlew build
```

## Learn More

- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [NewsAPI Documentation](https://newsapi.org/docs)
